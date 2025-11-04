using System;

namespace Act7Ud2
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
    /* NOTAS:
     * Definid vuestra propia clase heredada de EventArgs
     * • Para el ejercicio 1, usad la clase TimeSpan para las propiedades que especifiquen tiempo.
     * • Escribid el argumento del método Writeline con "$".
     * • Usad como delagado EventHandler.
     * • Usad para el ejercicio 5 la clase Datetime para las fechas de entrada y salida
     * • En el ejercicio 6, seleccionad aleatoriamente el técnico, de un array que habréis defnido con una clase general.
     * • Usad Invoke para lanzar el evento.
     */

    /* Ejercicio 1: Sistema de Gestión de Proceso de Producción
     * Crea una clase ProcesoProduccion que simule la producción de un producto y emita el evento ProduccionCompletada al finalizar cada proceso. 
     * Usa ProduccionEventArgs para incluir detalles como el nombre del producto y el tiempo de producción. 
     * Implementa las clases ServicioNotificacion y ServicioRegistroProduccion:
     * • ServicioNotificacion enviará una notificación al usuario.
     * • ServicioRegistroProduccion guardará un registro del proceso completado.
     */
    class Ejercicio1
    {
        private class Produccion
        {
            public string NombreProducto { get; set; }
            public TimeSpan TiempoProduccion { get; set; }
        }
        private class ProduccionEventArgs : EventArgs
        {
            public Produccion Produccion { get; set; }
        }
        private class ProcesoProduccion
        {
            public event EventHandler<ProduccionEventArgs> ProduccionCompletada;
            public void IniciarProceso(string nombreProducto, TimeSpan tiempoProduccion)
            {
                Console.WriteLine($"\nIniciando producción de '{nombreProducto}'...");
                System.Threading.Thread.Sleep(500);
                var produccion = new Produccion() { NombreProducto = nombreProducto, TiempoProduccion = tiempoProduccion };
                ProduccionCompletada?.Invoke(this, new ProduccionEventArgs() { Produccion = produccion });
            }
        }
        private class ServicioNotificacion
        {
            public void OnProduccionCompletada(object sender, ProduccionEventArgs e)
            {
                Console.WriteLine($"Notificación: La producción de '{e.Produccion.NombreProducto}' se completó.");
            }
        }
        private class ServicioRegistroProduccion
        {
            public void OnProduccionCompletada(object sender, ProduccionEventArgs e)
            {
                System.Threading.Thread.Sleep(500);
                Console.WriteLine($"Registro actualizado: [Producto: '{e.Produccion.NombreProducto}' | Tiempo: '{e.Produccion.TiempoProduccion}']");
            }
        }
        public static void Ejecutar()
        {
            ProcesoProduccion procesoProduccion = new ProcesoProduccion();
            ServicioNotificacion servicioNotificacion = new ServicioNotificacion();
            ServicioRegistroProduccion servicioRegistroProduccion = new ServicioRegistroProduccion();

            procesoProduccion.ProduccionCompletada += servicioNotificacion.OnProduccionCompletada;
            procesoProduccion.ProduccionCompletada += servicioRegistroProduccion.OnProduccionCompletada;

            TimeSpan tiempo = new TimeSpan(0, 0, 15);
            procesoProduccion.IniciarProceso("Pepinilloh enlatao", tiempo);
        }
    }
    /* Ejercicio 2: Sistema de Gestión de Eventos para una Plataforma de Videos en Streaming
     * Implementa una clase ControlTransmision que emita el evento TransmisionFinalizada al completar una transmisión en vivo. 
     * Usa TransmisionEventArgs para incluir el título del evento y la duración. Implementa las clases ServicioNotificacionUsuario y 
     * ServicioRegistroEventos:
     * • ServicioNotificacionUsuario enviará una notificación a los usuarios sobre la finalización de la transmisión.
     * • ServicioRegistroEventos registrará la información en el sistema.
     */
    class Ejercicio2
    {
        private class Transmision
        {
            public string Titulo { get; set; }
            public TimeSpan Duracion { get; set; }
        }
        private class TransmisionEventArgs : EventArgs
        {
            public Transmision Transmision { get; set; }
        }
        private class ControlTransmision
        {
            public event EventHandler<TransmisionEventArgs> TransmisionFinalizada;
            public void FinalizarTransmision(string titulo, TimeSpan duracion)
            {
                Console.WriteLine($"\nFinalizando transmisión '{titulo}'...");
                System.Threading.Thread.Sleep(400);
                var transm = new Transmision() { Titulo = titulo, Duracion = duracion };
                TransmisionFinalizada?.Invoke(this, new TransmisionEventArgs() { Transmision = transm });
            }
        }
        private class ServicioNotificacionUsuario
        {
            public void OnTransmisionFinalizada(object sender, TransmisionEventArgs e)
            {
                Console.WriteLine($"Notificación: La transmisión '{e.Transmision.Titulo}' ha terminado.");
            }
        }
        private class ServicioRegistroEventos
        {
            public void OnTransmisionFinalizada(object sender, TransmisionEventArgs e)
            {
                System.Threading.Thread.Sleep(300);
                Console.WriteLine($"Registro actualizado: [Título: '{e.Transmision.Titulo}' | Duración: '{e.Transmision.Duracion}']");
            }
        }
        public static void Ejecutar()
        {
            ControlTransmision controlTransmision = new ControlTransmision();
            ServicioNotificacionUsuario servicioNotificacionUsuario = new ServicioNotificacionUsuario();
            ServicioRegistroEventos servicioRegistroEventos = new ServicioRegistroEventos();

            controlTransmision.TransmisionFinalizada += servicioNotificacionUsuario.OnTransmisionFinalizada;
            controlTransmision.TransmisionFinalizada += servicioRegistroEventos.OnTransmisionFinalizada;

            TimeSpan duracion = TimeSpan.FromMinutes(120);
            controlTransmision.FinalizarTransmision("Soy un jugador superior - elxokas", duracion);
        }
    }
    /* Ejercicio 3: Sistema de Gestión de Pedidos y Confirmaciones en un Restaurante
     * Diseña una clase GestorPedidos que gestione pedidos de un restaurante. Cuando un pedido se confirma, 
     * debe emitir el evento PedidoConfirmado. Usa PedidoEventArgs para incluir detalles del pedido, como el nombre del cliente y 
     * los detalles de los artículos. Implementa las clases ServicioCocina y ServicioNotificacionCliente:
     * • ServicioCocina recibe el evento y empieza a preparar el pedido.
     * • ServicioNotificacionCliente notifica al cliente que el pedido ha sido confirmado.
     */
    class Ejercicio3
    {
        private class Pedido
        {
            public string NombreCliente { get; set; }
            public string Articulos { get; set; }
        }
        private class PedidoEventArgs : EventArgs
        {
            public Pedido Pedido { get; set; }
        }
        private class GestorPedidos
        {
            public event EventHandler<PedidoEventArgs> PedidoConfirmado;
            public void ConfirmarPedido(string nombreCliente, string articulos)
            {
                Console.WriteLine($"\nConfirmando pedido para {nombreCliente}...");
                System.Threading.Thread.Sleep(300);
                var ped = new Pedido() { NombreCliente = nombreCliente, Articulos = articulos };
                PedidoConfirmado?.Invoke(this, new PedidoEventArgs() { Pedido = ped });
            }
        }
        private class ServicioCocina
        {
            public void OnPedidoConfirmado(object sender, PedidoEventArgs e)
            {
                Console.WriteLine($"Notificación: Preparando pedido para {e.Pedido.NombreCliente}. Artículos: {e.Pedido.Articulos}.");
            }
        }
        private class ServicioNotificacionCliente
        {
            public void OnPedidoConfirmado(object sender, PedidoEventArgs e)
            {
                System.Threading.Thread.Sleep(200);
                Console.WriteLine($"Registro actualizado: [Cliente: '{e.Pedido.NombreCliente}' | Artículos: '{e.Pedido.Articulos}']");
            }
        }
        public static void Ejecutar()
        {
            GestorPedidos gestorPedidos = new GestorPedidos();
            ServicioCocina servicioCocina = new ServicioCocina();
            ServicioNotificacionCliente servicioNotificacionCliente = new ServicioNotificacionCliente();

            gestorPedidos.PedidoConfirmado += servicioCocina.OnPedidoConfirmado;
            gestorPedidos.PedidoConfirmado += servicioNotificacionCliente.OnPedidoConfirmado;

            gestorPedidos.ConfirmarPedido("Peruanito multicolor", "1x Pizza, 2x Pepsis");
        }
    }
    /* Ejercicio 4: Sistema de Monitoreo de Stock en un Almacén
     * Crea una clase ControlStock que verifique los niveles de stock de productos y emita el evento StockBajo cuando el nivel esté por debajo de un mínimo. 
     * Usa StockEventArgs para incluir el nombre del producto y el nivel actual. Implementa las clases ServicioPedidoReposicion y ServicioAlertaStock:
     * • ServicioPedidoReposicion recibe el evento y genera un pedido de reposición.
     * • ServicioAlertaStock envía una alerta al sistema.
     */
    class Ejercicio4
    {
        private class Stock
        {
            public string NombreProducto { get; set; }
            public int NivelActual { get; set; }
        }
        private class StockEventArgs : EventArgs
        {
            public Stock Stock { get; set; }
        }
        private class ControlStock
        {
            public event EventHandler<StockEventArgs> StockBajo;
            public void ComprobarStock(string producto, int nivelActual, int nivelMinimo)
            {
                Console.WriteLine($"\nComprobando stock de {producto}...");
                System.Threading.Thread.Sleep(200);
                if (nivelActual < nivelMinimo)
                {
                    var stock = new Stock() { NombreProducto = producto, NivelActual = nivelActual };
                    StockBajo?.Invoke(this, new StockEventArgs() { Stock = stock });
                }
                else
                {
                    Console.WriteLine($"Nivel suficiente para {producto} ({nivelActual}).");
                }
            }
        }
        private class ServicioPedidoReposicion
        {
            public void OnStockBajo(object sender, StockEventArgs e)
            {
                Console.WriteLine($"Generando pedido de reposición para {e.Stock.NombreProducto}. Nivel actual: {e.Stock.NivelActual}.");
            }
        }
        private class ServicioAlertaStock
        {
            public void OnStockBajo(object sender, StockEventArgs e)
            {
                System.Threading.Thread.Sleep(150);
                Console.WriteLine($"Alerta: Stock bajo en {e.Stock.NombreProducto}. Nivel: {e.Stock.NivelActual}.");
            }
        }
        public static void Ejecutar()
        {
            ControlStock controlStock = new ControlStock();
            ServicioPedidoReposicion servicioPedidoReposicion = new ServicioPedidoReposicion();
            ServicioAlertaStock servicioAlertaStock = new ServicioAlertaStock();

            controlStock.StockBajo += servicioPedidoReposicion.OnStockBajo;
            controlStock.StockBajo += servicioAlertaStock.OnStockBajo;

            controlStock.ComprobarStock("Avellanas", 5, 10);
        }
    }
    /* Ejercicio 5: Sistema de Reserva de Habitaciones y Notificación
 * Implementa un sistema de reservas de habitaciones en un hotel. La clase GestorReservas debe emitir el evento ReservaConfirmada cuando una 
 * reserva es confirmada. Usa ReservaEventArgs para incluir el nombre del cliente, el tipo de habitación y las fechas. Crea dos clases:
 * • ServicioLimpieza recibe el evento y programa la limpieza de la habitación.
 * • ServicioNotificacionCliente envía una confirmación al cliente.
 */
    class Ejercicio5
    {
        private class Reserva
        {
            public string NombreCliente { get; set; }
            public string TipoHabitacion { get; set; }
            public DateTime FechaEntrada { get; set; }
            public DateTime FechaSalida { get; set; }
        }
        private class ReservaEventArgs : EventArgs
        {
            public Reserva Reserva { get; set; }
        }
        private class GestorReservas
        {
            public event EventHandler<ReservaEventArgs> ReservaConfirmada;
            public void ConfirmarReserva(string nombreCliente, string tipoHabitacion, DateTime fechaEntrada, DateTime fechaSalida)
            {
                Console.WriteLine($"\nProcesando reserva para {nombreCliente}...");
                System.Threading.Thread.Sleep(400);
                var reserva = new Reserva()
                {
                    NombreCliente = nombreCliente,
                    TipoHabitacion = tipoHabitacion,
                    FechaEntrada = fechaEntrada,
                    FechaSalida = fechaSalida
                };
                ReservaConfirmada?.Invoke(this, new ReservaEventArgs() { Reserva = reserva });
            }
        }
        private class ServicioLimpieza
        {
            public void OnReservaConfirmada(object sender, ReservaEventArgs e)
            {
                Console.WriteLine($"Programando limpieza para {e.Reserva.NombreCliente} (Habitación: {e.Reserva.TipoHabitacion}) antes del {e.Reserva.FechaEntrada:dd/MM/yyyy}.");
            }
        }
        private class ServicioNotificacionCliente
        {
            public void OnReservaConfirmada(object sender, ReservaEventArgs e)
            {
                System.Threading.Thread.Sleep(250);
                Console.WriteLine($"Notificación enviada a {e.Reserva.NombreCliente}: Reserva confirmada ({e.Reserva.TipoHabitacion}) desde {e.Reserva.FechaEntrada:dd/MM/yyyy} hasta {e.Reserva.FechaSalida:dd/MM/yyyy}.");
            }
        }
        public static void Ejecutar()
        {
            GestorReservas gestorReservas = new GestorReservas();
            ServicioLimpieza servicioLimpieza = new ServicioLimpieza();
            ServicioNotificacionCliente servicioNotificacionCliente = new ServicioNotificacionCliente();

            gestorReservas.ReservaConfirmada += servicioLimpieza.OnReservaConfirmada;
            gestorReservas.ReservaConfirmada += servicioNotificacionCliente.OnReservaConfirmada;

            DateTime entrada = DateTime.Now.AddDays(7);
            DateTime salida = entrada.AddDays(3);
            gestorReservas.ConfirmarReserva("El peruanillo", "The real Palace", entrada, salida);
        }
    }

    /* Ejercicio 6: Sistema de Gestión de Incidencias en un Servicio de Atención al Cliente
     * Diseña un sistema que gestione incidencias reportadas por los clientes. Crea la clase GestorIncidencias, que emitirá el evento 
     * IncidenciaReportada cada vez que un cliente reporte un problema. Usa IncidenciaEventArgs para incluir detalles como el ID de la incidencia, 
     * el cliente y la descripción del problema. Implementa las siguientes clases receptoras:
     * • ServicioTecnico que se encargará de clasificar y asignar la incidencia a un técnico disponible.
     * • ServicioNotificacionCliente que notificará al cliente sobre el estado de su incidencia.
     * • ServicioRegistroIncidencias que registrará la incidencia en una base de datos ficticia.
     */
    class Ejercicio6
    {
        private class Incidencia
        {
            public int Id { get; set; }
            public string Cliente { get; set; }
            public string Descripcion { get; set; }
        }
        private class IncidenciaEventArgs : EventArgs
        {
            public Incidencia Incidencia { get; set; }
        }
        private class GestorIncidencias
        {
            public event EventHandler<IncidenciaEventArgs> IncidenciaReportada;
            private int siguienteId = 1;
            public void ReportarIncidencia(string cliente, string descripcion)
            {
                Console.WriteLine($"\nReporte recibido de {cliente}...");
                var inc = new Incidencia() { Id = siguienteId++, Cliente = cliente, Descripcion = descripcion };
                IncidenciaReportada?.Invoke(this, new IncidenciaEventArgs() { Incidencia = inc });
            }
        }
        private class Tecnico
        {
            public string Nombre { get; set; }
            public string Especialidad { get; set; }
        }
        private class ServicioTecnico
        {
            private Tecnico[] tecnicos = new Tecnico[]
            {
                new Tecnico(){ Nombre = "Elxokas", Especialidad = "Redes" },
                new Tecnico(){ Nombre = "Nate Gentile", Especialidad = "Hardware" }
            };
            private Random rnd = new Random();
            public void OnIncidenciaReportada(object sender, IncidenciaEventArgs e)
            {
                var asignado = tecnicos[rnd.Next(tecnicos.Length)];
                Console.WriteLine($"Incidencia {e.Incidencia.Id} asignada a {asignado.Nombre} ({asignado.Especialidad}). Descripción: {e.Incidencia.Descripcion}");
            }
        }
        private class ServicioNotificacionCliente
        {
            public void OnIncidenciaReportada(object sender, IncidenciaEventArgs e)
            {
                System.Threading.Thread.Sleep(400);
                Console.WriteLine($"Notificación enviada a {e.Incidencia.Cliente}: Se ha registrado su incidencia #{e.Incidencia.Id}.");
            }
        }
        private class ServicioRegistroIncidencias
        {
            private int contador = 0;
            public void OnIncidenciaReportada(object sender, IncidenciaEventArgs e)
            {
                contador++;
                System.Threading.Thread.Sleep(250);
                Console.WriteLine($"Registro: Guardada incidencia #{e.Incidencia.Id} ({e.Incidencia.Descripcion}). Total registradas: {contador}.");
            }
        }
        public static void Ejecutar()
        {
            GestorIncidencias gestor = new GestorIncidencias();
            ServicioTecnico servicioTecnico = new ServicioTecnico();
            ServicioNotificacionCliente servicioNotificacionCliente = new ServicioNotificacionCliente();
            ServicioRegistroIncidencias servicioRegistro = new ServicioRegistroIncidencias();

            gestor.IncidenciaReportada += servicioTecnico.OnIncidenciaReportada;
            gestor.IncidenciaReportada += servicioNotificacionCliente.OnIncidenciaReportada;
            gestor.IncidenciaReportada += servicioRegistro.OnIncidenciaReportada;

            gestor.ReportarIncidencia("Hirohito", "No funciona el acceso a la cuenta");
            gestor.ReportarIncidencia("Genghis Khan", "Ruido extraño en el dispositivo");
        }
    }

}
