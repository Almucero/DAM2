using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;

namespace LibreriaVisualFinal.Controls
{
    public class BotonVisual : Button
    {
        private static readonly Random _rand = new Random();
        static BotonVisual()
        {
            DefaultStyleKeyProperty.OverrideMetadata(typeof(BotonVisual), new FrameworkPropertyMetadata(typeof(BotonVisual)));
        }
        public override void OnApplyTemplate()
        {
            base.OnApplyTemplate();
            Click -= BotonVisual_Click;
            Click += BotonVisual_Click;
        }
        private void BotonVisual_Click(object sender, RoutedEventArgs e)
        {
            byte r = (byte)_rand.Next(0, 256);
            byte g = (byte)_rand.Next(0, 256);
            byte b = (byte)_rand.Next(0, 256);
            var color = Color.FromRgb(r, g, b);
            Background = new SolidColorBrush(color);
        }
    }
}
