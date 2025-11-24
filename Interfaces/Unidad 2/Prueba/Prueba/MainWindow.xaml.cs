using System;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Media;

namespace Prueba
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            List<Juego> juegos = new List<Juego>();
            juegos.Add(new Juego() { Eq1 = "Barcelona", Eq2 = "Real Madrid", Puntaje1 = 3, Puntaje2 = 2, Progreso = 85 });
            juegos.Add(new Juego() { Eq1 = "Barcelona", Eq2 = "Real Madrid", Puntaje1 = 2, Puntaje2 = 3, Progreso = 85 });
            juegos.Add(new Juego() { Eq1 = "PSG", Eq2 = "Bayern Munich", Puntaje1 = 2, Puntaje2 = 3, Progreso = 55 });
            juegos.Add(new Juego() { Eq1 = "Málaga", Eq2 = "Sevilla", Puntaje1 = 5, Puntaje2 = 1, Progreso = 25 });
            juegos.Add(new Juego() { Eq1 = "Manchester", Eq2 = "Paris Sant Germain ", Puntaje1 = 3, Puntaje2 = 1, Progreso = 15 });
            lbJuego.ItemsSource = juegos;
            ComboBoxColores.ItemsSource = typeof(Colors).GetProperties();
        }
        private void Button_Click(object sender, RoutedEventArgs e)
        {
            if (lbJuego.SelectedItem != null)
            {
                MessageBox.Show("Juego seleccionado: " +
                    (lbJuego.SelectedItem as Juego).Eq1 +
                    (lbJuego.SelectedItem as Juego).Puntaje1 +
                    (lbJuego.SelectedItem as Juego).Eq2 +
                    (lbJuego.SelectedItem as Juego).Puntaje2);
            }
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            MessageBoxResult result = MessageBox.Show("Would you like to greet the world with " + "a \"Hello, world\"?", "My App", MessageBoxButton.YesNoCancel);
            switch (result)
            {
                case MessageBoxResult.Yes: MessageBox.Show("Hello to you too!", "My App");
                    break;
                case MessageBoxResult.No: MessageBox.Show("Oh well, too bad!", "My App");
                    break;
                case MessageBoxResult.Cancel: MessageBox.Show("Nevermind then...", "My App");
                    break;
            }
        }
    }
    public class Juego
    {
        public int Puntaje1 { get; set; }
        public int Puntaje2 { get; set; }
        public string Eq1 { get; set; }
        public String Eq2 { get; set; }
        public int Progreso { get; set; }
    }

}
