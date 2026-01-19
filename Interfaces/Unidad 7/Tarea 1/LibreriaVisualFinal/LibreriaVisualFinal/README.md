# LibreriaVisualFinal - Documentación

## Ficha del Proyecto y Autor

**Título de la librería:** LibreriaVisualFinal  
**Autor:** Álvaro Jiménez Muñoz

**Descripción:**  
Librería WPF que contiene controles reutilizables para aplicaciones CRUD, incluyendo:

- **VisorProgreso (UserControl):** Muestra mensajes y barra de progreso que indican el estado de las acciones del usuario.  
- **BotonVisual (CustomControl):** Botón visual que cambia de color al ser presionado y dispara actualizaciones en el VisorProgreso.

---

## Guía de Instalación Rápida

### Pasos para referenciar la DLL y usar los controles en XAML

1. **Localizar la DLL**  
   - Una vez compilada la librería `LibreriaVisualFinal`, identifica la ubicación del archivo `LibreriaVisualFinal.dll` dentro de la carpeta de salida del proyecto (generalmente `bin\Debug` o `bin\Release`).

2. **Agregar la referencia al proyecto consumidor**  
   - Abre el proyecto WPF donde se desean usar los controles.  
   - Haz clic derecho en la sección de **Referencias** del proyecto y selecciona **Agregar Referencia...**.  
   - En la ventana que aparece, utiliza la pestaña **Examinar** para buscar y seleccionar el archivo `LibreriaVisualFinal.dll`.

3. **Verificar que la referencia se haya agregado correctamente**  
   - Una vez agregada, el proyecto debe mostrar la DLL dentro de la lista de referencias.  
   - Reconstruye la solución para asegurarte de que la DLL se carga sin errores.

4. **Registrar el namespace de la librería en XAML**  
   - En los archivos XAML donde se usarán los controles, declara un namespace XML que apunte al namespace de la librería (`LibreriaVisualFinal`).  
   - Esto permite que los controles sean reconocidos y utilizados directamente en XAML.

5. **Usar los controles en XAML**  
   - Una vez registrado el namespace, los controles pueden ser añadidos a cualquier contenedor en la interfaz (Grid, StackPanel, etc.) usando su nombre de control.  
   - Esto habilita la reutilización de los controles en cualquier ventana o página de la aplicación.

---

## Tabla de Referencia de Controles

| Control           | Propiedad (DP)       | Descripción                                                                                   |
|-------------------|----------------------|-----------------------------------------------------------------------------------------------|
| **VisorProgreso** | MensajeAccion        | Mensaje que indica la última acción realizada. Valor por defecto: "Esperando interacción...". |
|                   | ProgresoValor        | Valor numérico que indica el progreso de la acción, de 0 a 100.                               |
| **BotonVisual**   | N/A                  | Hereda de Button. Al presionarse cambia de color y actualiza el VisorProgreso.                |

> DP = Dependency Property, utilizada para enlazar datos y aplicar estilos de manera flexible en XAML.

---

## Nota Técnica Crítica

### Configuración de Arquitectura y Compatibilidad
- Para proyectos que usan **SQLite u otras librerías nativas**, es **fundamental configurar la arquitectura del proyecto en x86** para que todas las dependencias nativas se carguen correctamente.  
- Esto evita errores de carga de DLLs y problemas en tiempo de ejecución.

### Versiones y dependencias
- La librería y el proyecto consumidor deben usar la **misma versión de .NET Framework** (recomendado 4.7.2 o 4.8).  
- Todas las dependencias externas deben ser compatibles con esta versión y con la arquitectura seleccionada.  
- Se recomienda probar la librería en ambos entornos (x86 y x64) para asegurar compatibilidad y estabilidad.

### Coordinación de controles
- `BotonVisual` y `VisorProgreso` están diseñados para funcionar juntos:  
  - El botón dispara la actualización del mensaje y del valor de progreso.  
  - El VisorProgreso refleja visualmente el resultado de cada acción.  
- Esto permite interfaces profesionales y reutilizables en cualquier ventana WPF CRUD.

---

## Mapeo XMLNS Profesional

- La librería define un mapeo de namespace que permite referenciar sus controles de manera sencilla en XAML.  
- Esto facilita la reutilización y evita conflictos de nombres al integrar la librería en proyectos existentes.

---

## Recomendaciones Finales
- Mantener consistencia entre la plataforma de compilación de la DLL y la del proyecto consumidor (x86/x64).  
- Verificar que todas las versiones de .NET Framework y dependencias sean compatibles para evitar errores en tiempo de ejecución.