import kotlin.math.E

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
    val costumerOption: Int = readln().toInt()
    when(costumerOption) {
        1 -> {
            val customer = Customer()
            val order: Order? = customer.buy(customer, rds)
            if(order == null) {
                println("You do not bought a shoe.")
                return
            }
            order.getOrder(customer)
        }
        2 -> rds.showShoeList()
        3 -> {
            println("Name: ")
            val name: String = readln()
            println("CPF: ")
            val cpf: String = readln()
            rds.addCostumer(Customer(name, cpf))
        }
        4 -> option = 3
        else -> {
            println("Choose a valid option")
            showOptionsCostumer()
        }
    }
}
fun showOptionsEmployee() {
    println("1 - REGISTER SHOE \n2 - VIEW SHOE STOCK \n3 - VIEW COSTUMER LIST \n4 - REGISTER AS EMPLOYEE \n5 - VIEW EMPLOYEE LIST \n6 - EXIT")
    val employeeOption = readln().toInt()

    when(employeeOption) {
        1 -> {
            println("Enter your name: ")
            val name: String = readln()
            println("Enter your cpf: ")
            val cpf: String = readln()
            val employee = Employee(name, cpf)
            if(!rds.employeeList.contains(employee)) {
                println("Error")
                return
            }
            employee.addShoe(rds)
        }
        2 -> rds.showShoeList()
        3 -> rds.showCostumerList()
        4 -> rds.addEmployee()
        5 -> println(rds.showEmplyeeList())
        6 -> option = 3
        else -> {
            println("Choose a valid option")
            showOptionsEmployee()
        }
    }
}