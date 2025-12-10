"""
Ejercicio 11: Cuadrado
Escribe un programa que pida la anchura y altura de un rectángulo y lo dibuje con caracteres producto (*):

Anchura del rectángulo: 6

Altura del rectángulo: 4

"* * * * * *

"*------ *

"*------ *

"* * * * * *
"""

anchura = int(input("Anchura: "))
altura = int(input("Altura: "))

for i in range(altura):
    if (i==0 or i==altura-1):
        print("*" * anchura)
    else:
        print("*", "_" * (anchura-2), "*", sep="")