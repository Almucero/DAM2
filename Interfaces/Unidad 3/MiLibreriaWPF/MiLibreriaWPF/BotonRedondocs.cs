using System.Windows;
using System.Windows.Controls;

namespace MiLibreriaWPF
{
    public class BotonRedondo : Button // Heredamos de Button
    {
        static BotonRedondo()
        {
            // Esta línea es VITAL. Sin ella, el control no se verá.
            // Le dice a WPF que use el estilo definido en Generic.xaml en lugar del estilo de Button estándar.
            DefaultStyleKeyProperty.OverrideMetadata(typeof(BotonRedondo),
                new FrameworkPropertyMetadata(typeof(BotonRedondo)));
        }
    }
}