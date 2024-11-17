val rds = ShoeStore()
val eu = Costumer("Moises", "233")
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
        1 -> run {
            println("Enter your name: ")
            val name: String = readln()
            val costumer = rds.costumerListMutable.find {it.name == name}
            if(costumer == null) return
            rds.showShoeList()
            println("Enter the type shoe: ")
            val type = readln()
            costumer.buy(rds, type)
        }
        2 -> rds.showShoeList()
        3 ->run {
            println("Name: ")
            val name: String = readln()
            println("CPF: ")
            val cpf: String = readln()
            rds.addCostumer(Costumer(name, cpf))
        }
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
        3 -> rds.showCostumerList()
        4 -> return
        else -> null
    }
}