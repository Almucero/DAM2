using System.Windows;
using System.Windows.Controls;

namespace LibreriaVisualFinal.Controls
{
    public partial class VisorProgreso : UserControl
    {
        public VisorProgreso() => InitializeComponent();
        public static readonly DependencyProperty MensajeAccionProperty = 
            DependencyProperty.Register(nameof(MensajeAccion), typeof(string), typeof(VisorProgreso), new PropertyMetadata("Esperando interacción..."));
        public string MensajeAccion
        {
            get => (string)GetValue(MensajeAccionProperty);
            set => SetValue(MensajeAccionProperty, value);
        }
        public static readonly DependencyProperty ProgresoValorProperty = 
            DependencyProperty.Register(nameof(ProgresoValor), typeof(double), typeof(VisorProgreso), new PropertyMetadata(0.0));
        public double ProgresoValor
        {
            get => (double)GetValue(ProgresoValorProperty);
            set => SetValue(ProgresoValorProperty, value);
        }
    }
}
