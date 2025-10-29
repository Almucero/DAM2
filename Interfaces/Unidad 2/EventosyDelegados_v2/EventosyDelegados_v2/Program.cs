using System;
using System.Threading;

namespace EventosyDelegados_v2
{
    public class Archivo
    {
        public string Titulo { get; set; }
    }
    public class ArchivoEventArgs : EventArgs
    {
        public Archivo Archivo { get; set; }
    }
    public class AsistenteDescarga
    {
        public delegate void GestorEventoArchivoDescargado(object fuente, ArchivoEventArgs args); //Delegado
        public event GestorEventoArchivoDescargado ArchivoDescargado; //Evento
        //Paso 3: método que dispara el evento
        protected virtual void EnarchivoDescargado(Archivo archivo) 
        {
            ArchivoDescargado?.Invoke(this, new ArchivoEventArgs(){Archivo=archivo});
        }
        //Método que simula la descarga esperando 4 segundos a través de Thread.
        public void Descarga(Archivo archivo)
        {
            Console.WriteLine("Descargando el archivo...");
            Thread.Sleep(4000);
            //Lamamos al método que lanza el evento.
            EnarchivoDescargado(archivo);
        }
    }
    public class ServicioDescomprimir
    {
        public void EnArchivoDescargado(object fuente, ArchivoEventArgs e)
        {
            //Simulamos la descmpresión mostrando este mensaje por pantalla
            Console.WriteLine($"Servicio descomprimir: descomprimiendo el archivo {e.Archivo.Titulo}");
        }
    }
    internal class Program
    {
        public static void Main(string[] args)
        {
            var archivo = new Archivo() { Titulo = "Archivo 1" };
            var asistenteDescarga = new AsistenteDescarga(); //emisor
            var servicioDescomprimir = new ServicioDescomprimir(); //receptor

            asistenteDescarga.ArchivoDescargado += servicioDescomprimir.EnArchivoDescargado;

            asistenteDescarga.Descarga(archivo); //Llamamos al método que lanza el evento
            Console.ReadKey();
        }
    }
}
