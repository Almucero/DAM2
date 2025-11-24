using System;
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

namespace Ejercicio1
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public List<Animal> Animales { get; set; }

        public MainWindow()
        {
            InitializeComponent();
            Animales = new List<Animal>
            {
                new Animal { Nombre = "Perro", Imagen = "Resources/dog.png" },
                new Animal { Nombre = "Gato",  Imagen = "C:\\Users\\ajimmun901\\Desktop\\DAM2\\Interfaces\\Unidad 2\\Act13Ud2\\Ejercicio1\\Ejercicio1\\Resources\\cat.jpg" },
                new Animal { Nombre = "Pájaro", Imagen = "C:\\Users\\ajimmun901\\Desktop\\DAM2\\Interfaces\\Unidad 2\\Act13Ud2\\Ejercicio1\\Ejercicio1\\Resources\\bird.jpg" }
            };
            cmbAnimales.ItemsSource = Animales;
        }
        private void cmbAnimales_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (cmbAnimales.SelectedItem is Animal animal)
                MessageBox.Show(animal.Nombre);
        }
        public class Animal
        {
            public string Nombre { get; set; }
            public string Imagen { get; set; }
        }
    }
}
