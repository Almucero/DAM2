using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Media;
using System.Collections.Generic;
using System.Linq;
using System.Globalization;
using LibreriaVisualFinal.Controls;

namespace ProyectoFinalUd2
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        DatabaseHelper db;
        List<Producto> productosActuales;
        private static readonly Random _rand = new Random();
        private bool _isUpdatingText = false;

        public MainWindow()
        {
            InitializeComponent();
            try
            {
                db = new DatabaseHelper();
                CargarCategorias();
                LimpiarFormulario();
                if (miBoton != null)
                {
                    miBoton.Click += MiBoton_Click;
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error al iniciar la base de datos o componentes: " + ex.Message);
            }
        }
        private void MiBoton_Click(object sender, RoutedEventArgs e)
        {
            string mensaje = $"Acción lanzada a las {DateTime.Now:HH:mm:ss}";
            miVisor.MensajeAccion = mensaje;
            double valorAleatorio = _rand.NextDouble() * 100.0;
            miVisor.ProgresoValor = valorAleatorio;
        }
        private void CargarCategorias()
        {
            lstCategorias.ItemsSource = db.GetCategorias();
            if (lstCategorias.Items.Count > 0)
            {
                lstCategorias.SelectedIndex = 0;
            }
        }

        private void lstCategorias_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (lstCategorias.SelectedValue != null)
            {
                int catId = (int)lstCategorias.SelectedValue;
                productosActuales = db.GetProductosPorCategoria(catId);
                gridProductos.ItemsSource = productosActuales;
                LimpiarFormulario();
                txtBuscar.Clear();
            }
        }

        private void gridProductos_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (gridProductos.SelectedItem is Producto p)
            {
                _isUpdatingText = true;
                try
                {
                    txtNombre.Text = p.Nombre;
                    txtPrecio.Text = p.Precio.ToString("0.00", CultureInfo.InvariantCulture);
                    txtStock.Text = p.Stock.ToString();
                }
                finally
                {
                    _isUpdatingText = false;
                }
            }
            else
            {
                LimpiarFormulario();
            }
        }

        private void btnGuardar_Click(object sender, RoutedEventArgs e)
        {
            if (lstCategorias.SelectedValue == null)
            {
                MessageBox.Show("Por favor, selecciona una categoría primero.", "Error", MessageBoxButton.OK, MessageBoxImage.Warning);
                return;
            }
            if (!ValidarFormulario()) return;
            try
            {
                Producto p = new Producto
                {
                    Nombre = txtNombre.Text.Trim(),
                    Precio = double.Parse(txtPrecio.Text.Replace(',', '.'), CultureInfo.InvariantCulture),
                    Stock = int.Parse(txtStock.Text),
                    CategoriaId = (int)lstCategorias.SelectedValue
                };

                if (gridProductos.SelectedItem == null || gridProductos.SelectedItem as Producto == null)
                {
                    db.AddProducto(p);
                    MessageBox.Show("✅ Producto añadido correctamente.", "Éxito", MessageBoxButton.OK, MessageBoxImage.Information);
                }
                else
                {
                    p.Id = ((Producto)gridProductos.SelectedItem).Id;
                    db.UpdateProducto(p);
                    MessageBox.Show("✅ Producto actualizado correctamente.", "Éxito", MessageBoxButton.OK, MessageBoxImage.Information);
                }

                lstCategorias_SelectionChanged(null, null);
                LimpiarFormulario();
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Ocurrió un error al guardar los datos: {ex.Message}", "Error de Base de Datos", MessageBoxButton.OK, MessageBoxImage.Error);
            }
        }

        private void btnEliminar_Click(object sender, RoutedEventArgs e)
        {
            if (gridProductos.SelectedItem is Producto p)
            {
                if (MessageBox.Show($"¿Estás seguro de que quieres eliminar el producto '{p.Nombre}'?", "Confirmar Eliminación", MessageBoxButton.YesNo, MessageBoxImage.Question) == MessageBoxResult.Yes)
                {
                    db.DeleteProducto(p.Id);
                    lstCategorias_SelectionChanged(null, null);
                    LimpiarFormulario();
                    MessageBox.Show("🗑️ Producto eliminado correctamente.", "Éxito", MessageBoxButton.OK, MessageBoxImage.Information);
                }
            }
            else
            {
                MessageBox.Show("Debes seleccionar un producto del listado para poder eliminarlo.", "Atención", MessageBoxButton.OK, MessageBoxImage.Warning);
            }
        }

        private void btnLimpiar_Click(object sender, RoutedEventArgs e)
        {
            LimpiarFormulario();
        }

        private void LimpiarFormulario()
        {
            _isUpdatingText = true;
            try
            {
                txtNombre.Clear();
                txtPrecio.Clear();
                txtStock.Clear();
                gridProductos.SelectedItem = null;
            }
            finally
            {
                _isUpdatingText = false;
            }
            txtNombre.Focus();
        }

        private void txtBuscar_TextChanged(object sender, TextChangedEventArgs e)
        {
            if (productosActuales != null)
            {
                string filtro = txtBuscar.Text.ToLower().Trim();
                var filtrados = productosActuales
                    .Where(p => p.Nombre.ToLower().Contains(filtro)).ToList();

                gridProductos.ItemsSource = filtrados;
            }
        }

        private void NumericTextBox_TextChanged(object sender, TextChangedEventArgs e)
        {
            if (_isUpdatingText) return;
            TextBox textBox = sender as TextBox;
            if (textBox == null) return;
            _isUpdatingText = true;
            try
            {
                string text = textBox.Text;
                string newText = "";
                bool hasDecimal = false;
                foreach (char c in text)
                {
                    if (char.IsDigit(c))
                    {
                        newText += c;
                    }
                    else if ((c == '.' || c == ',') && !hasDecimal)
                    {
                        newText += c;
                        hasDecimal = true;
                    }
                }
                if (newText != text)
                {
                    int caretIndex = textBox.CaretIndex;
                    textBox.Text = newText;
                    int newCaretIndex = caretIndex - (text.Length - newText.Length);
                    textBox.CaretIndex = Math.Max(0, Math.Min(newCaretIndex, newText.Length));
                }
            }
            finally
            {
                _isUpdatingText = false;
            }
        }

        private bool ValidarFormulario()
        {
            if (string.IsNullOrWhiteSpace(txtNombre.Text))
            {
                MessageBox.Show("El campo 'Nombre del Producto' es obligatorio.", "Validación", MessageBoxButton.OK, MessageBoxImage.Warning);
                txtNombre.Focus();
                return false;
            }
            string precioText = txtPrecio.Text.Replace(',', '.');
            if (!double.TryParse(precioText, NumberStyles.Any, CultureInfo.InvariantCulture, out double precio) || precio <= 0)
            {
                MessageBox.Show("El campo 'Precio' debe ser un número positivo (ej: 19.99).", "Validación", MessageBoxButton.OK, MessageBoxImage.Warning);
                txtPrecio.Focus();
                return false;
            }
            if (!int.TryParse(txtStock.Text, out int stock) || stock < 0)
            {
                MessageBox.Show("El campo 'Stock' debe ser un número entero no negativo.", "Validación", MessageBoxButton.OK, MessageBoxImage.Warning);
                txtStock.Focus();
                return false;
            }
            return true;
        }
    }
    public class ColorToLighterConverter : IValueConverter
    {
        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
        {
            if (value is SolidColorBrush brush)
            {
                Color color = brush.Color;
                if (parameter is string param)
                {
                    if (double.TryParse(param, NumberStyles.Float, CultureInfo.InvariantCulture, out double factor))
                    {
                        if (factor > 0)
                        {
                            color = Color.FromRgb(
                                (byte)Math.Min(255, color.R + (255 - color.R) * factor),
                                (byte)Math.Min(255, color.G + (255 - color.G) * factor),
                                (byte)Math.Min(255, color.B + (255 - color.B) * factor));
                        }
                        else
                        {
                            color = Color.FromRgb(
                                (byte)(color.R * (1 + factor)),
                                (byte)(color.G * (1 + factor)),
                                (byte)(color.B * (1 + factor)));
                        }
                        return new SolidColorBrush(color);
                    }
                }
            }
            return value;
        }
        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
        {
            throw new NotImplementedException();
        }
    }
}