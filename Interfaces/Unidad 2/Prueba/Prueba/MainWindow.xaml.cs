using System.Windows;
using System.Windows.Input;

namespace Prueba
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

        private void Window_PreviewMouseDown(object sender, MouseButtonEventArgs e)
        {
            MessageBox.Show("Window");
        }

        private void StackPanel_PreviewMouseDown(object sender, MouseButtonEventArgs e)
        {
            MessageBox.Show("StackPanel");
        }

        private void Button_PreviewMouseDown(object sender, MouseButtonEventArgs e)
        {
            MessageBox.Show("Button");
        }

        private void Button_MouseEnter(object sender, MouseEventArgs e)
        {
            MessageBox.Show("Ratón");
        }
    }
}
