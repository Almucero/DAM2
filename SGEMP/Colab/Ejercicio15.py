"""
Ejercicio 15: Tuplas
Dada la siguiente tupla:

numeros = (3, -2, 7, 0, -5, 10)

Recorre la tupla con un for y crea una nueva tupla donde:
Los números positivos aparezcan duplicados (x2).
Los números negativos se conviertan en su valor absoluto.
El valor 0 se ignore (no aparece en la nueva tupla).
Muestra la tupla resultante.
"""

numeros = (3, -2, 7, 0, -5, 10)
temp = []

for elemento in numeros:
    if (elemento>0):
        temp.append(elemento*2)
    elif (elemento<0):
        temp.append(abs(elemento))

tupla = temp

print(tupla)
