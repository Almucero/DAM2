using System.Windows;
using System.Windows.Controls;

namespace Ejercicio2
{
    // Es buena práctica añadir atributos TemplatePart para avisar qué partes requiere el estilo
    [TemplatePart(Name = "PART_BtnUp", Type = typeof(Button))]
    [TemplatePart(Name = "PART_BtnDown", Type = typeof(Button))]
    public class NumberBox : Control
    {
        // 1. CONSTRUCTOR ESTÁTICO
        // Le dice a WPF: "Oye, busca mi estilo en Generic.xaml, no uses el estilo por defecto"
        static NumberBox()
        {
            DefaultStyleKeyProperty.OverrideMetadata(typeof(NumberBox),
                new FrameworkPropertyMetadata(typeof(NumberBox)));
        }

        // 2. DEPENDENCY PROPERTY (El valor numérico)
        // Escribir "propdp" y pulsar TAB dos veces en Visual Studio crea esto automáticamente.
        public int Value
        {
            get { return (int)GetValue(ValueProperty); }
            set { SetValue(ValueProperty, value); }
        }

        public static readonly DependencyProperty ValueProperty =
            DependencyProperty.Register("Value", typeof(int), typeof(NumberBox), new PropertyMetadata(0));

        // 3. LOGICA DE INTERACCIÓN
        // Sobreescribimos este método para buscar los botones en la plantilla (Template)
        public override void OnApplyTemplate()
        {
            base.OnApplyTemplate();

            // Buscamos los botones por su nombre en el XAML (TemplatePart)
            Button btnUp = GetTemplateChild("PART_BtnUp") as Button;
            Button btnDown = GetTemplateChild("PART_BtnDown") as Button;

            // Ojo a las siguientes líneas de código, son delegados anónimos
            if (btnUp != null)
            {
                btnUp.Click += (s, e) => Value++;
            }

            if (btnDown != null)
            {
                btnDown.Click += (s, e) => Value--;
            }
        }
    }
}