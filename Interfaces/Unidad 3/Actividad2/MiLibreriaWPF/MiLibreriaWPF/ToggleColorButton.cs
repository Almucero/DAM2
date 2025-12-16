using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;

namespace MiLibreriaWPF
{
    public class ToggleColorButton : Button
    {
        static ToggleColorButton()
        {
            DefaultStyleKeyProperty.OverrideMetadata(typeof(ToggleColorButton), new FrameworkPropertyMetadata(typeof(ToggleColorButton)));
        }
        public override void OnApplyTemplate()
        {
            base.OnApplyTemplate();
            var borde = GetTemplateChild("PART_BordePrincipal") as Border;
            this.Click += (sender, e) =>
            {
                if (borde != null)
                {
                    if (borde.Background == Brushes.Blue) borde.Background = Brushes.Green;
                    else borde.Background = Brushes.Blue;
                }
            };
        }
    }
}