using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Act3Ud2
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
            } while (opcion!=0);
        }
    }
    /* Ejercicio 1:
     * Crea una aplicación que, en primer lugar, pida al usuario que introduzca el tamaño del array
     * de enteros a crear, y a continuación proceda a solicitarle al usuario el valor de cada uno
     * de esos componentes del array. Finalmente, muestra por pantalla la suma y la media de todos
     * los valores del array.
     */
    public class Ejercicio1
    {
        public static void Ejecutar()
        {
            Console.Write("\nIntroduzca el tamaño del array de enteros a crear: ");
            int[] arrayEnteros = new int[int.Parse(Console.ReadLine())];
            for (int i = 0; i < arrayEnteros.Length; i++)
            {
                Console.Write("Introduzca el valor del componente " + (i + 1)+": ");
                arrayEnteros[i] = int.Parse(Console.ReadLine());
            }
            Console.WriteLine("Contenidos del array: ["+string.Join(", ", arrayEnteros)+"]");
            Console.WriteLine("Suma: "+arrayEnteros.Sum());
            Console.WriteLine("Media: "+arrayEnteros.Average());
        }
    }

    /* Ejercicio 2:
     * Crea una aplicación que cuente el número de espacios en blanco existentes en una cadena
     * que el usuario introduce por teclado. Debes implementar una función que reciba como parámetro
     * un string y devuelva el número de caracteres.
     */
    public class Ejercicio2
    {
        public static void Ejecutar()
        {
            Console.Write("\nIntroduzca una cadena de texto: ");
            string cadena = Console.ReadLine();
            int numeroEspacios = ContarEspacios(cadena);
            Console.WriteLine("Número de espacios en blanco: "+numeroEspacios);
        }
        private static int ContarEspacios(string cadena)
        {
            int contador = 0;
            foreach (char c in cadena)
            {
                if (c == ' ')
                {
                    contador++;
                }
            }
            return contador;
        }
    }

    /* Ejercicio 3:
     * Realiza un programa que, mediante un método auxiliar y con recursividad, calcule el factorial
     * de un número que el usuario introduce por teclado.
     * Nota: el factorial de un número se calcula como n! = n*(n-1)*(n-2)*...*3*2*1.
     * Por ejemplo: 6! = 6*5*4*3*2*1 = 720
     */
    public class Ejercicio3
    {
        public static void Ejecutar()
        {
            Console.Write("\nIntroduzca un número para calcular su factorial: ");
            int numero = int.Parse(Console.ReadLine());
            int factorial = CalcularFactorial(numero);
            Console.Write(numero+"! =");
            for (int i = numero; i > 1; i--)
            {
                Console.Write(" "+i+" *");
            }
            Console.WriteLine(" 1 = "+factorial);
        }
        private static int CalcularFactorial(int numero)
        {
            int factorial = 1;
            if (numero > 1)
            {
                factorial = numero * CalcularFactorial(numero - 1);
            }
            return factorial;
        }
    }

    /* Ejercicio 4:
    * Crea un programa que compruebe si un número que el usuario introduce por teclado es primo o no.
    * Impleméntalo mediante una función.
    * Nota: un número es primo si solo es divisible por sí mismo y por la unidad.
    */
    public class Ejercicio4
    {
        public static void Ejecutar()
        {
            Console.Write("\nIntroduza un número para calcular si es primo: ");
            int numero = int.Parse(Console.ReadLine());
            Console.WriteLine(numero+(EsPrimo(numero)?" es primo.":" no es primo."));
        }
        private static bool EsPrimo(int numero) 
        {
            if (numero < 2) return false;
            for (int i = 2; i < numero; i++)
            {
                if (numero%i==0)
                {
                    return false;
                }
            }
            return true;
        }
    }

    /* Ejercicio 5:
    * Crea un programa que calcule la potencia X de un número determinado. El usuario introducirá
    * por teclado tanto la base como el exponente. NO puedes utilizar la clase Math. Impleméntalo
    * de dos formas: iterativa y recursiva.
    */
    public class Ejercicio5
    {
        public static void Ejecutar()
        {
            Console.Write("\nIntroduzca la base de la potencia a calcular: ");
            int basee = int.Parse(Console.ReadLine());
            Console.Write("Introduzca el exponente de la potencia a calcular: ");
            int exponente = int.Parse(Console.ReadLine());
            Console.WriteLine("Resultado iterativo: "+basee+"^"+exponente+" = "+CalcularPotenciaIterativa(basee, exponente));
            Console.WriteLine("Resultado recursivo: "+basee+"^"+exponente+" = "+CalcularPotenciaRecursiva(basee, exponente));
        }
        private static int CalcularPotenciaIterativa(int basee, int exponente)
        {
            int potencia = 1;
            for (int i = 0; i < exponente; i++)
            {
                potencia *= basee;
            }
            return potencia;
        }
        private static int CalcularPotenciaRecursiva(int basee, int exponente)
        {
            if (exponente == 0)
            {
                return 1;
            }
            else
            {
                return basee * CalcularPotenciaRecursiva(basee, exponente-1);
            }
        }
    }

    /* Ejercicio 6:
    * Crea una aplicación que se encargue de controlar el login de un usuario en una aplicación.
    * Tendrás que implantarlo mediante una función que reciba como parámetro el usuario y la contraseña,
    * y que devuelva “true” si el usuario es “usuario2DAM” y la contraseña es “pass2DAM”.
    * Además, el usuario solo tendrá permitido tres intentos.
    */
    public class Ejercicio6
    {
        public static void Ejecutar()
        {
            int intentos = 0;
            do
            {
                Console.Write("\nIntroduzca el nombre de usuario de la cuenta: ");
                string usuario = Console.ReadLine();
                Console.Write("Introduzca la contraseña de la cuenta: ");
                string contrasena = Console.ReadLine();
                if (Login(usuario, contrasena))
                {
                    Console.WriteLine("Ha accedido a la cuenta");
                    break;
                }
                Console.WriteLine("Error en los datos; Intentos restantes: "+(2-intentos));
                intentos++;
            } while (intentos < 3);
            
        }
        private static bool Login(string usuario, string contrasena)
        {
            if (usuario.Equals("usuario2DAM") && contrasena.Equals("pass2DAM"))
            {
                return true;
            }
            return false;
        }
    }

    /* Ejercicio 7:
    * Crea un programa que pida dos números enteros al usuario y diga si alguno de ellos es múltiplo
    * del otro. Crea una función EsMultiplo que reciba los dos números, y devuelva si el primero es
    * múltiplo del segundo.
    */
    public class Ejercicio7
    {
        public static void Ejecutar()
        {
            Console.Write("\nIntroduzca el primer número: ");
            int numero1 = int.Parse(Console.ReadLine());
            Console.Write("Introduzca el segundo número: ");
            int numero2 = int.Parse(Console.ReadLine());
            if (EsMultiplo(numero1, numero2))
            {
                Console.WriteLine(numero1+" es múltiplo de "+numero2);
            }
            else if (EsMultiplo(numero2, numero1))
            {
                Console.WriteLine(numero2 + " es múltiplo de " + numero1);
            }
            else
            {
                Console.WriteLine("Ninguno de los 2 números es múltilpo del otro");
            }
        }
        private static bool EsMultiplo(int primero, int segundo)
        {
            if (segundo == 0) return false;
            return primero % segundo == 0;
        }
    }

    /* Ejercicio 8:
    * Crea un programa en C#, que mediante el uso de una función auxiliar, calcule la suma de los
    * dígitos individuales de un número que el usuario introduce por teclado. Por ejemplo, si el
    * usuario introduce el número 23, el resultado debe ser 2+3=5.
    */
    public class Ejercicio8
    {
        public static void Ejecutar()
        {
            Console.Write("\nIntroduzca el número: ");
            int numero = int.Parse(Console.ReadLine());
            Console.WriteLine("La suma de los dígitos individuales de "+numero+" es: "+SumaDigitos(numero));
        }
        private static int SumaDigitos(int numero)
        {
            int suma = 0;
            while (numero!=0)
            {
                suma += numero % 10;
                numero /= 10;
            }
            return suma;
        }
    }

    /* Ejercicio 9:
    * Crea una función que devuelva la posición del número menor de un array. Los valores de este
    * array se definen en el código directamente.
    */
    public class Ejercicio9
    {
        public static void Ejecutar()
        {
            int[] array = { 10, 2, 3, 6, 7, 1, 5, 4, 9, 8 };
            Random rnd = new Random();
            array = array.OrderBy(x => rnd.Next()).ToArray();
            Console.WriteLine("La posición del número menor del array: ["+string.Join(", ", array)+"] es la: "+PosicionNumeroMenor(array)+"°");
        }
        private static int PosicionNumeroMenor(int[] array)
        {
            int posicion = 0;
            int menor = array[0];
            for (int i = 1; i<array.Length; i++)
            {
                if (array[i]<menor)
                {
                    menor = array[i];
                    posicion = i+1;
                }
            }
            return posicion;
        }
    }

    /* Ejercicio 10:
    * Crea un programa en C# para simular un banco y sus clientes, los cuales realizan depósitos.
    * Implementa las clases Cliente y Banco.
    *
    * En Cliente tienes que definir:
    * • El campo nombre (string)
    * • El campo cantidadTotal (int o double)
    * • El método Ingresar, que tiene como argumento un entero o double.
    * • El método Sacar, que tiene como parámetro un entero o double.
    * • El método GetCantidadTotal, que devuelve el dinero que el cliente tiene en su cuenta.
    * • El método MostrarInformacion, que mostrará por pantalla la cantidad total que el usuario tiene en su cuenta.
    *
    * En Banco tienes que definir:
    * • El main de la aplicación, que creará la instancia de Banco, realizará operaciones (llamada a Operar())
    * y que mostrará información por pantalla (método ObtenerEstado()).
    * • El constructor creará tres instancias de Cliente, pasándole como parámetro un nombre.
    * • El método Operar, que simulará el ingreso de dinero en las cuentas de cada cliente (llamando el método
    * Ingresar de la clase Cliente).
    * • El método ObtenerEstado, que en primer lugar muestra el dinero total que se han ingresado en el banco
    * por parte de los tres clientes (suma de los tres), y a continuación muestra el dinero que ha ingresado
    * cada cliente (mediante el método GetCantidadTotal de la clase Cliente).
    */
    public class Ejercicio10
    {
        private class Cliente
        {
            string nombre;
            double cantidadTotal;

            public Cliente(string nombre)
            {
                this.nombre = nombre;
                this.cantidadTotal = 0.0;
            }

            public void Ingresar(double cantidad)
            {
                cantidadTotal += cantidad;
            }
            public void Sacar(double cantidad)
            {
                if (cantidad <= cantidadTotal)
                {
                    cantidadTotal -= cantidad;
                }
                else
                {
                    Console.WriteLine(nombre+" no tiene suficiente saldo para sacar $"+cantidad);
                }
            }
            public double getCantidadTotal()
            {
                return cantidadTotal;
            }
            public void MostrarInformacion()
            {
                Console.WriteLine(nombre+" tiene en su cuenta: $"+cantidadTotal);
            }
        }
        private class Banco
        {
            private Cliente cliente1;
            private Cliente cliente2;
            private Cliente cliente3;

            public Banco()
            {
                cliente1 = new Cliente("Mr. Tartaria");
                cliente2 = new Cliente("Jordi Wild");
                cliente3 = new Cliente("Pedro Sánchez");
            }

            public void Operar()
            {
                cliente1.Ingresar(2000.65);
                cliente2.Ingresar(900.0);
                cliente3.Ingresar(750.55);
            }
            public void ObtenerEstado()
            {
                double totalBanco = cliente1.getCantidadTotal()+cliente2.getCantidadTotal()+cliente3.getCantidadTotal();
                Console.WriteLine("\nDinero total del banco: $"+totalBanco);
                cliente1.MostrarInformacion();
                cliente2.MostrarInformacion();
                cliente3.MostrarInformacion();
            }
        }
        public static void Ejecutar()
        {
            Banco banco = new Banco();
            banco.Operar();
            banco.ObtenerEstado();
        }
    }
}
