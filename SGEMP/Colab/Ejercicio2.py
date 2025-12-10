"""
Ejercicio 2: Multiplicación de cadenas con validación numérica
Declara dos variables numéricas, m y n. Elige valores enteros, positivos o negativos (pero evita el cero).
Calcula:
suma = m + n
distancia = abs(m - n)
Define una cadena aviso = "¡Atención! "
Crea una variable mensaje que sea la concatenación de "Diferencia: " con el valor de distancia convertido a string.
Usa str(distancia) para la conversión.
Si suma es mayor que 0, define otra cadena repetir_texto = aviso * suma.
Si suma es negativo, define repetir_texto como ("[-] " + aviso) * abs(suma).
Muestra por pantalla:
El valor de mensaje.
El valor de repetir_texto.
"""

m = 1
n = 2
suma = m + n
distancia = abs(m - n)
aviso = "¡Atención! "
mensaje = "Diferencia: ", str(distancia)

if (suma>0):
    repetir_texto = aviso * suma
elif (suma<0):
    repetir_texto = ("[-] " + aviso) * abs(suma)

print(mensaje)
print(repetir_texto)