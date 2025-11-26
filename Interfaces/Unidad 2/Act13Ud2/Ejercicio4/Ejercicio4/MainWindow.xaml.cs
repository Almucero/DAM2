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

namespace Ejercicio4
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
        private void Confirmar_Click(object sender, RoutedEventArgs e)
        {
            if (cmbFrutas.SelectedItem is ComboBoxItem item)
            {
                string fruta = item.Content.ToString();
                MessageBoxResult result = MessageBox.Show($"¿Quieres confirmar tu selección de {fruta}?", "Confirmación", MessageBoxButton.YesNoCancel, MessageBoxImage.Question);
                switch (result)
                {
                    case MessageBoxResult.Yes:
                        MessageBox.Show($"Has confirmado {fruta}");
                        break;

                    case MessageBoxResult.No:
                        MessageBox.Show($"Has rechazado {fruta}");
                        break;

                    case MessageBoxResult.Cancel:
                        MessageBox.Show("No se realizó ninguna acción.");
                        break;
                }
            }
            else
            {
                MessageBox.Show("Selecciona una fruta primero.");
            }
        }
    }
}
