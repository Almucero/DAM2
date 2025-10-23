using System;
using System.Linq;
using System.Reflection;
using System.Security.Cryptography.X509Certificates;

namespace Act2Ud2
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
                Console.WriteLine("3.  Ejercicio 3");
                Console.WriteLine("4.  Ejercicio 4");
                Console.WriteLine("5.  Ejercicio 5");
                Console.WriteLine("6.  Ejercicio 6");
                Console.WriteLine("7.  Ejercicio 7");
                Console.WriteLine("8.  Ejercicio 8");
                Console.WriteLine("9.  Ejercicio 9");
                Console.WriteLine("10. Ejercicio 10");
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
                        case 3:
                            Ejercicio3.Ejecutar();
                            break;
                        case 4:
                            Ejercicio4.Ejecutar();
                            break;
                        case 5:
                            Ejercicio5.Ejecutar();
                            break;
                        case 6:
                            Ejercicio6.Ejecutar();
                            break;
                        case 7:
                            Ejercicio7.Ejecutar();
                            break;
                        case 8:
                            Ejercicio8.Ejecutar();
                            break;
                        case 9:
                            Ejercicio9.Ejecutar();
                            break;
                        case 10:
                            Ejercicio10.Ejecutar();
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
    /* Ejercicio 1: Delegado Básico
     * Declara un delegado llamado Operacion que acepte dos enteros y devuelva un entero. 
     * Luego, crea un método llamado Sumar que sume dos números y lo llame desde el Main.
     */
    public class Ejercicio1
    {
        public delegate int Operacion(int a, int b);
        private static int Sumar(int a, int b) => a + b;
        public static void Ejecutar()
        {
            Operacion operacion = Sumar;
            Console.WriteLine("Resultado de la suma: " + operacion(5, 3));
        }
    }
    /* Ejercicio 2: Múltiples Métodos
     * Añade un segundo método llamado Restar que reste dos números. 
     * Asigna ambos métodos al delegado y llama a cada uno desde el Main.
     */
    public class Ejercicio2
    {
        public delegate int Operacion(int a, int b);
        private static int Sumar(int a, int b) => a + b;
        private static int Restar(int a, int b) => a - b;
        public static void Ejecutar()
        {
            Operacion operacion = Sumar;
            operacion += Restar;
            foreach (Operacion op in operacion.GetInvocationList())
            {
                Console.WriteLine("Resultado: " + op(5, 3));
            }
        }
    }
    /* Ejercicio 3: Uso de Multicast Delegates
     * Crea un tercer método llamado Multiplicar. 
     * Asigna los tres métodos al mismo delegado y llama a todos en el Main.
     */
    public class Ejercicio3
    {
        public delegate int Operacion(int a, int b);
        private static int Sumar(int a, int b) => a + b;
        private static int Restar(int a, int b) => a - b;
        private static int Multiplicar(int a, int b) => a * b;
        public static void Ejecutar()
        {
            Operacion operacion = Sumar;
            operacion += Restar;
            operacion += Multiplicar;
            foreach (Operacion op in operacion.GetInvocationList())
            {
                Console.WriteLine("Resultado: " + op(5, 3));
            }
        }
    }
    /* Ejercicio 4: Delegados con Diferentes Métodos
     * Agrega un método Dividir. Usa el delegado para llamar a todos los métodos, 
     * pero maneja el caso de la división por cero.
     */
    public class Ejercicio4
    {
        public delegate int Operacion(int a, int b);
        private static int Sumar(int a, int b) => a + b;
        private static int Restar(int a, int b) => a - b;
        private static int Multiplicar(int a, int b) => a * b;
        private static int Dividir(int a, int b) {
            try
            {
                return a / b;
            }
            catch (DivideByZeroException)
            {
                return 0;
            }
        }
        public static void Ejecutar()
        {
            Operacion operacion = Sumar;
            operacion += Restar;
            operacion += Multiplicar;
            operacion += Dividir;
            foreach (Operacion op in operacion.GetInvocationList())
            {
                Console.WriteLine("Resultado: " + op(5, 0));
            }
        }
    }
    /* Ejercicio 5: Delegados y Retornos
     * Crea un método que reciba un delegado y dos enteros, y llame al delegado, 
     * imprimiendo el resultado. Utiliza este método con los métodos Sumar, Restar, y Multiplicar.
     */
    public class Ejercicio5
    {
        public delegate int Operacion(int a, int b);
        private static int Sumar(int a, int b) => a + b;
        private static int Restar(int a, int b) => a - b;
        private static int Multiplicar(int a, int b) => a * b;
        private static int Operar(Operacion op, int a, int b) => op(a, b);
        public static void Ejecutar()
        {
            Console.WriteLine("Resultado de la suma: " + Operar(Sumar, 5, 3));
            Console.WriteLine("Resultado de la resta: " + Operar(Restar, 5, 3));
            Console.WriteLine("Resultado de la multiplicación: " + Operar(Multiplicar, 5, 3));
        }
    }
    /* Ejercicio 6: Delegados y Nombres
     * Crea un delegado llamado Operar que acepte dos enteros y devuelva un entero. 
     * Define tres métodos: Suma, Resta y Multiplicacion. Asigna estos métodos a un delegado 
     * y usa un bucle para llamar a cada uno, imprimiendo el nombre del método junto con el resultado.
     */
    public class Ejercicio6
    {
        public delegate int Operacion(int a, int b);
        private static int Sumar(int a, int b) => a + b;
        private static int Restar(int a, int b) => a - b;
        private static int Multiplicar(int a, int b) => a * b;
        public static void Ejecutar()
        {
            Operacion operacion = Sumar;
            operacion += Restar;
            operacion += Multiplicar;
            foreach (Operacion op in operacion.GetInvocationList())
            {
                Console.WriteLine(op.Method.Name+": " + op(3, 2));
            }
        }
    }
    /* Ejercicio 7: Delegados y Arrays
     * Modifica el ejercicio anterior para que los métodos reciban un array de enteros y 
     * devuelvan la suma de todos los elementos y en el caso del método Multiplicar, 
     * devuelva la multiplicación de todos los elementos del array. 
     * Se descarta para este ejercicio el método Restar. Usa el delegado para llamar a cada método, 
     * imprimiendo el resultado.
     */
    public class Ejercicio7
    {
        public delegate int Operacion(int[] numeros);
        private static int Sumar(int[] numeros)
        {
            return numeros.Sum();
        }
        private static int Multiplicar(int[] numeros)
        {
            int multiplicacion = 1;
            foreach (int numero in numeros)
            {
                multiplicacion *= numero;
            }
            return multiplicacion;
        }
        public static void Ejecutar()
        {
            int[] numeros = { 1, 2, 3, 4 };
            Operacion operacion = Sumar;
            operacion += Multiplicar;
            foreach (Operacion op in operacion.GetInvocationList())
            {
                Console.WriteLine(op.Method.Name + ": " + op(numeros));
            }
        }
    }
    /* Ejercicio 8: Delegados y Retornos Condicionales
     * Crea un delegado llamado Transformar que acepte un entero y devuelva un entero. 
     * Define tres métodos: Doblar, Triplicar y Cuadrado. Asigna estos métodos a un delegado y 
     * usa un bucle para transformar un número dado y mostrar el resultado de cada método.
     */
    public class Ejercicio8
    {
        public delegate int Transformar(int x);
        public static int Doblar(int a) => a * 2;
        public static int Triplicar(int a) => a * 3;
        public static int Cuadrado(int a) => a * a;
        public static void Ejecutar()
        {
            Transformar transformar = Doblar;
            transformar += Triplicar;
            transformar += Cuadrado;
            foreach (Transformar tr in transformar.GetInvocationList())
            {
                Console.WriteLine(tr.Method.Name + ": " + tr(2));
            }
        }
    }
    /* Ejercicio 9: Delegados y Funciones de Callback
     * Crea un delegado llamado OperacionCallback que acepte dos enteros y devuelva un entero. 
     * Define un método llamado EjecutarOperacion que acepte un delegado y dos enteros, 
     * realice la operación usando el delegado y devuelva el resultado. Luego, implementa los métodos Suma, 
     * Resta y Multiplicar y usa EjecutarOperacion para ejecutar cada uno de ellos.
     */
    public class Ejercicio9
    {
        public delegate int OperacionCallback(int x, int y);
        private static int Restar(int a, int b) => a - b;
        private static int Multiplicar(int a, int b) => a * b;
        public static int EjecutarOperacion(OperacionCallback oc, int a, int b)
        {
            return oc(a, b);
        }
        public static void Ejecutar()
        {

        }
    }
    /* Ejercicio 10: Delegados y Manejo de Errores
     * Crea un delegado llamado Calculo que acepte un número y devuelva un número. 
     * Define métodos para calcular la raíz cuadrada y el logaritmo de un número. 
     * Implementa un método que acepte un delegado y un número, 
     * y maneje posibles excepciones que puedan surgir (como la raíz cuadrada de un número negativo). 
     * Imprime el resultado o un mensaje de error.
     */
    public class Ejercicio10
    {
        public static void Ejecutar()
        {

        }
    }
}