using System;
using System.Configuration;
using System.Data;
using System.Data.SQLite;
using System.Windows;
using System.Windows.Controls;

namespace WpfSqlite
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        SQLiteConnection connection;
        public MainWindow()
        {
            InitializeComponent();
            string cs = ConfigurationManager.ConnectionStrings["SQLiteDB"].ConnectionString;
            connection = new SQLiteConnection(cs);
            CrearTablas();
            MuestraZoos();
            MuestraAnimales();
        }
        private void CrearTablas()
        {
            try
            {
                connection.Open();
                using (var pragma = new SQLiteCommand("PRAGMA foreign_keys = ON;", connection))
                    pragma.ExecuteNonQuery();

                string tablaZoo = @"CREATE TABLE IF NOT EXISTS Zoo( Id INTEGER PRIMARY KEY AUTOINCREMENT, Ubicacion TEXT NOT NULL);";
                string tablaAnimal = @"CREATE TABLE IF NOT EXISTS Animal(Id INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT NOT NULL);";
                string tablaRelacion = @"CREATE TABLE IF NOT EXISTS AnimalZoo(Id INTEGER PRIMARY KEY AUTOINCREMENT, ZooId INTEGER, AnimalId INTEGER, FOREIGN KEY(ZooId) REFERENCES Zoo(Id) ON DELETE CASCADE, FOREIGN KEY(AnimalId) REFERENCES Animal(Id) ON DELETE CASCADE);";
                new SQLiteCommand(tablaZoo, connection).ExecuteNonQuery();
                new SQLiteCommand(tablaAnimal, connection).ExecuteNonQuery();
                new SQLiteCommand(tablaRelacion, connection).ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                MessageBox.Show("CrearTablas: " + ex.Message);
            }
            finally
            {
                if (connection.State == ConnectionState.Open) connection.Close();
            }
        }
        private void MuestraZoos()
        {
            try
            {
                string consulta = "SELECT * FROM Zoo";
                SQLiteDataAdapter da = new SQLiteDataAdapter(consulta, connection);
                DataTable dt = new DataTable();
                da.Fill(dt);
                ListaZoos.DisplayMemberPath = "Ubicacion";
                ListaZoos.SelectedValuePath = "Id";
                ListaZoos.ItemsSource = dt.DefaultView;
            }
            catch (Exception ex)
            {
                MessageBox.Show("MuestraZoos: " + ex.Message);
            }
        }
        private void MuestraAnimales()
        {
            try
            {
                string consulta = "SELECT * FROM Animal";
                SQLiteDataAdapter da = new SQLiteDataAdapter(consulta, connection);
                DataTable dt = new DataTable();
                da.Fill(dt);
                ListaAnimales.DisplayMemberPath = "Nombre";
                ListaAnimales.SelectedValuePath = "Id";
                ListaAnimales.ItemsSource = dt.DefaultView;
            }
            catch (Exception ex)
            {
                MessageBox.Show("MuestraAnimales: " + ex.Message);
            }
        }
        private void MuestraAnimalesAsociados()
        {
            try
            {
                if (ListaZoos.SelectedValue == null)
                {
                    ListaAnimalesAsociados.ItemsSource = null;
                    return;
                }
                string consulta = @"SELECT a.Nombre, a.Id FROM Animal a INNER JOIN AnimalZoo az ON a.Id = az.AnimalId WHERE az.ZooId = @ZooId";
                SQLiteCommand cmd = new SQLiteCommand(consulta, connection);
                cmd.Parameters.AddWithValue("@ZooId", ListaZoos.SelectedValue);
                SQLiteDataAdapter da = new SQLiteDataAdapter(cmd);
                DataTable dt = new DataTable();
                da.Fill(dt);
                ListaAnimalesAsociados.DisplayMemberPath = "Nombre";
                ListaAnimalesAsociados.SelectedValuePath = "Id";
                ListaAnimalesAsociados.ItemsSource = dt.DefaultView;
            }
            catch (Exception ex)
            {
                MessageBox.Show("MuestraAnimalesAsociados: " + ex.Message);
            }
        }
        private void MuestraZooElegidoEnTextBox()
        {
            try
            {
                if (ListaZoos.SelectedValue == null)
                {
                    miTextBox.Text = string.Empty;
                    return;
                }
                string consulta = "SELECT Ubicacion FROM Zoo WHERE Id = @id";
                SQLiteCommand cmd = new SQLiteCommand(consulta, connection);
                cmd.Parameters.AddWithValue("@id", ListaZoos.SelectedValue);
                SQLiteDataAdapter da = new SQLiteDataAdapter(cmd);
                DataTable dt = new DataTable();
                da.Fill(dt);
                if (dt.Rows.Count > 0) miTextBox.Text = dt.Rows[0]["Ubicacion"].ToString();
            }
            catch (Exception ex)
            {
                MessageBox.Show("MuestraZooElegidoEnTextBox: " + ex.Message);
            }
        }
        private void MuestraAnimalElegidoEnTextBox()
        {
            try
            {
                if (ListaAnimales.SelectedValue == null)
                {
                    miTextBox.Text = string.Empty;
                    return;
                }
                string consulta = "SELECT Nombre FROM Animal WHERE Id = @id";
                SQLiteCommand cmd = new SQLiteCommand(consulta, connection);
                cmd.Parameters.AddWithValue("@id", ListaAnimales.SelectedValue);
                SQLiteDataAdapter da = new SQLiteDataAdapter(cmd);
                DataTable dt = new DataTable();
                da.Fill(dt);
                if (dt.Rows.Count > 0) miTextBox.Text = dt.Rows[0]["Nombre"].ToString();
            }
            catch (Exception ex)
            {
                MessageBox.Show("MuestraAnimalElegidoEnTextBox: " + ex.Message);
            }
        }
        private void AgregarZoo_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                connection.Open();
                using (var pragma = new SQLiteCommand("PRAGMA foreign_keys = ON;", connection)) pragma.ExecuteNonQuery();
                SQLiteCommand cmd = new SQLiteCommand("INSERT INTO Zoo (Ubicacion) VALUES (@Ubicacion)", connection);
                cmd.Parameters.AddWithValue("@Ubicacion", miTextBox.Text);
                cmd.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                MessageBox.Show("AgregarZoo: " + ex.Message);
            }
            finally
            {
                if (connection.State == ConnectionState.Open) connection.Close();
                MuestraZoos();
            }
        }
        private void EliminarZoo_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                if (ListaZoos.SelectedValue == null) return;
                connection.Open();
                using (var pragma = new SQLiteCommand("PRAGMA foreign_keys = ON;", connection)) pragma.ExecuteNonQuery();
                SQLiteCommand cmd = new SQLiteCommand("DELETE FROM Zoo WHERE Id=@Id", connection);
                cmd.Parameters.AddWithValue("@Id", ListaZoos.SelectedValue);
                cmd.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                MessageBox.Show("EliminarZoo: " + ex.Message);
            }
            finally
            {
                if (connection.State == ConnectionState.Open) connection.Close();
                MuestraZoos();
                MuestraAnimalesAsociados();
            }
        }
        private void AgregarAnimalZoo_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                if (ListaZoos.SelectedValue == null || ListaAnimales.SelectedValue == null) return;
                connection.Open();
                using (var pragma = new SQLiteCommand("PRAGMA foreign_keys = ON;", connection)) pragma.ExecuteNonQuery();
                SQLiteCommand cmd = new SQLiteCommand("INSERT INTO AnimalZoo (ZooId, AnimalId) VALUES (@Z, @A)", connection);
                cmd.Parameters.AddWithValue("@Z", ListaZoos.SelectedValue);
                cmd.Parameters.AddWithValue("@A", ListaAnimales.SelectedValue);
                cmd.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                MessageBox.Show("AgregarAnimalZoo: " + ex.Message);
            }
            finally
            {
                if (connection.State == ConnectionState.Open) connection.Close();
                MuestraAnimalesAsociados();
            }
        }
        private void ActualizarZoo_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                if (ListaZoos.SelectedValue == null) return;
                connection.Open();
                SQLiteCommand cmd = new SQLiteCommand("UPDATE Zoo SET Ubicacion=@u WHERE Id=@id", connection);
                cmd.Parameters.AddWithValue("@u", miTextBox.Text);
                cmd.Parameters.AddWithValue("@id", ListaZoos.SelectedValue);
                cmd.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                MessageBox.Show("ActualizarZoo: " + ex.Message);
            }
            finally
            {
                if (connection.State == ConnectionState.Open) connection.Close();
                MuestraZoos();
            }
        }
        private void AgregarAnimal_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                connection.Open();
                using (var pragma = new SQLiteCommand("PRAGMA foreign_keys = ON;", connection)) pragma.ExecuteNonQuery();
                SQLiteCommand cmd = new SQLiteCommand("INSERT INTO Animal (Nombre) VALUES (@n)", connection);
                cmd.Parameters.AddWithValue("@n", miTextBox.Text);
                cmd.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                MessageBox.Show("AgregarAnimal: " + ex.Message);
            }
            finally
            {
                if (connection.State == ConnectionState.Open) connection.Close();
                MuestraAnimales();
            }
        }
        private void EliminarAnimal_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                if (ListaAnimales.SelectedValue == null) return;
                connection.Open();
                using (var pragma = new SQLiteCommand("PRAGMA foreign_keys = ON;", connection)) pragma.ExecuteNonQuery();
                SQLiteCommand cmd = new SQLiteCommand("DELETE FROM Animal WHERE Id=@id", connection);
                cmd.Parameters.AddWithValue("@id", ListaAnimales.SelectedValue);
                cmd.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                MessageBox.Show("EliminarAnimal: " + ex.Message);
            }
            finally
            {
                if (connection.State == ConnectionState.Open) connection.Close();
                MuestraAnimales();
                MuestraAnimalesAsociados();
            }
        }
        private void ActualizarAnimal_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                if (ListaAnimales.SelectedValue == null) return;
                connection.Open();
                SQLiteCommand cmd = new SQLiteCommand("UPDATE Animal SET Nombre=@n WHERE Id=@id", connection);
                cmd.Parameters.AddWithValue("@n", miTextBox.Text);
                cmd.Parameters.AddWithValue("@id", ListaAnimales.SelectedValue);
                cmd.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                MessageBox.Show("ActualizarAnimal: " + ex.Message);
            }
            finally
            {
                if (connection.State == ConnectionState.Open) connection.Close();
                MuestraAnimales();
                MuestraAnimalesAsociados();
            }
        }
        private void QuitarAnimalDelZoo_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                if (ListaZoos.SelectedValue == null || ListaAnimalesAsociados.SelectedValue == null) return;
                connection.Open();
                using (var pragma = new SQLiteCommand("PRAGMA foreign_keys = ON;", connection)) pragma.ExecuteNonQuery();
                SQLiteCommand cmd = new SQLiteCommand("DELETE FROM AnimalZoo WHERE ZooId=@z AND AnimalId=@a", connection);
                cmd.Parameters.AddWithValue("@z", ListaZoos.SelectedValue);
                cmd.Parameters.AddWithValue("@a", ListaAnimalesAsociados.SelectedValue);
                cmd.ExecuteNonQuery();
            }
            catch (Exception ex)
            {
                MessageBox.Show("QuitarAnimalDelZoo: " + ex.Message);
            }
            finally
            {
                if (connection.State == ConnectionState.Open) connection.Close();
                MuestraAnimalesAsociados();
            }
        }
        private void ListaZoos_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            MuestraAnimalesAsociados();
            MuestraZooElegidoEnTextBox();
        }
        private void ListaAnimales_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            MuestraAnimalElegidoEnTextBox();
        }
    }
}
