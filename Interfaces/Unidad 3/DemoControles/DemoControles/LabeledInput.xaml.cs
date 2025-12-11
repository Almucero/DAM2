using System.Windows;
using System.Windows.Controls;

namespace DemoControles.Controls 
{ 
    public partial class LabeledInput : UserControl 
    { 
        public LabeledInput() => InitializeComponent();          
        // Definimos las dos propiedades del control que estamos creando:          
        // Propiedad LabelText
        public static readonly DependencyProperty LabelTextProperty =
            DependencyProperty.Register(nameof(LabelText), typeof(string),
                typeof(LabeledInput), new PropertyMetadata("Etiqueta"));

        public string LabelText
        {             
            get => (string)GetValue(LabelTextProperty);                  
            set => SetValue(LabelTextProperty, value);        
        }       

        // Propiedad Text
        public static readonly DependencyProperty TextProperty =             
            DependencyProperty.Register(nameof(Text), typeof(string),                 
                typeof(LabeledInput), new FrameworkPropertyMetadata("",                    
                    FrameworkPropertyMetadataOptions.BindsTwoWayByDefault));     
        
        public string Text       
        {           
            get => (string)GetValue(TextProperty);       
            set => SetValue(TextProperty, value);        
        }   
    } 
}  