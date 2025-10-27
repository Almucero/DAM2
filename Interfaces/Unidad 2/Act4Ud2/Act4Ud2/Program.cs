using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Act4Ud2
{
    public class Program
    {
        static void Main(string[] args)
        {
            int opcion = -1;
            do
            {
                Console.WriteLine("\n===== MENÚ PRINCIPAL =====");
                Console.WriteLine("1.  Ejercicio 1");
                Console.WriteLine("2.  Ejercicio 2");
                Console.WriteLine("0.  Salir");
                Console.Write("Seleccione una opción: ");
                try
                {
                    opcion = int.Parse(Console.ReadLine());
                    switch (opcion)
                    {
                        case 1:
                            Ejercicio1.Ejecutar();
                            break;
                        case 2:
                            Ejercicio2.Ejecutar();
                            break;
                        case 0:
                            Console.WriteLine("Saliendo del programa...");
                            break;
                        default:
                            Console.WriteLine("Opción no válida. Inténtelo otra vez.");
                            break;
                    }
                }
                catch (FormatException)
                {
                    Console.WriteLine("Error: Formato incorrecto");
                }
            } while (opcion != 0);
        }
    }
    /* Ejercicio 1
     * Para el delegado ValidarEdades, se pide declarar un Método Anónimo que lo implemente. 
     * Dicho método debe validar que la edad recibida por parámetro corresponda a alguien mayor de edad. 
     * Es decir que ese número debe ser mayor a 18, en cuyo caso el método deberá retornar el valor 
     * booleando True. Caso contrario retornara un valor False.
     */
    public class Ejercicio1
    {
        public delegate bool ValidarEdades(int x);
        public static void Ejecutar()
        {
            ValidarEdades validate = delegate (int a)
            {
                return a > 18;
            };
            Console.WriteLine(validate(19));
        }
    }
    /* Ejercicio 2
     * Dada la solución del ejercicio anterior, se pide declarar un método con el nombre ImprimirConsola. 
     * Este método debe imprimir en consola el resultado de ejecutar la implementación validate del 
     * delegado. Es decir, que se debe "mudar" la linea con la impresión en consola del Main al método 
     * ImprimirConsola, que además va a recibir 2 parámetros. Uno de ellos será el método del delegado 
     * mediante el objeto validate y el otro va a ser un int que contiene el valor de la edad que se 
     * debe validar. De más esta decir, que este método se debe invocar desde el Main pasandole los 
     * parámetros que correspondan al delegado y a la edad, cuyo valor debe ser 19.
     */
    public class Ejercicio2
    {
        public delegate bool ValidarEdades(int x);
        private static void ImprimirConsola(string a)
        {
            Console.WriteLine(a);
        }
        public static void Ejecutar()
        {
            ValidarEdades validate = delegate (int a)
            {
                return a > 18;
            };
            //La siguiente linea correspondia al ejercicio anterior
            //Console.WriteLine(validate(19));
            //Pero ahora se debe llamar al método ImprimirConsola enviando los parámetros que correspondan
            ImprimirConsola(validate(19).ToString());
        }
    }
}
