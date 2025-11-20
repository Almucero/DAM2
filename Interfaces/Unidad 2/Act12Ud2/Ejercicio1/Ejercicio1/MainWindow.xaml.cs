using System.Windows;

namespace Ejercicio1
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public int TamañoTexto
        {
            get { return (int)GetValue(TamañoTextoProperty); }
            set { SetValue(TamañoTextoProperty, value); }
        }
        public static readonly DependencyProperty TamañoTextoProperty = DependencyProperty.Register("TamañoTexto", typeof(int), typeof(MainWindow), new PropertyMetadata(20));
        public MainWindow()
        {
            InitializeComponent();
            this.DataContext = this;
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            TamañoTexto += 2;
        }
    }
}
