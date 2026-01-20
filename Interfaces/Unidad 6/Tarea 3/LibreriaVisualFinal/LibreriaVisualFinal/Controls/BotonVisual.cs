using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;

namespace LibreriaVisualFinal.Controls
{
    /// <summary>
    /// Botón personalizado que cambia su color de fondo aleatoriamente al ser presionado.
    /// Hereda toda la funcionalidad estándar de un Button de WPF.
    /// </summary>
    public class BotonVisual : Button
    {
        private static readonly Random _rand = new Random();

        static BotonVisual()
        {
            DefaultStyleKeyProperty.OverrideMetadata(typeof(BotonVisual), new FrameworkPropertyMetadata(typeof(BotonVisual)));
        }

        /// <summary>
        /// Se invoca cuando se aplica la plantilla al control.
        /// Configura los manejadores de eventos necesarios para la funcionalidad visual.
        /// </summary>
        public override void OnApplyTemplate()
        {
            base.OnApplyTemplate();
            Click -= BotonVisual_Click;
            Click += BotonVisual_Click;
        }

        /// <summary>
        /// Maneja el evento Click para generar un color RGB aleatorio y aplicarlo al fondo.
        /// </summary>
        /// <param name="sender">El objeto que envía el evento.</param>
        /// <param name="e">Argumentos del evento enrutado.</param>
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