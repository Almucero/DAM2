using System.Windows;
using System.Windows.Controls;

namespace MiLibreriaWPF
{
    public partial class CampoDeTextoDP : UserControl
    {
        public CampoDeTextoDP() => InitializeComponent();
        public static readonly DependencyProperty EtiquetaProperty =
            DependencyProperty.Register("Etiqueta", typeof(string), typeof(CampoDeTextoDP), new PropertyMetadata("Etiqueta"));
        public string Etiqueta
        {
            get { return (string)GetValue(EtiquetaProperty); }
            set { SetValue(EtiquetaProperty, value); }
        }
        public static readonly DependencyProperty ValorProperty =
            DependencyProperty.Register("Valor", typeof(string), typeof(CampoDeTextoDP), new FrameworkPropertyMetadata("", FrameworkPropertyMetadataOptions.BindsTwoWayByDefault));
        public string Valor
        {
            get { return (string)GetValue(ValorProperty); }
            set { SetValue(ValorProperty, value); }
        }
    }
}