"""
Ejercicio 3: Mínimo, máximo y cambio de tipos
Declara una variable base como un número entero.
Declara otra variable multiplicador como un float.
Calcula los siguientes valores:
op1 = base ** 2
op2 = multiplicador * base / 2
op3 = base // 2
op4 = float(base)
Crea dos variables: valor_min y valor_max, que sean el mínimo y el máximo de (op1, op2, op3, op4).
Muestra en pantalla valor_min y valor_max, junto con su tipo usando type().
"""

base = 5
multiplicador = 2.5
op1 = base ** 2
op2 = multiplicador * base / 2
op3 = base // 2
op4 = float(base)

valor_min = min(op1, op2, op3, op4)
valor_max = max(op1, op2, op3, op4)

print("min:", valor_min, "type:", type(valor_min))
print("max:", valor_max, "type:", type(valor_max))