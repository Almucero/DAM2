using System.Windows;
using System.Windows.Controls;

namespace Ejercicio2.Controls
{
    public partial class PriceCard : UserControl
    {
        public PriceCard() => InitializeComponent();

        public static readonly DependencyProperty PrecioProperty =
            DependencyProperty.Register(nameof(Precio), typeof(string), typeof(PriceCard), new PropertyMetadata(""));

        public string Precio
        {
            get => (string)GetValue(PrecioProperty);
            set => SetValue(PrecioProperty, value);
        }

        public static readonly DependencyProperty DescripcionProperty =
            DependencyProperty.Register(nameof(Descripcion), typeof(string), typeof(PriceCard), new PropertyMetadata(""));

        public string Descripcion
        {
            get => (string)GetValue(DescripcionProperty);
            set => SetValue(DescripcionProperty, value);
        }
    }
}
