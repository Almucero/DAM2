using System;
using System.Globalization;
using System.Windows;
using System.Windows.Data;

namespace Ejercicio5
{
    //Vaina loca para chequear la puntuación
    public class MayorQueConverter : IValueConverter
    {
        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
        {
            int puntuacion = (int)value;
            int umbral = int.Parse((string)parameter);
            return puntuacion > umbral;
        }
        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
        {
            throw new NotImplementedException();
        }
    }
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            this.DataContext = this;
        }
        public static readonly DependencyProperty PuntuacionProperty =
            DependencyProperty.Register("Puntuacion", typeof(int), typeof(MainWindow), new PropertyMetadata(50));
        public int Puntuacion
        {
            get { return (int)GetValue(PuntuacionProperty); }
            set { SetValue(PuntuacionProperty, value); }
        }
        private void btnPuntuacion_Click(object sender, RoutedEventArgs e)
        {
            if (Puntuacion < 100)
            {
                Puntuacion += 10;
            }
            else
            {
                Puntuacion = 0;
            }
        }
    }
}