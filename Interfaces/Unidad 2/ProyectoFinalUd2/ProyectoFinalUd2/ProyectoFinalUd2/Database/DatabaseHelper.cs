using System;
using System.Collections.Generic;
using Microsoft.Data.Sqlite;
using System.IO;

namespace ProyectoFinalUd2
{
    public class DatabaseHelper
    {
        private string connectionString;
        public DatabaseHelper()
        {
            string dbPath = Path.Combine(AppDomain.CurrentDomain.BaseDirectory, "TiendaRopa.db");
            connectionString = $"Data Source={dbPath}";
            InitializeDatabase();
        }
        private void InitializeDatabase()
        {
            using (var conn = new SqliteConnection(connectionString))
            {
                conn.Open();
                // Creación de tablas
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
                using (var cmd = new SqliteCommand(sql, conn))
                {
                    cmd.ExecuteNonQuery();
                }
                // Datos iniciales de prueba
                string checkSql = "SELECT COUNT(*) FROM Categorias";
                using (var cmd = new SqliteCommand(checkSql, conn))
                {
                    long count = (long)cmd.ExecuteScalar();
                    if (count == 0)
                    {
                        string dataSql = "INSERT INTO Categorias (Nombre) VALUES ('Camisetas'), ('Pantalones'), ('Calzado');";
                        using (var insertCmd = new SqliteCommand(dataSql, conn))
                        {
                            insertCmd.ExecuteNonQuery();
                        }
                    }
                }
            }
        }
        // Métodos CRUD
        public List<Categoria> GetCategorias()
        {
            var lista = new List<Categoria>();
            using (var conn = new SqliteConnection(connectionString))
            {
                conn.Open();
                string sql = "SELECT * FROM Categorias";
                using (var cmd = new SqliteCommand(sql, conn))
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
            using (var conn = new SqliteConnection(connectionString))
            {
                conn.Open();
                string sql = "SELECT * FROM Productos WHERE CategoriaId = @CatId";
                using (var cmd = new SqliteCommand(sql, conn))
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
            using (var conn = new SqliteConnection(connectionString))
            {
                conn.Open();
                string sql = "INSERT INTO Productos (Nombre, Precio, Stock, CategoriaId) VALUES (@Nom, @Pre, @Sto, @CatId)";
                using (var cmd = new SqliteCommand(sql, conn))
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
            using (var conn = new SqliteConnection(connectionString))
            {
                conn.Open();
                string sql = "UPDATE Productos SET Nombre=@Nom, Precio=@Pre, Stock=@Sto WHERE Id=@Id";
                using (var cmd = new SqliteCommand(sql, conn))
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
            using (var conn = new SqliteConnection(connectionString))
            {
                conn.Open();
                string sql = "DELETE FROM Productos WHERE Id=@Id";
                using (var cmd = new SqliteCommand(sql, conn))
                {
                    cmd.Parameters.AddWithValue("@Id", id);
                    cmd.ExecuteNonQuery();
                }
            }
        }
    }
}