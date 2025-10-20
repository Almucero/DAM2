using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Act3Ud2
{
    /* Ejercicio 1:
     * Crea una aplicación que, en primer lugar, pida al usuario que introduzca el tamaño del array
     * de enteros a crear, y a continuación proceda a solicitarle al usuario el valor de cada uno
     * de esos componentes del array. Finalmente, muestra por pantalla la suma y la media de todos
     * los valores del array.
     */
    public class Ejercicio1
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Introduzca el tamaño del array de enteros a crear:");
            string tamanio = Console.ReadLine();
            int arrayEnteros = [];
        }
    }

    /* Ejercicio 2:
     * Crea una aplicación que cuente el número de espacios en blanco existentes en una cadena
     * que el usuario introduce por teclado. Debes implementar una función que reciba como parámetro
     * un string y devuelva el número de caracteres.
     */
    public class Ejercicio2
    {
        static void Main(string[] args)
        {

        }
    }

    /* Ejercicio 3:
     * Realiza un programa que, mediante un método auxiliar y con recursividad, calcule el factorial
     * de un número que el usuario introduce por teclado.
     * Nota: el factorial de un número se calcula como n! = n*(n-1)*(n-2)*...*3*2*1.
     * Por ejemplo: 6! = 6*5*4*3*2*1 = 720
     */

    /* Ejercicio 4:
    * Crea un programa que compruebe si un número que el usuario introduce por teclado es primo o no.
    * Impleméntalo mediante una función.
    * Nota: un número es primo si solo es divisible por sí mismo y por la unidad.
    */

    /* Ejercicio 5:
    * Crea un programa que calcule la potencia X de un número determinado. El usuario introducirá
    * por teclado tanto la base como el exponente. NO puedes utilizar la clase Math. Impleméntalo
    * de dos formas: iterativa y recursiva.
    */

    /* Ejercicio 6:
    * Crea una aplicación que se encargue de controlar el login de un usuario en una aplicación.
    * Tendrás que implantarlo mediante una función que reciba como parámetro el usuario y la contraseña,
    * y que devuelva “true” si el usuario es “usuario2DAM” y la contraseña es “pass2DAM”.
    * Además, el usuario solo tendrá permitido tres intentos.
    */

    /* Ejercicio 7:
    * Crea un programa que pida dos números enteros al usuario y diga si alguno de ellos es múltiplo
    * del otro. Crea una función EsMultiplo que reciba los dos números, y devuelva si el primero es
    * múltiplo del segundo.
    */

    /* Ejercicio 8:
    * Crea un programa en C#, que mediante el uso de una función auxiliar, calcule la suma de los
    * dígitos individuales de un número que el usuario introduce por teclado. Por ejemplo, si el
    * usuario introduce el número 23, el resultado debe ser 2+3=5.
    */

    /* Ejercicio 9:
    * Crea una función que devuelva la posición del número menor de un array. Los valores de este
    * array se definen en el código directamente.
    */

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
}
