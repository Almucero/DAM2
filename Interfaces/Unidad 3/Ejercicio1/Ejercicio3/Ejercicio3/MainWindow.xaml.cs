using System.Windows;

namespace Ejercicio3
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public string Cantidad { get; set; } = "0";
        public string Stock { get; set; } = "100";
        public MainWindow()
        {
            InitializeComponent();
            DataContext = this;
        }
    }
}
