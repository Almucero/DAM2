"""
Ejercicio 16: Diccionarios
Dado el diccionario:

inventario = { "manzanas": 50, "peras": 20, "plátanos": 30, "naranjas": 10 }

Recorre el diccionario y crea otro diccionario nuevo llamado inventario_revisado donde cada cantidad esté incrementada en 10 unidades.
Ordena las claves del diccionario original alfabéticamente.
Añade un nuevo producto usando update.
Elimina el elemento con la cantidad más baja.
Elimina el último elemento insertado.
"""

inventario = { "manzanas": 50, "peras": 20, "plátanos": 30, "naranjas": 10 }
print("Inventario original:", inventario)

inventario_revisado = {}

for key, item in inventario.items():
    inventario_revisado[key] = item+10

print("Inventario revisado:", inventario_revisado)
print("Inventario original ordenado:", sorted(inventario))

inventario.update({'gato': 20})
print("Inventario actualizado:", inventario)

minimo = min(inventario.values())
for key, item in inventario.items():
    if item == minimo:
        del inventario[key]
        break

print("Inventario sin elemento con cantidad mas baja:", inventario)

inventario.popitem()
print("Inventario sin ultimo elemento:", inventario)