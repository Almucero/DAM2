"""
Ejercicio 12: Reorganización de lista
Escribe el código necesario para que, dada una lista de enteros:

Reordene la lista colocando los números pares al inicio y los impares al final.
Ejemplo:

[3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5]

Salida esperada: [4, 2, 6, 3, 1, 1, 5, 9, 5, 3, 5]
"""

lista = [3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5]

lista_pares = []
lista_impares = []

for elemento in lista:
    if elemento%2 == 0:
        lista_pares.append(elemento)
    else:
        lista_impares.append(elemento)

lista_ordenada = lista_pares + lista_impares

print("Lista normal:", lista)
print("Lista ordenada:", lista_ordenada)