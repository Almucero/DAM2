using System.Windows;
using System.Windows.Media;

namespace Ejercicio2
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public static readonly DependencyProperty ColorDeFondoTextoProperty = DependencyProperty.Register("ColorDeFondoTexto", typeof(Brush), typeof(MainWindow), new PropertyMetadata(Brushes.White));
        public Brush ColorDeFondoTexto
        {
            get { return (Brush)GetValue(ColorDeFondoTextoProperty); }
            set { SetValue(ColorDeFondoTextoProperty, value); }
        }
        public MainWindow()
        {
            InitializeComponent();
            MiTextBox.Background = ColorDeFondoTexto;
        }
        private void CambiarFondo_Click(object sender, RoutedEventArgs e)
        {
            ColorDeFondoTexto = ColorDeFondoTexto == Brushes.Red ? Brushes.Green : Brushes.Red;
            MiTextBox.Background = ColorDeFondoTexto;
        }
    }
}
