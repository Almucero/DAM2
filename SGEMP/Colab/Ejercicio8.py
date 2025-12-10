"""
Ejercicio 8: Comparación Booleana
Escribe un programa que reciba dos valores ingresados por el usuario y determine:

Si ambos valores son verdaderos.
Si al menos uno de ellos es falso.
Si los valores son iguales después de una conversión booleana.
"""

v1 = input("Valor 1: ").strip().lower()
v2 = input("Valor 2: ").strip().lower()

valor1 = (v1 == "true")
valor2 = (v2 == "true")

if (valor1 and valor2):
    print("Ambos valores son verdaderos")
elif (not valor1 or not valor2):
    print("Al menos uno de ellos no es verdadero")
elif (valor1 == valor2):
    print("Su conversion booleana es igual")