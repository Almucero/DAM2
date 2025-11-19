using System;
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

        private void No_Seleccionado(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("Esa no es la actitud");
        }
    }
}
