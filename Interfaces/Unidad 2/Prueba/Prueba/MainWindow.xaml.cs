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

        private void cb_TodosHaCambiado(object sender, RoutedEventArgs e)
        {
            bool nuevoValor = (cbTodos.IsChecked == true);
            cbChile.IsChecked = nuevoValor;
            cbChampis.IsChecked = nuevoValor;
            cbMozzarela.IsChecked = nuevoValor;
        }
        private void cb_SimpleHaCambiado(object sender, RoutedEventArgs e)
        {
            cbTodos.IsChecked = null;
            if ((cbTodos.IsChecked == true) && (cbChampis.IsChecked == true) && (cbMozzarela.IsChecked == true))
            {
                cbTodos.IsChecked = true;
            }
            else if ((cbChile.IsChecked == false) && (cbChampis.IsChecked == false) && (cbMozzarela.IsChecked == false))
            {
                cbTodos.IsChecked = false;
            }
        }
    }
}
