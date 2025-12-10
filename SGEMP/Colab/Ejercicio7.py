"""
Ejercicio 7: Número Especial
Escribe un programa que determine si un número ingresado por el usuario es "especial". Un número es especial si:

Es mayor a 10.
Es divisible por 3 o por 5.
No es divisible por 2.
"""

numero = int(input("Ingresa un numero: "))

if (numero>10 and (numero%3==0 or numero%5==0) and numero%2!=0):
    print("El numero es especial")
else:
    print("El numero no es especial")