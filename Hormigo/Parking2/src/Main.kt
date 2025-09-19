import Exceptions.VehicleAlredyParkedException
import model.Parking
import model.Vehicle

fun main() {

    val parking = Parking(5)
    var exit: Boolean = false

    do {
        println("Eliga una opción: ")
        val option: String = readln()
        val optionAsInt = option.toIntOrNull()
        when (optionAsInt) {
            1 -> {
                do {
                    var wrongPlate = false
                    println("Introduzca una matrícula: ")
                    val plate = readln()
                    try {
                        parking.park(Vehicle(plate))
                    } catch (ex:VehicleAlredyParkedException) {
                        wrongPlate = true
                    }
                } while (wrongPlate)
            }
            2 -> {

            }
            3 -> {

            }
            4 -> {
                exit = true
            }
            null -> {}
        }
    } while (!exit)
}