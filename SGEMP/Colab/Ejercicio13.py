"""
Ejercicio 13: Operaciones encadenadas
Escribe una función “encadenar_operaciones” que tome dos listas de números como argumentos y:

Cree una nueva lista que contenga los elementos únicos presentes en ambas listas.
Ordene la lista resultante de forma descendente.
Devuelva la suma de los tres primeros elementos.
Ejemplo de uso:

print(encadenar_operaciones([1, 2, 3, 4], [3, 4, 5, 6]))

Salida esperada: 15 (ya que la lista combinada sería [6, 5, 4, 3, 2, 1])
"""

def encadenar_operaciones(lst1, lst2):
    lista = list(set(lst1 + lst2))
    lista.sort(reverse=True)
    return sum(lista[:3])

print(encadenar_operaciones([1, 2, 3, 4], [3, 4, 5, 6]))