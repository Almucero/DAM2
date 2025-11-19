using System.Windows;

namespace Ejercicio3
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private const string usuarioReal = "elmercurio";
        private const string contrasenaReal = "12345678";
        public MainWindow()
        {
            InitializeComponent();
        }
        private void BtnEntrar_Click(object sender, RoutedEventArgs e)
        {
            string usuario = txtUsuario.Text.Trim();
            string password = pwdPassword.Password;

            if (usuario == usuarioReal && password == contrasenaReal)
            {
                MessageBox.Show("Acceso correcto.", "Login", MessageBoxButton.OK, MessageBoxImage.Information);
            }
            else
            {
                MessageBox.Show("Usuario o contraseña incorrectos.", "Login", MessageBoxButton.OK, MessageBoxImage.Warning);
            }
        }
    }
}
