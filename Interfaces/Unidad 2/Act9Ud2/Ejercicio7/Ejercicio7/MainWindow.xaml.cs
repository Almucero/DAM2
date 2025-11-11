using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Ejercicio7
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

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            int[] numeros = new int[3];
            numeros[5] = 10;
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            try
            {
                int[] numeros = new int[3];
                numeros[5] = 10;
            }
            catch (IndexOutOfRangeException ex)
            {
                MessageBox.Show($"Excepción capturada: {ex.Message}", "Error controlado", MessageBoxButton.OK, MessageBoxImage.Warning);
            }
        }
    }
}
