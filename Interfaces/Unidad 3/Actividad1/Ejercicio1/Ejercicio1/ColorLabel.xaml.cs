using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;

namespace Ejercicio1.Controls
{
    public partial class ColorLabel : UserControl
    {
        public ColorLabel() => InitializeComponent();

        public static readonly DependencyProperty TextoProperty = 
            DependencyProperty.Register(nameof(Texto), typeof(string), typeof(ColorLabel), new PropertyMetadata(""));

        public string Texto
        {
            get => (string)GetValue(TextoProperty);
            set => SetValue(TextoProperty, value);
        }

        public static readonly DependencyProperty ColorDeFondoProperty = 
            DependencyProperty.Register(nameof(ColorDeFondo), typeof(Brush), typeof(ColorLabel), new PropertyMetadata(Brushes.Transparent));

        public Brush ColorDeFondo
        {
            get => (Brush)GetValue(ColorDeFondoProperty);
            set => SetValue(ColorDeFondoProperty, value);
        }
    }
}
