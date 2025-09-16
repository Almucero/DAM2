//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val cochesAparcados = mutableSetOf(
        "0000 NBB", "0001 NBB", "1234 NBD", "5678 NBL", "4321 NBW",
        "9999 NBZ", "0147 NBY", "2000 NBV", "3456 NBX", "6789 NBC",
        "2468 NBM", "1357 NBR", "3141 NBV", "2718 NBW", "3142 NBZ",
        "4310 NBF", "5214 NBH", "6890 NBJ", "7777 NBL", "8080 NBV",
        "9090 NBW", "1010 NBX", "2121 NBN", "3232 NBP", "4343 NBS",
        "5454 NBT", "6565 NBV", "7676 NBW", "8787 NBX", "9898 NBY",
        "1111 NBZ", "2222 NBC", "3333 NBD", "4444 NBF", "5555 NBH",
        "6666 NBJ", "7770 NBK", "8888 NBL", "9991 NBM", "1230 NBN"
    )
    while (true) {
        println("--APARCAMIENTO--")
        println("Eliga que quiere hacer:")
        println("1.- Aparcar coche")
        println("2.- Desaparcar coche")
        println("3.- Listar coches")
        println("4.- Salir")
        try {
            val opcion = readln().toInt()
            when (opcion) {
                1 -> {
                    println("Escriba su matrícula")
                    val matricula = readln()
                    if (cochesAparcados.contains(matricula)) {
                        println("Ese coche ya esta aparcado")
                    }
                    else {
                        cochesAparcados.add(matricula)
                        println("Coche aparcado")
                    }
                }
                2 -> {
                    println("Escriba la matrícula")
                    val matricula = readln()
                    if (cochesAparcados.contains(matricula)) {
                        cochesAparcados.remove(matricula)
                        println("Has desaparcado")
                    }
                    else {
                        println("Ese coche no esta aparcado")
                    }
                }
                3 ->  {
                    for (elemento in cochesAparcados) {
                        println(elemento)
                    }
                }
                4 -> break
                else -> println("Opción incorrecta")
            }
        }
        catch (e:Exception) {
            println("Error; No introduciste un número")
        }
    }
    //aparcar coche, te pide matricula y verifica que no haya uno con la misma
    //desaparcar coche, te pide matricula y mira si esta el coche
    //listar coches aparcados
    //salir
}