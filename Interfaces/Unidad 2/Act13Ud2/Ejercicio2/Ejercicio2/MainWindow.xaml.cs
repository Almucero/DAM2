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
        }

        private string ObtenerCategoria()
        {
            if (cmbCategoria.SelectedItem is ComboBoxItem item)
                return item.Content.ToString();

            return "Ninguna categoría seleccionada";
        }

        private void Accion1_Click(object sender, RoutedEventArgs e)
        {
            MessageBox.Show($"Has realizado Acción 1 en la {ObtenerCategoria()}");
        }

        private void Accion2_Click(object sender, RoutedEventArgs e)
        {
            MessageBox.Show($"Has realizado Acción 2 en la {ObtenerCategoria()}");
        }

        private void Accion3_Click(object sender, RoutedEventArgs e)
        {
            MessageBox.Show($"Has realizado Acción 3 en la {ObtenerCategoria()}");
        }
    }
}
