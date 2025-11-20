using System.Windows;

namespace Ejercicio4
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public static readonly DependencyProperty TextoUsuarioProperty = DependencyProperty.Register("TextoUsuario", typeof(string), typeof(MainWindow), new PropertyMetadata(string.Empty));
        public string TextoUsuario
        {
            get { return (string)GetValue(TextoUsuarioProperty); }
            set { SetValue(TextoUsuarioProperty, value); }
        }
        public MainWindow()
        {
            InitializeComponent();
            DataContext = this;
        }
        private void Button_Click(object sender, RoutedEventArgs e)
        {
            TextoUsuario = textoUsuarioTextBox.Text;
        }
    }
}
