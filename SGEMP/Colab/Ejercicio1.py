"""
Ejercicio 1: Expresión aritmética anidada
Declara tres variables numéricas con valores distintos: x, y y z.
Construye una sola expresión de la forma:
((x + y) * z - (x - z)) / ((y // z) + (x % y))

Ajusta con paréntesis suficientes para que Python realice los cálculos en el orden que deseas.
Ten en cuenta que la división entera // puede generar resultados distintos dependiendo de los valores elegidos.
Asigna el resultado de esa expresión a una variable llamada resultado.
Muestra por pantalla el valor de resultado.
Imprime también el tipo de resultado usando type(resultado).
"""

x = 1
y = 2
z = 3
resultado = ((x + y) * z - (x - z)) / ((y // z) + (x % y))
print(resultado)
print(type(resultado))