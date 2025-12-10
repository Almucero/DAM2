"""
Ejercicio 6: Sistema de Elegibilidad
Escribe un programa que determine si una persona es elegible para votar. Los criterios son:

Tener al menos 18 años.
Tener un documento de identidad válido.
No estar en una lista de prohibición para votar.
El programa debe solicitar la edad, si tiene un documento válido (sí/no), y si está en la lista de prohibición (sí/no).
"""

edad = int(input("Introduce tu edad: "))
documento = str(input("Documento valido? (si/no):")).strip().lower()
prohibido = str(input("Esta en la lista de prohibiciones? (si/no):")).strip().lower()

if (edad>=18 and documento=="si"):
    print("Puedes votar")
else:
    print("No puedes votar")