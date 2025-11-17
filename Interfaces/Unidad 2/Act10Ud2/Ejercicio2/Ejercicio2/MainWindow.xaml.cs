using System.Windows;
using System.Windows.Controls;

namespace Ejercicio2
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            OutputTextBox.Text = "";
            InputTextBox.Text = "";
        }
        private void InputTextBox_SelectionChanged(object sender, RoutedEventArgs e)
        {
            if (string.IsNullOrEmpty(InputTextBox.SelectedText))
            {
                OutputTextBox.Text = "Has seleccionado: (nada)";
            }
            else
            {
                OutputTextBox.Text = "Has seleccionado: '" + InputTextBox.SelectedText + "'";
            }
        }
    }
}
