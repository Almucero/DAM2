using System.Windows;
using System.Windows.Media;

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
        private void cmbTemas_SelectionChanged(object sender, System.Windows.Controls.SelectionChangedEventArgs e)
        {
            if (cmbTemas.SelectedItem is System.Windows.Controls.ComboBoxItem item)
            {
                string tema = item.Content.ToString();
                switch (tema)
                {
                    case "Claro":
                        this.Background = Brushes.White;
                        txtDemo.Foreground = Brushes.Black;
                        txtDemo.FontSize = 16;
                        break;
                    case "Oscuro":
                        this.Background = Brushes.Black;
                        txtDemo.Foreground = Brushes.White;
                        txtDemo.FontSize = 18;
                        break;
                    case "Azul":
                        this.Background = Brushes.Blue;
                        txtDemo.Foreground = Brushes.White;
                        txtDemo.FontSize = 16;
                        break;
                }
            }
        }
    }
}
