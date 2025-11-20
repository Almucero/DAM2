using System.Collections.ObjectModel;
using System.Windows;

namespace Ejercicio5
{
    public partial class MainWindow : Window
    {
        public class Estudiante
        {
            public string Nombre { get; set; }
            public int Edad { get; set; }
            public double Nota { get; set; }
            public string Curso { get; set; }
        }
        public ObservableCollection<Estudiante> Estudiantes { get; set; }
        public MainWindow()
        {
            InitializeComponent();
            Estudiantes = new ObservableCollection<Estudiante>
            {
                new Estudiante { Nombre = "Ana", Edad = 20, Nota = 8.5, Curso = "DAM1" },
                new Estudiante { Nombre = "Luis", Edad = 21, Nota = 7.2, Curso = "DAM1" },
                new Estudiante { Nombre = "María", Edad = 19, Nota = 9.1, Curso = "DAM2" },
                new Estudiante { Nombre = "Pedro", Edad = 22, Nota = 6.8, Curso = "DAM2" },
            };
            DataContext = this;
        }
        private void lstEstudiantes_SelectionChanged(object sender, System.Windows.Controls.SelectionChangedEventArgs e)
        {
            if (lstEstudiantes.SelectedItem is Estudiante est)
            {
                txtDetalles.Text = $"Nombre: {est.Nombre}\nEdad: {est.Edad}\nNota: {est.Nota}\nCurso: {est.Curso}";
            }
            else
            {
                txtDetalles.Text = "";
            }
        }
    }
}
