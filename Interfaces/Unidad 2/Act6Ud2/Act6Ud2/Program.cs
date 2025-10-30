using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Act6Ud2
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
    /* Ejercicio 1: Sistema de Registro y Notificación de Ventas
     * Implementa un sistema que notifique y registre cada venta realizada. Crea una clase RegistroVentas que actúe como emisor del evento VentaRealizada, 
     * junto con el método ProcesarVenta para simular el proceso de una venta. Esta clase emitirá el evento usando una instancia de VentaEventArgs que 
     * contiene información sobre la venta (producto y precio). Crea dos clases receptoras: ServicioRegistro y ServicioNotificacion:
     * • ServicioRegistro tiene un método RegistrarVenta que guarda los detalles de la venta.
     * • ServicioNotificacion tiene un método EnviarNotificacionVenta que envía una notificación al usuario.
     */
    public class Ejercicio1
    {
        private class Venta
        {
            public string Producto { get; set; }
            public double Precio { get; set; }
        }
        private class VentaEventArgs : EventArgs
        {
            public Venta Venta { get; set; }
        }
        private class RegistroVentas
        {
            public event EventHandler<VentaEventArgs> VentaRealizada;
            protected virtual void OnVentaRealizada(Venta venta_)
            {
                if (VentaRealizada != null)
                {
                    VentaRealizada(this, new VentaEventArgs() { Venta = venta_ });
                }
            }
            public void ProcesarVenta(Venta venta_)
            {
                Console.WriteLine($"\nProcesando venta de: {venta_.Producto} (${venta_.Precio})...");
                Thread.Sleep(1500);
                OnVentaRealizada(venta_);
            }
        }
        private class ServicioRegistro
        {
            public void RegistrarVenta(object sender, VentaEventArgs e)
            {
                Console.WriteLine($"Venta registrada -> Producto: {e.Venta.Producto}, Precio: ${e.Venta.Precio}");
            }
        }
        private class ServicioNotificacion
        {
            public void EnviarNotificacionVenta(object sender, VentaEventArgs e)
            {
                Console.WriteLine($"Se ha enviado confirmación de compra de {e.Venta.Producto} (${e.Venta.Precio}) al usuario.");
            }
        }
        public static void Ejecutar()
        {
            RegistroVentas registro = new RegistroVentas();
            ServicioRegistro servicioRegistro = new ServicioRegistro();
            ServicioNotificacion servicioNotificacion = new ServicioNotificacion();

            registro.VentaRealizada += servicioRegistro.RegistrarVenta;
            registro.VentaRealizada += servicioNotificacion.EnviarNotificacionVenta;

            Venta venta1 = new Venta() { Producto = "Patata secada", Precio = 0.99 };
            Venta venta2 = new Venta() { Producto = "Globo terraqueo", Precio = 1000000 };

            registro.ProcesarVenta(venta1);
            registro.ProcesarVenta(venta2);
        }
    }

    /* Ejercicio 2: Sistema de Control de Temperatura en un Invernadero
     * Diseña una clase ControlTemperatura que supervise la temperatura del invernadero y emita el evento TemperaturaAlta cuando la temperatura exceda un umbral. 
     * Usa TemperaturaEventArgs para transmitir la temperatura actual y el umbral. Crea las clases ServicioAlerta y ServicioRegistroTemperatura para manejar 
     * este evento:
     * • ServicioAlerta enviará una alerta en consola.
     * • ServicioRegistroTemperatura registrará la temperatura en consola.
     */
    public class Ejercicio2
    {
        private class Temperatura
        {
            public double Actual { get; set; }
            public double Umbral { get; set; }
        }
        private class TemperaturaEventArgs : EventArgs
        {
            public Temperatura Temperatura { get; set; }
        }
        private class ControlTemperatura
        {
            public event EventHandler<TemperaturaEventArgs> TemperaturaAlta;
            public event EventHandler<TemperaturaEventArgs> TemperaturaRegistrada; // si no se hace no se registra al temperatura cuando es normal
            protected virtual void OnTemperaturaAlta(Temperatura temperatura_)
            {
                if (TemperaturaAlta != null)
                {
                    TemperaturaAlta(this, new TemperaturaEventArgs() { Temperatura = temperatura_ });
                }
            }
            protected virtual void OnTemperaturaRegistrada(Temperatura temperatura_)
            {
                if (TemperaturaRegistrada != null)
                {
                    TemperaturaRegistrada(this, new TemperaturaEventArgs() { Temperatura = temperatura_ });
                }
            }
            public void Supervisar(Temperatura temperatura_)
            {
                Console.WriteLine("\nMidiendo temperatura actual...");
                Thread.Sleep(1500);
                OnTemperaturaRegistrada(temperatura_);
                if (temperatura_.Actual > temperatura_.Umbral)
                {
                    OnTemperaturaAlta(temperatura_);
                }
                else
                {
                    Console.WriteLine("Temperatura dentro del rango normal.");
                }
            }
        }
        private class ServicioRegistroTemperatura
        {
            public void RegistrarTemperatura(object sender, TemperaturaEventArgs e)
            {
                Console.WriteLine($"Temperatura registrada -> Actual: {e.Temperatura.Actual}Cº / Umbral: {e.Temperatura.Umbral}Cº");
            }
        }
        private class ServicioAlerta
        {
            public void EnviarNotificacion(object sender, TemperaturaEventArgs e)
            {
                Console.WriteLine($"Temperatura umbral alcanzada: ({e.Temperatura.Actual}Cº / {e.Temperatura.Umbral}Cº)");
            }
        }
        public static void Ejecutar()
        {
            ControlTemperatura control = new ControlTemperatura();
            ServicioRegistroTemperatura registro = new ServicioRegistroTemperatura();
            ServicioAlerta alerta = new ServicioAlerta();

            control.TemperaturaRegistrada += registro.RegistrarTemperatura;
            control.TemperaturaAlta += alerta.EnviarNotificacion;

            Temperatura t1 = new Temperatura() { Actual = 28.5, Umbral = 25.0 };
            Temperatura t2 = new Temperatura() { Actual = 22.3, Umbral = 25.0 };

            control.Supervisar(t1);
            control.Supervisar(t2);
        }
    }
    /* Ejercicio 3: Sistema de Backup y Notificación de Archivos
     * Implementa un sistema que gestione la creación de copias de seguridad. La clase GestorBackups debe emitir el evento BackupCompletado cuando un archivo 
     * se haya respaldado. BackupEventArgs incluye el nombre del archivo y la fecha. Crea ServicioNotificacion para enviar una notificación y ServicioLog 
     * para registrar la operación de respaldo.
     */
    public class Ejercicio3
    {
        public class Backup
        {
            public string NombreArchivo { get; set; }
            public string Fecha { get; set; }
        }
        public class BackupEventArgs : EventArgs
        {
            public Backup Backup { get; set; }
        }
        public class GestorBackups
        {
            public event EventHandler<BackupEventArgs> BackupCompletado;
            protected virtual void OnBackupCompletado(Backup backup_)
            {
                if (BackupCompletado != null)
                {
                    BackupCompletado(this, new BackupEventArgs() { Backup = backup_ });
                }
            }
            public void RealizarBackup(string nombreArchivo)
            {
                Console.WriteLine($"\nIniciando backup del archivo: {nombreArchivo}...");
                Thread.Sleep(1500);
                var backup = new Backup() { NombreArchivo = nombreArchivo, Fecha = DateTime.Now.ToString() };
                Console.WriteLine($"Backup completado.");
                OnBackupCompletado(backup);
            }
        }
        public class ServicioLog
        {
            public void RegistrarLog(object sender, BackupEventArgs e)
            {
                Console.WriteLine($"Backup registrado -> Archivo: {e.Backup.NombreArchivo}, Fecha: {e.Backup.Fecha}");
            }
        }
        public class ServicioNotificacion
        {
            public void EnviarNotificacion(object sender, BackupEventArgs e)
            {
                Console.WriteLine($"Copia de seguridad completada para '{e.Backup.NombreArchivo}'");
            }
        }
        public static void Ejecutar()
        {
            GestorBackups gestor = new GestorBackups();
            ServicioLog log = new ServicioLog();
            ServicioNotificacion notificacion = new ServicioNotificacion();

            gestor.BackupCompletado += log.RegistrarLog;
            gestor.BackupCompletado += notificacion.EnviarNotificacion;

            gestor.RealizarBackup("patatas.txt");
            gestor.RealizarBackup("cangrejo.ps1");
        }
    }
    /* Ejercicio 4: Sistema de Monitoreo de Sensores de Puertas y Ventanas
     * Crea un sistema de monitoreo para una casa inteligente que controle el estado de puertas y ventanas. Diseña una clase SensorMonitoreo que emita el 
     * evento AlertaIntruso cuando se detecta una puerta o ventana abierta fuera del horario permitido. Usa IntrusoEventArgs para incluir detalles del sensor 
     * (nombre de la puerta/ventana y la hora de detección). Crea dos servicios que respondan a este evento:
     * • ServicioAlarma activa una alarma.
     * • ServicioRegistroIncidencias guarda un registro en la base de datos.
     */
    public class Ejercicio4
    {
        public class IntrusoEventArgs : EventArgs
        {
            public string SensorNombre { get; set; }
            public DateTime HoraDeteccion { get; set; }
        }
        public class SensorMonitoreo
        {
            public event EventHandler<IntrusoEventArgs> AlertaIntruso;
            private int horaPermitidaInicio;
            private int horaPermitidaFin;
            public SensorMonitoreo(int horaInicio, int horaFin)
            {
                horaPermitidaInicio = horaInicio;
                horaPermitidaFin = horaFin;
            }
            protected virtual void OnAlertaIntruso(string sensorNombre, DateTime hora)
            {
                AlertaIntruso?.Invoke(this, new IntrusoEventArgs() { SensorNombre = sensorNombre, HoraDeteccion = hora }); //forma más épica
            }
            public void DetectarApertura(string sensorNombre, DateTime horaDeteccion)
            {
                Console.WriteLine($"\nDetectando apertura...");
                Thread.Sleep(1000);
                int hora = horaDeteccion.Hour;
                bool fueraHorario = hora < horaPermitidaInicio || hora >= horaPermitidaFin;
                if (fueraHorario)
                {
                    Console.WriteLine("Apertura fuera del horario permitido");
                    OnAlertaIntruso(sensorNombre, horaDeteccion);
                }
                else
                {
                    Console.WriteLine("Apertura dentro del horario permitido. No se dispara alerta.");
                }
            }
        }
        public class ServicioRegistroIncidencias
        {
            public void RegistrarIncidencia(object sender, IntrusoEventArgs e)
            {
                Console.WriteLine($"Incidencia guardada -> Sensor: {e.SensorNombre}, Hora: {e.HoraDeteccion:yyyy-MM-dd HH:mm}");
            }
        }
        public class ServicioAlarma
        {
            public void ActivarAlarma(object sender, IntrusoEventArgs e)
            {
                Console.WriteLine($"Alarma activada por: {e.SensorNombre} a las {e.HoraDeteccion:HH:mm}.");
            }
        }
        public static void Ejecutar()
        {
            SensorMonitoreo monitor = new SensorMonitoreo(6, 22);
            ServicioAlarma alarma = new ServicioAlarma();
            ServicioRegistroIncidencias registro = new ServicioRegistroIncidencias();

            monitor.AlertaIntruso += alarma.ActivarAlarma;
            monitor.AlertaIntruso += registro.RegistrarIncidencia;

            monitor.DetectarApertura("Puerta principal", DateTime.Today.AddHours(23).AddMinutes(15));
            monitor.DetectarApertura("Ventana salón", DateTime.Today.AddHours(21).AddMinutes(30));
        }
    }
    /* Ejercicio 5: Sistema de Supervisión de Consumo de Energía
     * Diseña una clase MonitorEnergia que registre el consumo de energía y emita el evento ConsumoExcesivoDetectado cuando el consumo supere un umbral 
     * establecido. Usa EnergiaEventArgs para proporcionar el consumo actual y el umbral. Implementa las clases ServicioNotificacion y 
     * ServicioAjusteAutomatizado:
     * • ServicioNotificacion envía una advertencia al usuario.
     * • ServicioAjusteAutomatizado ajusta automáticamente los dispositivos para reducir el consumo.
     */
    public class Ejercicio5
    {
        public class Energia
        {
            public double ConsumoActual { get; set; }
            public double Umbral { get; set; }
        }
        public class EnergiaEventArgs : EventArgs
        {
            public Energia Energia { get; set; }
        }
        public class MonitorEnergia
        {
            public event EventHandler<EnergiaEventArgs> ConsumoExcesivoDetectado;
            protected virtual void OnConsumoExcesivoDetectado(Energia energia_)
            {
                ConsumoExcesivoDetectado?.Invoke(this, new EnergiaEventArgs() { Energia = energia_ });
            }
            public void RegistrarConsumo(Energia energia_)
            {
                Console.WriteLine($"\nRegistrando consumo: {energia_.ConsumoActual} kW (Umbral: {energia_.Umbral} kW)");
                Thread.Sleep(1000);
                if (energia_.ConsumoActual > energia_.Umbral)
                {
                    OnConsumoExcesivoDetectado(energia_);
                }
                else
                {
                    Console.WriteLine("Consumo dentro de los parámetros normales.");
                }
            }
        }
        public class ServicioNotificacion
        {
            public void EnviarAdvertencia(object sender, EnergiaEventArgs e)
            {
                Console.WriteLine($"Advertencia: consumo actual supera umbral");
            }
        }
        public class ServicioAjusteAutomatizado
        {
            public void AjustarDispositivos(object sender, EnergiaEventArgs e)
            {
                Console.WriteLine("Ajustando dispositivos para reducir consumo...");
                Thread.Sleep(800);
                Console.WriteLine($"Consumo ajustado a {e.Energia.Umbral-e.Energia.Umbral*0.05}kW"); //una poquita menos
            }
        }
        public static void Ejecutar()
        {
            MonitorEnergia monitor = new MonitorEnergia();
            ServicioNotificacion notificacion = new ServicioNotificacion();
            ServicioAjusteAutomatizado ajuste = new ServicioAjusteAutomatizado();

            monitor.ConsumoExcesivoDetectado += notificacion.EnviarAdvertencia;
            monitor.ConsumoExcesivoDetectado += ajuste.AjustarDispositivos;

            Energia e1 = new Energia() { ConsumoActual = 12.5, Umbral = 10.0 };
            Energia e2 = new Energia() { ConsumoActual = 8.4, Umbral = 10.0 };

            monitor.RegistrarConsumo(e1);
            monitor.RegistrarConsumo(e2);
        }
    }

}
