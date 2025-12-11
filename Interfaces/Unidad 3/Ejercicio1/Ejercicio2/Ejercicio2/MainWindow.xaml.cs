using System.Windows;

namespace Ejercicio2
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public string PrecioPremium { get; } = "€99.99";
        public MainWindow()
        {
            InitializeComponent();
            DataContext = this;
        }
    }
}
