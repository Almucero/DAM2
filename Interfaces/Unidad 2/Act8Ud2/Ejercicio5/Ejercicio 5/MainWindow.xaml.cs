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

namespace Ejercicio_5
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

        private void Button1_Click(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("Evento Button.Click - Un evento de acción directa");
        }

        private void Button2_MouseEnter(object sender, MouseEventArgs e)
        {
            MessageBox.Show("Evento MouseEnter - Detecta cuando el ratón entra en el botón");
        }

        private void Button3_MouseRightButtonDown(object sender, MouseButtonEventArgs e)
        {
            MessageBox.Show("Evento Button_MouseRightButtonDown - Un evento de clic específico con el botón derecho");
        }
    }
}
