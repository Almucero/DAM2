using System.Windows;
using System.Windows.Controls;

namespace LibreriaVisualFinal.Controls
{
    /// <summary>
    /// Control de usuario que visualiza el estado de una acción mediante un mensaje de texto y una barra de progreso.
    /// </summary>
    public partial class VisorProgreso : UserControl
    {
        /// <summary>
        /// Inicializa una nueva instancia de la clase <see cref="VisorProgreso"/>.
        /// </summary>
        public VisorProgreso() => InitializeComponent();

        /// <summary>
        /// Identifica la propiedad de dependencia <see cref="MensajeAccion"/>.
        /// </summary>
        public static readonly DependencyProperty MensajeAccionProperty =
            DependencyProperty.Register(nameof(MensajeAccion),
                typeof(string),
                typeof(VisorProgreso),
                new PropertyMetadata("Esperando interacción..."));

        /// <summary>
        /// Obtiene o establece el texto descriptivo de la acción actual.
        /// </summary>
        /// <value>
        /// Cadena de texto que describe lo que está ocurriendo (ej: "Procesando...").
        /// </value>
        public string MensajeAccion
        {
            get => (string)GetValue(MensajeAccionProperty);
            set => SetValue(MensajeAccionProperty, value);
        }

        /// <summary>
        /// Identifica la propiedad de dependencia <see cref="ProgresoValor"/>.
        /// </summary>
        public static readonly DependencyProperty ProgresoValorProperty =
            DependencyProperty.Register(nameof(ProgresoValor),
                typeof(double),
                typeof(VisorProgreso),
                new PropertyMetadata(0.0));

        /// <summary>
        /// Obtiene o establece el porcentaje de completado de la tarea.
        /// </summary>
        /// <value>
        /// Valor numérico de tipo double entre 0 y 100.
        /// </value>
        public double ProgresoValor
        {
            get => (double)GetValue(ProgresoValorProperty);
            set => SetValue(ProgresoValorProperty, value);
        }
    }
}