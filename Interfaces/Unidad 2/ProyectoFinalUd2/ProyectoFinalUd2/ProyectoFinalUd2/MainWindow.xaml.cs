using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data; // Necesario para IValueConverter
using System.Windows.Media;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using System.Globalization; // Necesario para IValueConverter

namespace ProyectoFinalUd2
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        DatabaseHelper db;
        // Colección completa de productos de la categoría actual para realizar el filtro en memoria
        List<Producto> productosActuales;

        public MainWindow()
        {
            InitializeComponent();
            // Inicializar la base de datos (creará el archivo TiendaRopa.db y las tablas si no existen)
            db = new DatabaseHelper();
            CargarCategorias();
            LimpiarFormulario();
        }

        private void CargarCategorias()
        {
            // Cargar la lista principal (Categorías)
            lstCategorias.ItemsSource = db.GetCategorias();
            // Seleccionar la primera categoría por defecto si existe
            if (lstCategorias.Items.Count > 0)
            {
                lstCategorias.SelectedIndex = 0;
            }
        }

        // --- EVENTOS PRINCIPALES ---

        // Requisito: Sincronización 1:N: Al seleccionar una Categoría
        private void lstCategorias_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (lstCategorias.SelectedValue != null)
            {
                int catId = (int)lstCategorias.SelectedValue;
                // Cargar solo los productos que pertenecen a esta categoría (N)
                productosActuales = db.GetProductosPorCategoria(catId);
                gridProductos.ItemsSource = productosActuales;
                LimpiarFormulario();
                txtBuscar.Clear(); // Limpiar el filtro al cambiar de categoría
            }
        }

        // Requisito: Al seleccionar un Producto en el DataGrid (para editarlo)
        private void gridProductos_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (gridProductos.SelectedItem is Producto p)
            {
                // Rellenar el formulario con los datos del producto seleccionado
                txtNombre.Text = p.Nombre;
                // Formatear el precio para mostrar dos decimales
                txtPrecio.Text = p.Precio.ToString("0.00", CultureInfo.InvariantCulture);
                txtStock.Text = p.Stock.ToString();
            }
            else
            {
                // Si la selección se borra (ej. después de un guardado/eliminado)
                LimpiarFormulario();
            }
        }

        // Requisito: Botón Guardar (Insertar o Actualizar)
        private void btnGuardar_Click(object sender, RoutedEventArgs e)
        {
            if (lstCategorias.SelectedValue == null)
            {
                MessageBox.Show("Por favor, selecciona una categoría primero.", "Error", MessageBoxButton.OK, MessageBoxImage.Warning);
                return;
            }

            // Validar que los campos no estén vacíos y sean numéricos
            if (!ValidarFormulario()) return;

            try
            {
                // Usar CultureInfo.InvariantCulture para manejar el punto decimal consistentemente
                Producto p = new Producto
                {
                    Nombre = txtNombre.Text.Trim(),
                    Precio = double.Parse(txtPrecio.Text.Replace(',', '.'), CultureInfo.InvariantCulture),
                    Stock = int.Parse(txtStock.Text),
                    CategoriaId = (int)lstCategorias.SelectedValue
                };

                if (gridProductos.SelectedItem == null || gridProductos.SelectedItem as Producto == null)
                {
                    // Es un NUEVO registro (INSERT)
                    db.AddProducto(p);
                    MessageBox.Show("✅ Producto añadido correctamente.", "Éxito", MessageBoxButton.OK, MessageBoxImage.Information);
                }
                else
                {
                    // Es una ACTUALIZACIÓN (UPDATE)
                    p.Id = ((Producto)gridProductos.SelectedItem).Id;
                    db.UpdateProducto(p);
                    MessageBox.Show("✅ Producto actualizado correctamente.", "Éxito", MessageBoxButton.OK, MessageBoxImage.Information);
                }

                // Refrescar lista y limpiar
                lstCategorias_SelectionChanged(null, null);
                LimpiarFormulario();
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Ocurrió un error al guardar los datos: {ex.Message}", "Error de Base de Datos", MessageBoxButton.OK, MessageBoxImage.Error);
            }
        }

        // Requisito: Botón Eliminar
        private void btnEliminar_Click(object sender, RoutedEventArgs e)
        {
            if (gridProductos.SelectedItem is Producto p)
            {
                // Mensaje de confirmación
                if (MessageBox.Show($"¿Estás seguro de que quieres eliminar el producto '{p.Nombre}'?", "Confirmar Eliminación", MessageBoxButton.YesNo, MessageBoxImage.Question) == MessageBoxResult.Yes)
                {
                    db.DeleteProducto(p.Id);
                    // Refrescar lista y limpiar
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

        // Botón para limpiar el formulario y preparar un nuevo registro
        private void btnLimpiar_Click(object sender, RoutedEventArgs e)
        {
            LimpiarFormulario();
        }

        private void LimpiarFormulario()
        {
            txtNombre.Clear();
            txtPrecio.Clear();
            txtStock.Clear();
            gridProductos.SelectedItem = null; // Deseleccionar la fila en la tabla
            txtNombre.Focus(); // Poner el foco para empezar a escribir
        }

        // --- FUNCIONALIDAD ADICIONAL (REQUISITO FILTRO Y VALIDACIÓN) ---

        // Requisito: Filtro por texto (búsqueda dinámica)
        private void txtBuscar_TextChanged(object sender, TextChangedEventArgs e)
        {
            if (productosActuales != null)
            {
                string filtro = txtBuscar.Text.ToLower().Trim();
                // Filtrar la colección en memoria usando LINQ
                var filtrados = productosActuales
                    .Where(p => p.Nombre.ToLower().Contains(filtro)).ToList();

                gridProductos.ItemsSource = filtrados;
            }
        }

        // Requisito de Diseño/Validación: Solo permitir números en Precio y Stock
        private void NumericTextBox_TextChanged(object sender, TextChangedEventArgs e)
        {
            TextBox textBox = sender as TextBox;
            if (textBox == null) return;

            string text = textBox.Text;
            string newText = "";
            bool hasDecimal = false;

            // Iterar sobre el texto, manteniendo solo dígitos y un único separador decimal
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
                // Restaurar el cursor a la posición correcta
                textBox.CaretIndex = caretIndex - (text.Length - newText.Length);
            }
        }

        // Requisito: Validaciones básicas
        private bool ValidarFormulario()
        {
            if (string.IsNullOrWhiteSpace(txtNombre.Text))
            {
                MessageBox.Show("El campo 'Nombre del Producto' es obligatorio.", "Validación", MessageBoxButton.OK, MessageBoxImage.Warning);
                txtNombre.Focus();
                return false;
            }

            // Reemplazar coma por punto para que double.TryParse funcione independientemente de la cultura del SO
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

    // Convertidor para hacer que el color del botón sea más claro en el hover (Diseño Avanzado)
    // Implementa IValueConverter (requiere using System.Windows.Data y System.Globalization)
    public class ColorToLighterConverter : IValueConverter
    {
        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
        {
            // CORRECCIÓN CLAVE: Asegurarse de que el valor es un SolidColorBrush antes de intentar obtener el Color.
            // Esto soluciona el error "La clave no puede ser nula" al crear el recurso si el casteo fallaba.
            if (value is SolidColorBrush brush)
            {
                Color color = brush.Color;
                if (parameter is string param)
                {
                    if (double.TryParse(param, NumberStyles.Float, CultureInfo.InvariantCulture, out double factor))
                    {
                        if (factor > 0)
                        {
                            // Aclarar
                            color = Color.FromRgb(
                                (byte)Math.Min(255, color.R + (255 - color.R) * factor),
                                (byte)Math.Min(255, color.G + (255 - color.G) * factor),
                                (byte)Math.Min(255, color.B + (255 - color.B) * factor));
                        }
                        else
                        {
                            // Oscurecer
                            color = Color.FromRgb(
                                (byte)(color.R * (1 + factor)),
                                (byte)(color.G * (1 + factor)),
                                (byte)(color.B * (1 + factor)));
                        }
                        return new SolidColorBrush(color);
                    }
                }
            }
            // Si el valor no es el tipo esperado o el factor no es válido, se devuelve el valor original.
            return value;
        }

        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
        {
            throw new NotImplementedException();
        }
    }
}