using System;

namespace Act1Ud2
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
    public class Ejercicio1
    {
        public delegate bool ValidarNumero(int x);
        //Crear método para la validación 'Mayor A Cero'
        static bool MayorACero(int a) => a > 0;
        public static void Ejecutar()
        {
            //Crear instancia del delegado con el nombre validate
            ValidarNumero validate = MayorACero;
            //Se imprime en consola el resultado
            Console.WriteLine(validate(-2));
            Console.WriteLine(validate(0));
            Console.WriteLine(validate(1));
        }
    }
    public class Ejercicio2
    {
        public delegate void ValidarNumero(int x);

        public static void MayorACero(int a)
        {
            Console.WriteLine(a>0);
        }
        //Crear método para la validacin 'EsPar'
        public static void EsPar(int a)
        {
            Console.WriteLine(a % 2 == 0);
        }
        public static void Ejecutar()
        {
            ValidarNumero validate = MayorACero;

            //Ascociar el nuevo método al delegado
            validate += EsPar;

            //Se ejecuta el delegado
            validate(3);
        }
    }
}
