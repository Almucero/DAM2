"""
Ejercicio 10: Calculadora de promedio
Escribe un programa que:

1. Pida al usuario que introduzca números uno a uno.
2. El usuario puede escribir "fin" para terminar.
3. Mientras no escriba "fin", el programa debe:
- Convertir el valor introducido a número.
- Sumarlo a un total.
- Contar cuántos números se han introducido.
4. Al terminar, debe mostrar:
- La suma total.
- El número de valores introducidos.
- El promedio.
"""

contador = 0
suma = 0
media = 0

print("Escribe fin para terminar")
while True:
    numero = input("Introduce un numero: ")
    if (numero=="fin"):
        break
    suma += int(numero)
    contador += 1

print("Suma total:", suma)
print("Numero de valores introducidos", contador)
print("Promedio:", suma/contador)
