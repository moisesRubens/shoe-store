fun main() {
    do {
        println("SISTEMA DE CALÇADOS")
        println("1 - COSTUMER \n2 - EMPLOYEE \n3 - EXIT")
        print("Choose an option: ")
        var option = readln().toInt()

        when(option) {
            1 -> showOptionsCostumer()
            2 -> showOptionsEmployee()
        }
    } while(option != 3)
}

fun showOptionsCostumer() {
    println("1 - BUY \n2 - VIEW SHOES \n3 - REGISTER \n4 - EXIT")
    val option = readln().toInt()

    when(option) {
        1 -> null
        2 -> null
        3 -> null
        4 -> return
        else -> null

    }
}

fun showOptionsEmployee() {
    println("1 - REGISTER SHOE \n2 - VIEW SHOE STOCK \n3 - VIEW COSTUMER STOCK \n4 - EXIT")
    val option = readln().toInt()

    when(option) {
        1 -> null
        2 -> null
        3 -> null
        4 -> return
        else -> null
    }
}