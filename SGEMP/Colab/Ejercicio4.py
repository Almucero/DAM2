"""
Ejercicio 4: Condicional con orden de operaciones
Define cuatro variables numéricas: a, b, c y d.
Calcula resultado1 = (a + b) * (c - d).
Calcula resultado2 = (a - d) ** 2 // (b % c) (asumiendo que b % c no sea 0).
Si resultado1 es mayor que resultado2, imprime:
"Primer resultado ganador: " seguido del valor de resultado1
(En la misma línea) "(Tipo: ...)" mostrando su tipo con type().
Usa una sola instrucción print() con varios parámetros separados por comas.
En caso contrario, imprime:
"Segundo resultado mayor o igual: " seguido de resultado2, en la misma instrucción print().
"""

a = 1
b = 2
c = 3
d = 4

resultado1 = (a + b) * (c - d)
resultado2 = (a - d) ** 2 // (b % c)

if (resultado1>resultado2):
    print("Primer resultado ganador:", resultado1, "Tipo:", type(resultado1))
else:
    print("Segundo resultado mayor o igual:", resultado2, "Tpo:", type(resultado2))