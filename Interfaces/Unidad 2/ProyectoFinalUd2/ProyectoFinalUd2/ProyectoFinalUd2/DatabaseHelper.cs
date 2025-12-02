using System;
using System.Collections.Generic;
using System.Data.SQLite;
using System.IO;
using System.Windows;

namespace ProyectoFinalUd2
{
    // --- Modelos (Requisito: Clases con Propiedades) ---
    public class Categoria
    {
        public int Id { get; set; }
        public string Nombre { get; set; }
    }

    public class Producto
    {
        public int Id { get; set; }
        public string Nombre { get; set; }
        public double Precio { get; set; }
        public int Stock { get; set; }
        public int CategoriaId { get; set; }
    }

    // --- Clase de Acceso a Datos (Requisito: SQLite con CRUD) ---
    public class DatabaseHelper
    {
        private string connectionString = "Data Source=TiendaRopa.db;Version=3;";

        public DatabaseHelper()
        {
            InitializeDatabase();
        }

        private void InitializeDatabase()
        {
            if (!File.Exists("TiendaRopa.db"))
            {
                SQLiteConnection.CreateFile("TiendaRopa.db");
            }

            using (var conn = new SQLiteConnection(connectionString))
            {
                conn.Open();
                string sql = @"
                    CREATE TABLE IF NOT EXISTS Categorias (
                        Id INTEGER PRIMARY KEY AUTOINCREMENT,
                        Nombre TEXT NOT NULL
                    );
                    
                    CREATE TABLE IF NOT EXISTS Productos (
                        Id INTEGER PRIMARY KEY AUTOINCREMENT,
                        Nombre TEXT NOT NULL,
                        Precio REAL,
                        Stock INTEGER,
                        CategoriaId INTEGER,
                        FOREIGN KEY(CategoriaId) REFERENCES Categorias(Id)
                    );";

                using (var cmd = new SQLiteCommand(sql, conn))
                {
                    cmd.ExecuteNonQuery();
                }

                // Datos de prueba iniciales
                string dataSql = "INSERT OR IGNORE INTO Categorias (Id, Nombre) VALUES (1, 'Camisetas'), (2, 'Pantalones'), (3, 'Calzado');";
                using (var cmd = new SQLiteCommand(dataSql, conn)) { cmd.ExecuteNonQuery(); }
            }
        }

        public List<Categoria> GetCategorias()
        {
            var lista = new List<Categoria>();
            using (var conn = new SQLiteConnection(connectionString))
            {
                conn.Open();
                string sql = "SELECT * FROM Categorias";
                using (var cmd = new SQLiteCommand(sql, conn))
                using (var reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        lista.Add(new Categoria
                        {
                            Id = Convert.ToInt32(reader["Id"]),
                            Nombre = reader["Nombre"].ToString()
                        });
                    }
                }
            }
            return lista;
        }

        public List<Producto> GetProductosPorCategoria(int categoriaId)
        {
            var lista = new List<Producto>();
            using (var conn = new SQLiteConnection(connectionString))
            {
                conn.Open();
                string sql = "SELECT * FROM Productos WHERE CategoriaId = @CatId";
                using (var cmd = new SQLiteCommand(sql, conn))
                {
                    cmd.Parameters.AddWithValue("@CatId", categoriaId);
                    using (var reader = cmd.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            lista.Add(new Producto
                            {
                                Id = Convert.ToInt32(reader["Id"]),
                                Nombre = reader["Nombre"].ToString(),
                                Precio = Convert.ToDouble(reader["Precio"]),
                                Stock = Convert.ToInt32(reader["Stock"]),
                                CategoriaId = Convert.ToInt32(reader["CategoriaId"])
                            });
                        }
                    }
                }
            }
            return lista;
        }

        public void AddProducto(Producto p)
        {
            using (var conn = new SQLiteConnection(connectionString))
            {
                conn.Open();
                string sql = "INSERT INTO Productos (Nombre, Precio, Stock, CategoriaId) VALUES (@Nom, @Pre, @Sto, @CatId)";
                using (var cmd = new SQLiteCommand(sql, conn))
                {
                    cmd.Parameters.AddWithValue("@Nom", p.Nombre);
                    cmd.Parameters.AddWithValue("@Pre", p.Precio);
                    cmd.Parameters.AddWithValue("@Sto", p.Stock);
                    cmd.Parameters.AddWithValue("@CatId", p.CategoriaId);
                    cmd.ExecuteNonQuery();
                }
            }
        }

        public void UpdateProducto(Producto p)
        {
            using (var conn = new SQLiteConnection(connectionString))
            {
                conn.Open();
                string sql = "UPDATE Productos SET Nombre=@Nom, Precio=@Pre, Stock=@Sto WHERE Id=@Id";
                using (var cmd = new SQLiteCommand(sql, conn))
                {
                    cmd.Parameters.AddWithValue("@Nom", p.Nombre);
                    cmd.Parameters.AddWithValue("@Pre", p.Precio);
                    cmd.Parameters.AddWithValue("@Sto", p.Stock);
                    cmd.Parameters.AddWithValue("@Id", p.Id);
                    cmd.ExecuteNonQuery();
                }
            }
        }

        public void DeleteProducto(int id)
        {
            using (var conn = new SQLiteConnection(connectionString))
            {
                conn.Open();
                string sql = "DELETE FROM Productos WHERE Id=@Id";
                using (var cmd = new SQLiteCommand(sql, conn))
                {
                    cmd.Parameters.AddWithValue("@Id", id);
                    cmd.ExecuteNonQuery();
                }
            }
        }
    }
}