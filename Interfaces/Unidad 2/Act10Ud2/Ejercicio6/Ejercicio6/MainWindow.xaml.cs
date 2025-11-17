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

namespace Ejercicio6
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
        private void Actualizar_Click(object sender, RoutedEventArgs e)
        {
            MainTextBlock.Inlines.Clear();

            if (chkAlt.IsChecked == true)
            {
                MainTextBlock.Inlines.Add(new Run("Ahora hay una "));

                var underline = new Underline(new Run("parte subrayada"));
                underline.Foreground = Brushes.DarkGreen;
                MainTextBlock.Inlines.Add(underline);

                MainTextBlock.Inlines.Add(new Run(" y una"));

                var bold = new Bold(new Run(" palabra en negrita"));
                bold.Foreground = Brushes.Black;
                MainTextBlock.Inlines.Add(bold);

                MainTextBlock.Inlines.Add(new Run(" aquí."));
            }
            else
            {
                MainTextBlock.Inlines.Add(new Run("Texto simple sin formato."));
            }
        }
    }
}
