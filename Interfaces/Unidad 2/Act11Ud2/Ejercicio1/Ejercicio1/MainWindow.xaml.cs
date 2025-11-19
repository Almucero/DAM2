using System.Windows;

namespace Ejercicio1
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private int intentos = 0;
        private const int max = 2;
        public MainWindow()
        {
            InitializeComponent();
            Actualizar();
        }
        private void BtnCheck_Click(object sender, RoutedEventArgs e)
        {
            string seleccionado = Seleccion();
            if (seleccionado == null)
            {
                MessageBox.Show("Selecciona una respuesta antes de corregir.", "Atención", MessageBoxButton.OK, MessageBoxImage.Information);
                return;
            }
            intentos++;
            Actualizar();
            if (radio2.IsChecked == true)
            {
                MessageBox.Show("Respuesta correcta", "Resultado", MessageBoxButton.OK, MessageBoxImage.Information);
                Desactivar();
                return;
            }
            else
            {
                if (intentos >= max)
                {
                    MessageBox.Show("Respuesta incorrecta. No te quedan intentos.", "Resultado", MessageBoxButton.OK, MessageBoxImage.Warning);
                    Desactivar();
                    return;
                }
                else
                {
                    MessageBox.Show($"Respuesta incorrecta. Te quedan {max - intentos} intento(s).", "Resultado", MessageBoxButton.OK, MessageBoxImage.Warning);
                }
            }
        }
        private string Seleccion()
        {
            if (radio1.IsChecked == true) return "A";
            if (radio2.IsChecked == true) return "B";
            if (radio3.IsChecked == true) return "C";
            if (radio4.IsChecked == true) return "D";
            return null;
        }
        private void Actualizar()
        {
            int restantes = max - intentos;
            if (restantes > 0)
                tbStatus.Text = $"Intentos restantes: {restantes}";
            else
                tbStatus.Text = "No te quedan intentos.";
        }
        private void Desactivar()
        {
            radio1.IsEnabled = radio2.IsEnabled = radio3.IsEnabled = radio4.IsEnabled = false;
            btnCheck.IsEnabled = false;
        }
    }
}
