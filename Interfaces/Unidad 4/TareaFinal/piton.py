import sys
import subprocess

# ==========================================
# BLOQUE DE VERIFICACIÓN DE LIBRERÍAS
# ==========================================
# Esto comprueba si tienes lo necesario antes de empezar para evitar errores al final.
required = {'pandas', 'numpy', 'openpyxl'}
installed = {pkg.split('==')[0] for pkg in subprocess.check_output([sys.executable, '-m', 'pip', 'freeze']).decode().split('\n')}
missing = required - installed

if missing:
    print("\n" + "!"*60)
    print(f" ERROR: Faltan librerías necesarias para crear el Excel: {missing}")
    print(" POR FAVOR, EJECUTA ESTE COMANDO EN TU TERMINAL:")
    print(f" pip install {' '.join(missing)}")
    print("!"*60 + "\n")
    # Intentamos importar de todas formas por si acaso, pero avisamos.

try:
    import pandas as pd
    import numpy as np
    import random
    from datetime import datetime, timedelta
except ImportError as e:
    print("Error crítico: No se pudieron cargar las librerías. Revisa las instrucciones de arriba.")
    sys.exit(1)

# ==========================================
# CONFIGURACIÓN MASIVA
# ==========================================
np.random.seed(999) # Semilla para que los datos sean coherentes
NUM_CLIENTES = 25000
NUM_VENTAS = 150000 
NUM_INTERACCIONES = 80000
FECHA_INICIO = datetime(2023, 1, 1)
FECHA_FIN = datetime(2025, 12, 31) # 3 años de datos
DIAS_TOTALES = (FECHA_FIN - FECHA_INICIO).days

print("--- INICIANDO GENERACIÓN DE DATOS DE ALTA VARIEDAD ---")
print(f"Generando {NUM_VENTAS} ventas y {NUM_CLIENTES} clientes...")

# ==========================================
# 1. GENERADOR DE CATÁLOGO (REAL + SINTÉTICO)
# ==========================================
# Parte A: Juegos Reales (Los "Headliners")
juegos_reales = [
    ("Elden Ring", "RPG", 59.99, "AAA"), ("EA Sports FC 24", "Deportes", 69.99, "AAA"),
    ("Call of Duty: Modern Warfare III", "Shooter", 79.99, "AAA"), ("Hollow Knight", "Indie", 14.99, "Indie"),
    ("Cyberpunk 2077: Phantom Liberty", "RPG", 59.99, "AAA"), ("Grand Theft Auto V", "Acción", 29.99, "AAA"),
    ("Red Dead Redemption 2", "Aventura", 59.99, "AAA"), ("Minecraft Java & Bedrock", "Survival", 29.99, "Indie"),
    ("Stardew Valley", "Simulación", 13.99, "Indie"), ("Baldur's Gate 3", "RPG", 59.99, "AAA"),
    ("Resident Evil 4 Remake", "Terror", 59.99, "AAA"), ("God of War Ragnarok", "Aventura", 69.99, "AAA"),
    ("The Witcher 3: Wild Hunt", "RPG", 39.99, "AAA"), ("Among Us", "Social", 4.99, "Indie"),
    ("Hades II", "Rogue-like", 24.99, "Indie"), ("Tekken 8", "Lucha", 69.99, "AAA"),
    ("Street Fighter 6", "Lucha", 59.99, "AAA"), ("Final Fantasy VII Rebirth", "RPG", 79.99, "AAA"),
    ("Starfield", "RPG", 69.99, "AAA"), ("Diablo IV", "RPG", 69.99, "AAA"),
    ("Hogwarts Legacy", "Aventura", 59.99, "AAA"), ("Palworld", "Survival", 29.99, "Indie"),
    ("Helldivers 2", "Shooter", 39.99, "AA"), ("Dragon's Dogma 2", "RPG", 69.99, "AAA"),
    ("Manor Lords", "Estrategia", 39.99, "Indie"), ("Forza Horizon 5", "Conducción", 59.99, "AAA"),
    ("Assassin's Creed Mirage", "Acción", 49.99, "AAA"), ("Spider-Man 2", "Acción", 79.99, "AAA"),
    ("Super Mario Bros Wonder", "Plataformas", 59.99, "AAA"), ("Zelda: Tears of the Kingdom", "Aventura", 69.99, "AAA")
]

# Parte B: Generador Sintético para rellenar catálogo (Alta variedad)
palabras_a = ["Shadow", "Eternal", "Cyber", "Super", "Dark", "Space", "Mystic", "Iron", "Neon", "Silent", "Infinite", "Deadly", "Epic", "Pixel", "Mega"]
palabras_b = ["Warriors", "Quest", "Legends", "Racers", "Simulator", "Empire", "Souls", "Combat", "Odyssey", "Tactics", "Survivor", "Chronicles", "Arena", "Fighters", "Tycoon"]
sufijos = ["", "II", "III", "Remastered", "GOTY Edition", "VR", "Origins", "Reborn", "2024", "2025", "HD", "Deluxe"]
generos_sinteticos = ["RPG", "Estrategia", "Indie", "Shooter", "Puzzle", "Simulación", "Deportes"]

catalogo_completo = []
id_counter = 100

# Añadir reales
for j in juegos_reales:
    catalogo_completo.append([id_counter, j[0], j[1], j[2], j[3]])
    id_counter += 1

# Generar 650 juegos ficticios variados
for _ in range(650):
    nombre = f"{np.random.choice(palabras_a)} {np.random.choice(palabras_b)} {np.random.choice(sufijos)}".strip()
    genero = np.random.choice(generos_sinteticos)
    
    # Precio lógico según género
    if genero == "Indie": precio = np.random.choice([4.99, 9.99, 14.99, 19.99])
    elif genero == "RPG" or genero == "Shooter": precio = np.random.choice([39.99, 49.99, 59.99, 69.99])
    else: precio = np.random.choice([19.99, 29.99, 39.99])
    
    categoria = "Indie" if precio < 25 else ("AA" if precio < 50 else "AAA")
    catalogo_completo.append([id_counter, nombre, genero, precio, categoria])
    id_counter += 1

df_catalogo = pd.DataFrame(catalogo_completo, columns=["ID_Juego", "Titulo", "Genero", "Precio_Oficial", "Categoria"])

print(f"Catálogo generado: {len(df_catalogo)} productos únicos.")

# ==========================================
# 2. TABLA: CLIENTES (VARIEDAD DEMOGRÁFICA)
# ==========================================
ids_clientes = np.arange(100000, 100000 + NUM_CLIENTES)

# Distribución de edad realista (Campana desplazada hacia 18-35)
edades = np.concatenate([
    np.random.randint(15, 20, int(NUM_CLIENTES * 0.15)), # Adolescentes
    np.random.randint(20, 30, int(NUM_CLIENTES * 0.45)), # Jóvenes adultos (Core)
    np.random.randint(30, 45, int(NUM_CLIENTES * 0.30)), # Adultos
    np.random.randint(45, 65, int(NUM_CLIENTES * 0.10))  # Seniors
])
np.random.shuffle(edades)

comunidades = ['Andalucía', 'Cataluña', 'Madrid', 'C. Valenciana', 'Galicia', 'Castilla y León', 'País Vasco', 'Canarias', 'CLM', 'Murcia', 'Aragón', 'Baleares', 'Extremadura', 'Asturias', 'Navarra', 'Cantabria', 'La Rioja']
pesos_pob = [0.178, 0.162, 0.142, 0.106, 0.057, 0.050, 0.046, 0.046, 0.043, 0.032, 0.028, 0.025, 0.022, 0.021, 0.014, 0.012, 0.006]
# Ajuste pequeño para que sume 1 exacto si hay error de redondeo
if sum(pesos_pob) != 1:
    pesos_pob[-1] = 1 - sum(pesos_pob[:-1])

df_clientes = pd.DataFrame({
    "ID_Cliente": ids_clientes,
    "Edad": edades,
    "Genero": np.random.choice(["Hombre", "Mujer", "No especificado"], NUM_CLIENTES, p=[0.60, 0.38, 0.02]),
    "Ubicacion": np.random.choice(comunidades, NUM_CLIENTES, p=pesos_pob),
    "Nivel_Usuario": np.random.choice(["Nuevo", "Recurrente", "VIP", "Inactivo"], NUM_CLIENTES, p=[0.2, 0.5, 0.1, 0.2]),
    "Plataforma_Preferida": np.random.choice(["PC", "PlayStation", "Xbox", "Switch", "Multi"], NUM_CLIENTES, p=[0.4, 0.3, 0.15, 0.1, 0.05])
})

# ==========================================
# 3. TABLA: VENTAS (GRAN VARIEDAD DE METADATOS)
# ==========================================
# Generación vectorizada masiva
venta_cliente_ids = np.random.choice(ids_clientes, size=NUM_VENTAS)
venta_juego_ids = np.random.choice(df_catalogo["ID_Juego"], size=NUM_VENTAS)

# Fechas aleatorias distribuidas
dias_random = np.random.randint(0, DIAS_TOTALES, size=NUM_VENTAS)
horas_random = np.random.randint(0, 24, size=NUM_VENTAS)
df_ventas = pd.DataFrame({
    "ID_Transaccion": np.arange(5000000, 5000000 + NUM_VENTAS),
    "ID_Cliente": venta_cliente_ids,
    "ID_Juego": venta_juego_ids,
    "Fecha": [FECHA_INICIO + timedelta(days=int(d), hours=int(h)) for d, h in zip(dias_random, horas_random)]
})

# Merge para traer precios base
df_ventas = df_ventas.merge(df_catalogo[["ID_Juego", "Precio_Oficial", "Titulo"]], on="ID_Juego", how="left")

# Lógica variada de precios y márgenes
descuentos = np.random.uniform(0.15, 0.65, size=NUM_VENTAS) # Conseguimos keys entre 15% y 65% off
margenes = np.random.uniform(1.0, 5.0, size=NUM_VENTAS)     # Nuestro margen es variable

df_ventas["Coste_Adquisicion"] = round(df_ventas["Precio_Oficial"] * (1 - descuentos), 2)
df_ventas["PVP_Final"] = round(df_ventas["Coste_Adquisicion"] + margenes, 2)
df_ventas["Beneficio_Neto"] = df_ventas["PVP_Final"] - df_ventas["Coste_Adquisicion"]

# Variedad en Plataformas de activación (No solo "PC")
plataformas_activacion = [
    "Steam Key", "Epic Games Key", "Ubisoft Connect", "GOG Galaxy", 
    "PSN Code", "Xbox Live Code", "Nintendo eShop Code", "Rockstar Launcher"
]
df_ventas["Plataforma_Activacion"] = np.random.choice(plataformas_activacion, size=NUM_VENTAS)

# Variedad en Métodos de Pago
metodos_pago_detallados = [
    "Visa Crédito", "Mastercard Débito", "PayPal Saldo", "PayPal Tarjeta",
    "Bizum", "Apple Pay", "Google Pay", 
    "Cripto (Bitcoin)", "Cripto (USDT - Tron)", "Cripto (Ethereum)"
]
df_ventas["Metodo_Pago_Detalle"] = np.random.choice(metodos_pago_detallados, size=NUM_VENTAS, p=[0.25, 0.20, 0.15, 0.10, 0.10, 0.05, 0.05, 0.04, 0.04, 0.02])

# Agrupación simple para análisis fácil
df_ventas["Tipo_Pago_General"] = df_ventas["Metodo_Pago_Detalle"].apply(lambda x: "Cripto" if "Cripto" in x else ("Tarjeta" if "Visa" in x or "Master" in x else "Digital Wallet"))

# ==========================================
# 4. TABLA: INTERACCIONES IA (MUY DETALLADO)
# ==========================================
# Generar variedad de "Prompts" simulados
motivos = [
    "Recomendación: Estado de ánimo", "Recomendación: Presupuesto bajo", "Recomendación: Similar a...",
    "Soporte: Key no funciona", "Soporte: Cómo activar", "Info: Métodos de pago",
    "Info: Fecha lanzamiento", "Queja: Precio alto", "Social: Charla general"
]
estados_animo = ["Curioso", "Frustrado", "Aburrido", "Emocionado", "Indeciso", "Escéptico"]

df_ia = pd.DataFrame({
    "ID_Chat": np.arange(1, NUM_INTERACCIONES + 1),
    "ID_Cliente": np.random.choice(ids_clientes, size=NUM_INTERACCIONES),
    "Fecha_Hora": [FECHA_INICIO + timedelta(days=int(x), hours=int(y)) for x, y in zip(np.random.randint(0, DIAS_TOTALES, NUM_INTERACCIONES), np.random.randint(0, 24, NUM_INTERACCIONES))],
    "Intencion_Principal": np.random.choice(motivos, size=NUM_INTERACCIONES, p=[0.2, 0.2, 0.15, 0.1, 0.1, 0.05, 0.05, 0.1, 0.05]),
    "Estado_Animo_Detectado": np.random.choice(estados_animo, size=NUM_INTERACCIONES),
    "Segundos_Duracion": np.random.randint(20, 600, size=NUM_INTERACCIONES),
    "Valoracion_Usuario_IA": np.random.choice([1, 2, 3, 4, 5], size=NUM_INTERACCIONES, p=[0.05, 0.05, 0.15, 0.40, 0.35])
})

# ==========================================
# 5. TABLA: BENCHMARK (Comparativa Top 50)
# ==========================================
# Solo seguimos la evolución de los 50 juegos más populares del catálogo generado
top_juegos_ids = df_ventas["ID_Juego"].value_counts().head(50).index.tolist()
fechas_semanales = pd.date_range(start=FECHA_INICIO, end=FECHA_FIN, freq='W')

benchmark_data = []
for j_id in top_juegos_ids:
    row_juego = df_catalogo[df_catalogo["ID_Juego"] == j_id].iloc[0]
    base = row_juego["Precio_Oficial"]
    
    for f in fechas_semanales:
        # Tendencia de bajada de precio con ruido aleatorio
        antiguedad = (f - FECHA_INICIO).days
        factor_bajada = max(0.4, 1 - (antiguedad / 1500)) # Nunca baja del 40% del valor original
        
        precio_steam = base * factor_bajada
        # Nosotros siempre un poco más barato, pero fluctuando
        precio_nosotros = precio_steam * np.random.uniform(0.85, 0.95)
        
        benchmark_data.append([f, row_juego["Titulo"], round(precio_steam, 2), round(precio_nosotros, 2)])

df_benchmark = pd.DataFrame(benchmark_data, columns=["Fecha_Semana", "Juego", "Precio_Competencia", "Precio_KeyVault"])

# ==========================================
# EXPORTACIÓN
# ==========================================
archivo = "Datos_estudio_GameSage.xlsx"
print(f"Guardando datos en '{archivo}'...")
print("NOTA: Esto puede tardar un rato debido al tamaño del archivo. Por favor, espera.")

try:
    with pd.ExcelWriter(archivo, engine='openpyxl') as writer:
        df_catalogo.to_excel(writer, sheet_name='Catalogo', index=False)
        df_clientes.to_excel(writer, sheet_name='Clientes', index=False)
        df_ventas.to_excel(writer, sheet_name='Ventas', index=False)
        df_ia.to_excel(writer, sheet_name='Interacciones_IA', index=False)
        df_benchmark.to_excel(writer, sheet_name='Benchmark', index=False)
    print("\n" + "="*50)
    print(" ¡ÉXITO! ARCHIVO CREADO CORRECTAMENTE.")
    print(f" Nombre: {archivo}")
    print("="*50)
except Exception as e:
    print("\nERROR AL GUARDAR EL EXCEL:")
    print(e)
    print("Asegúrate de que 'openpyxl' está instalado.")