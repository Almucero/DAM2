namespace ProyectoFinalUd2
{
    public class Producto
    {
        public int Id { get; set; }
        public string Nombre { get; set; }
        public double Precio { get; set; }
        public int Stock { get; set; }
        public int CategoriaId { get; set; }

        // --- MÉTODOS DE LÓGICA DE NEGOCIO PARA LA TAREA 2 ---

        // MÉTODO 1: Calcula el valor económico total de este producto en almacén
        public double CalcularValorInventario()
        {
            return Precio * Stock;
        }

        // MÉTODO 2: Valida que el producto tenga datos coherentes para la BBDD
        public bool EsValido()
        {
            if (string.IsNullOrWhiteSpace(Nombre)) return false;
            if (Precio < 0) return false;
            if (Stock < 0) return false;
            return true;
        }

        // MÉTODO 3: Comprueba si es necesario reponer stock (Alerta)
        public bool EsStockBajo(int umbralMinimo)
        {
            return Stock <= umbralMinimo;
        }
    }
}