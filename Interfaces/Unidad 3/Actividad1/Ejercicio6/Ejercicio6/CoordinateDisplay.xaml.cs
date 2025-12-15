using System.Windows;
using System.Windows.Controls;

namespace Ejercicio6.Controls
{
    public partial class CoordinateDisplay : UserControl
    {
        public CoordinateDisplay() => InitializeComponent();
        public static readonly DependencyProperty TituloProperty =
            DependencyProperty.Register(nameof(Titulo), typeof(string), typeof(CoordinateDisplay), new PropertyMetadata(""));
        public string Titulo
        {
            get => (string)GetValue(TituloProperty);
            set => SetValue(TituloProperty, value);
        }
        public static readonly DependencyProperty CoordenadaXProperty =
            DependencyProperty.Register(nameof(CoordenadaX), typeof(double), typeof(CoordinateDisplay), new PropertyMetadata(0.0));
        public double CoordenadaX
        {
            get => (double)GetValue(CoordenadaXProperty);
            set => SetValue(CoordenadaXProperty, value);
        }
        public static readonly DependencyProperty CoordenadaYProperty =
            DependencyProperty.Register(nameof(CoordenadaY), typeof(double), typeof(CoordinateDisplay), new PropertyMetadata(0.0));
        public double CoordenadaY
        {
            get => (double)GetValue(CoordenadaYProperty);
            set => SetValue(CoordenadaYProperty, value);
        }
    }
}
