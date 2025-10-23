using System;

namespace Act1Ud2
{
    public class Ejercicio1
    {
        public delegate bool ValidarNumero(int x);

        //Crear método para la validación 'Mayor A Cero'
        static bool MayorACero(int a) => a > 0;

        public static void Main()
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

        public static void Main()
        {
            ValidarNumero validate = MayorACero;

            //Ascociar el nuevo método al delegado
            validate += EsPar;

            //Se ejecuta el delegado
            validate(3);
        }
    }
}
