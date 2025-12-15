using System.Windows;

namespace Ejercicio5
{
    public partial class MainWindow : Window
    {
        public string CodigoPostal { get; set; } = "";
        public string PINUsuario { get; set; } = "";
        public MainWindow()
        {
            InitializeComponent();
            DataContext = this;
        }
    }
}
