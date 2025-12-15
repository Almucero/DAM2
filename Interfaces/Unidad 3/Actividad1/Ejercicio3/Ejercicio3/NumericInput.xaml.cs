using System.Text.RegularExpressions;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;

namespace Ejercicio3.Controls
{
    public partial class NumericInput : UserControl
    {
        public NumericInput() => InitializeComponent();

        public static readonly DependencyProperty ValorProperty =
            DependencyProperty.Register(nameof(Valor), typeof(string), typeof(NumericInput), new FrameworkPropertyMetadata("", FrameworkPropertyMetadataOptions.BindsTwoWayByDefault));

        public string Valor
        {
            get => (string)GetValue(ValorProperty);
            set => SetValue(ValorProperty, value);
        }

        public static readonly DependencyProperty MaxLengthProperty =
            DependencyProperty.Register(nameof(MaxLength), typeof(int), typeof(NumericInput), new PropertyMetadata(int.MaxValue));

        public int MaxLength
        {
            get => (int)GetValue(MaxLengthProperty);
            set => SetValue(MaxLengthProperty, value);
        }
    }
}
