<<<<<<< Updated upstream
﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Ejercicio4
{
    /// <summary>
    /// Lógica de interacción para AlertIndicator.xaml
    /// </summary>
    public partial class AlertIndicator : UserControl
    {
        public AlertIndicator()
        {
            InitializeComponent();
=======
﻿using System.Windows;
using System.Windows.Controls;

namespace Ejercicio4.Controls
{
    public partial class AlertIndicator : UserControl
    {
        public AlertIndicator() => InitializeComponent();
        public static readonly DependencyProperty MensajePrincipalProperty =
            DependencyProperty.Register(nameof(MensajePrincipal), typeof(string), typeof(AlertIndicator), new PropertyMetadata(""));
        public string MensajePrincipal
        {
            get => (string)GetValue(MensajePrincipalProperty);
            set => SetValue(MensajePrincipalProperty, value);
        }
        public static readonly DependencyProperty AlertaActivaProperty =
            DependencyProperty.Register(nameof(AlertaActiva), typeof(bool), typeof(AlertIndicator), new PropertyMetadata(false));
        public bool AlertaActiva
        {
            get => (bool)GetValue(AlertaActivaProperty);
            set => SetValue(AlertaActivaProperty, value);
        }
        public static readonly DependencyProperty MensajeAdvertenciaProperty =
            DependencyProperty.Register(nameof(MensajeAdvertencia), typeof(string), typeof(AlertIndicator), new PropertyMetadata(""));
        public string MensajeAdvertencia
        {
            get => (string)GetValue(MensajeAdvertenciaProperty);
            set => SetValue(MensajeAdvertenciaProperty, value);
>>>>>>> Stashed changes
        }
    }
}
