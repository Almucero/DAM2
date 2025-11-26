using System.Windows;

namespace Ejercicio5
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }
        private void Validar_Click(object sender, RoutedEventArgs e)
        {
            string texto = txtEdad.Text;

            if (string.IsNullOrWhiteSpace(texto))
            {
                MessageBox.Show("El campo está vacío.");
                return;
            }

            if (int.TryParse(texto, out int edad))
            {
                MessageBox.Show("Edad válida.");
            }
            else
            {
                MessageBox.Show("Por favor, introduce un número válido.");
            }
        }
    }
}
