val rds = ShoeStore()
var option: Int? = null
var countShoe: Int = 1

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
            if(rds.showShoeList() == null)
                return
            val costumer = Costumer()
            println("Enter an option as buy: ")
            val option: Int = readln().toInt()
            val category: String = when(option) {
                1 -> "Casual"
                2 -> "Running"
                3 -> "Training"
                else -> ""
            }
            val shoeBought: Shoe? = costumer.buy(rds, category)
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
        1 -> run {
            println("Category of shoe: \n1 - Casual \n2 - Running \n3 - Training")
            val option: Int = readln().toInt()
            val category: String = when(option) {
                1 -> "Casual"
                2 -> "Running"
                3 -> "Training"
                else -> run {
                    println("Error")
                    return
                }
            }
            val shoe = Shoe(category, countShoe)
            rds.addShoe(shoe)
            countShoe = countShoe+1
            println("Shoe created")
        }
        2 -> rds.showShoeList()
        3 -> rds.showCostumerList()
        4 -> option = 3
        else -> return
    }
}