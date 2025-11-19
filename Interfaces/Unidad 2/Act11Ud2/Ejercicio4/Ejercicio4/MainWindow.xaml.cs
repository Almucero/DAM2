using System.Windows;

namespace Ejercicio4
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
        private void BtnAceptar_Click(object sender, RoutedEventArgs e)
        {
            string nivel;
            if (rbBajo.IsChecked == true) nivel = "Bajo";
            else if (rbMedio.IsChecked == true) nivel = "Medio";
            else nivel = "Alto";
            string contra = pwdContra.Password ?? string.Empty;
            if (contra.Length > 6)
            {
                MessageBox.Show($"Nivel: {nivel}\nContraseña: {contra}", "Datos", MessageBoxButton.OK, MessageBoxImage.Information);
            }
            else
            {
                MessageBox.Show("La contraseña debe tener más de 6 caracteres.", "Aviso", MessageBoxButton.OK, MessageBoxImage.Warning);
            }
        }
    }
}
