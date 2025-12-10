"""
Ejercicio 5: Repetición condicional con controles aritméticos
Crea tres variables:
precio_unitario (float)
unidades (int)
descuento (int, un porcentaje, por ejemplo 10 para 10%)
Calcula:
costo_bruto = precio_unitario * unidades
costo_neto = costo_bruto - (costo_bruto * descuento / 100)
Crea una variable repeticiones = int(costo_neto // (unidades + descuento)).
Asegúrate de que no sea cero; si sale 0, incrementa manualmente repeticiones en 1.
Define una cadena alerta = "Oferta!".
Si costo_neto es mayor que (costo_bruto / 2), imprime alerta * repeticiones.
En caso contrario, imprime "Compra insuficiente".
Muestra en pantalla el costo_neto. Usa type() para comprobar que es float.
"""

precio_unitario = 10.0
unidades = 5
descuento = 20

costo_bruto = precio_unitario * unidades
costo_neto = costo_bruto - (costo_bruto * descuento / 100)
repeticiones = int(costo_neto // (unidades + descuento))

if (repeticiones==0):
    repeticiones+=1

alerta = "Oferta!"

if (costo_neto>(costo_bruto/2)):
    print(alerta * repeticiones)
else:
    print("Compra insuficiente")

print("Costo neto: ", costo_neto, "Tipo:", type(costo_neto))