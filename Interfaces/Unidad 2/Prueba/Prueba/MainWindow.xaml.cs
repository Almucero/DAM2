using System.Windows;

namespace Prueba
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public int ColorDeOjos {
            get { return (int)GetValue(ColorDeOjosProperty); }
            set { SetValue(ColorDeOjosProperty, value);}
        }
        public static readonly DependencyProperty ColorDeOjosProperty = DependencyProperty.Register("ColorDeOjos", typeof(int), typeof(MainWindow), new PropertyMetadata(0));

        public int TamañoTexto
        {
            get { return (int)GetValue(TamañoTextoProperty);  }
            set { SetValue(TamañoTextoProperty, value);}
        }
        public static readonly DependencyProperty TamañoTextoProperty = DependencyProperty.Register("TamañoTexto", typeof(int), typeof(MainWindow), new PropertyMetadata(20));

        public MainWindow()
        {
            InitializeComponent();
            MiSlider.Value = 30;
            MiTextBox.Text = MiSlider.Value.ToString();
            this.DataContext = this;
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            TamañoTexto += 2;
        }
    }
}
