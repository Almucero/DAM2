using System.Windows;
using System.Windows.Controls;

namespace Ejercicio5.Controls
{
    public partial class FixedLengthInput : UserControl
    {
        public FixedLengthInput() => InitializeComponent();
        public static readonly DependencyProperty ValorProperty =
            DependencyProperty.Register(nameof(Valor), typeof(string), typeof(FixedLengthInput), new FrameworkPropertyMetadata("", FrameworkPropertyMetadataOptions.BindsTwoWayByDefault));
        public string Valor
        {
            get => (string)GetValue(ValorProperty);
            set => SetValue(ValorProperty, value);
        }
        public static readonly DependencyProperty LongitudMáximaProperty =
            DependencyProperty.Register(nameof(LongitudMáxima), typeof(int), typeof(FixedLengthInput), new PropertyMetadata(0));
        public int LongitudMáxima
        {
            get => (int)GetValue(LongitudMáximaProperty);
            set => SetValue(LongitudMáximaProperty, value);
        }
        public static readonly DependencyProperty PlaceholderProperty =
            DependencyProperty.Register(nameof(Placeholder), typeof(string), typeof(FixedLengthInput), new PropertyMetadata(""));
        public string Placeholder
        {
            get => (string)GetValue(PlaceholderProperty);
            set => SetValue(PlaceholderProperty, value);
        }
    }
}
