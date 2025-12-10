"""
Ejercicio 14: Strings
Determinar la longitud de una cadena:

Convertir una cadena a mayúsculas:

Determinar si una cadena comienza con un prefijo dado:

Reemplazar una parte de una cadena con otra:

Dividir una cadena en una lista de subcadenas utilizando un separador:

Determinar el número de veces que aparece una subcadena en una cadena:

Extraer una porción de una cadena:

Eliminar los espacios en blanco al principio y al final de una cadena:

Validar si una cadena contiene solo dígitos:

Verificar si una cadena es un número:
"""

cadena = " Peruano 17 "

print("Longitud de la cadena:", len(cadena))
print("Cadena en mayusculas:", cadena.upper())
print("Empieza por P:", cadena.startswith('P'))
print("Reemplazar contenido:", cadena.replace('o', 'a'))
print("Dividir en subcadenas con separador:", cadena.split(" "))
print("Veces que aparece 'P':", cadena.count('P'))
print("Extraer porcion:", cadena[1:5])
print("Eliminar espacios al incio y al final:", cadena.strip())
print("Solo digitos?:", cadena.isdigit())
print("Es un numero:", cadena.isnumeric())