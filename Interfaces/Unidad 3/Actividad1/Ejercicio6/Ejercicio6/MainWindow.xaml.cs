using System.Windows;

namespace Ejercicio6
{
    public partial class MainWindow : Window
    {
        public double Latitud { get; set; } = 40.4168;
        public double Longitud { get; set; } = -3.7038;
        public MainWindow()
        {
            InitializeComponent();
            DataContext = this;
        }
    }
}
