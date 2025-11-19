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
        private void BtnPagar_Click(object sender, RoutedEventArgs e)
        {
            string metodo;
            if (rbTarjeta.IsChecked == true) metodo = "Tarjeta de Crédito";
            else if (rbPaypal.IsChecked == true) metodo = "PayPal";
            else metodo = "Transferencia";
            string contra = pwdContra.Password;
            if (contra == "1234")
            {
                MessageBox.Show($"Pago realizado con {metodo}.", "Éxito", MessageBoxButton.OK, MessageBoxImage.Information);
            }
            else
            {
                MessageBox.Show("Contraseña incorrecta.", "Error", MessageBoxButton.OK, MessageBoxImage.Error);
            }
        }
    }
}
