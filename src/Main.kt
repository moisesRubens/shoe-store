val rds = ShoeStore()
var option: Int? = null

fun main() {
    do {
        println("SISTEMA DE CALÇADOS")
        println("1 - COSTUMER \n2 - EMPLOYEE \n3 - EXIT")
        print("Choose an option: ")
        option = readln().toInt()

        when(option) {
            1 -> showOptionsCostumer()
            2 -> showOptionsEmployee()
        }
    } while(option != 3)

}

fun showOptionsCostumer() {
    println("1 - BUY \n2 - VIEW SHOES \n3 - REGISTER \n4 - EXIT")
    var costumerOption: Int = readln().toInt()
    when(costumerOption) {
        1 -> run {
            if(rds.shoeList.isEmpty()) {
                println("Empty stock")
                return
            }
            val costumer = Costumer()
            rds.showShoeList()
            println("Enter an option as buy: ")
            val option: Int = readln().toInt()
            val shoeBought: Shoe? = costumer.buy(rds, option)
        }
        2 -> rds.showShoeList()
        3 ->run {
            println("Name: ")
            val name: String = readln()
            println("CPF: ")
            val cpf: String = readln()
            rds.addCostumer(Costumer(name, cpf))
        }
        4 -> option = 3
        else -> return
    }
}
fun showOptionsEmployee() {
    println("1 - REGISTER SHOE \n2 - VIEW SHOE STOCK \n3 - VIEW COSTUMER LIST \n4 - EXIT")
    val employeeOption = readln().toInt()

    when(employeeOption) {
        1 -> rds.addShoe()
        2 -> rds.showShoeList()
        3 -> rds.showCostumerList()
        4 -> option = 3
        else -> return
    }
}