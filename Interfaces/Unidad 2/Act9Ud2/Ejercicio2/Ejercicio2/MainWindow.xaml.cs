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

            Grid grid = new Grid();
            this.Content = grid;

            Button button = new Button
            {
                FontWeight = FontWeights.Bold,

            };

            WrapPanel wrapPanel = new WrapPanel();

            TextBlock textBlock = new TextBlock
            {
                Text = "Texto",
                Foreground = Brushes.Green
            };

            TextBlock textBlock1 = new TextBlock
            {
                Text = "multi",
                Foreground = Brushes.Blue
            };

            TextBlock textBlock2 = new TextBlock
            {
                Text = "color"
            };

            wrapPanel.Children.Add(textBlock);
            wrapPanel.Children.Add(textBlock1);
            wrapPanel.Children.Add(textBlock2);

            button.Content = wrapPanel;

            grid.Children.Add(button);
        }
    }
}
