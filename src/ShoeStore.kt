import java.io.File


class ShoeStore() {
    var countShoe: Int = 1
    val mutableEmployeeList = mutableListOf<Employee>()
    val employeeList: List<Employee> = mutableEmployeeList
    val customerListMutable = mutableSetOf<Customer>()
    val customerList: Set<Customer> = customerListMutable
    val shoeListMutable = mutableListOf<Shoe>()
    val shoeList: List<Shoe> = shoeListMutable
    val descriptionShoes = mutableListOf<String>()

    //TESTE DE MANIPULACAO
    var fp: File? = null
    fun addEmployee() {
        println("Name: ")
        val name: String = readln()
        println("CPF: ")
        val cpf: String = readln()
        /*if (cpf.length != 11) {
            println("Enter a valid CPF")
        return
        }*/
        val employee = Employee(name, cpf)
        if(employeeList.contains(employee)) {
            println("Employee already registered")
            return
        }
        mutableEmployeeList.add(employee).also{ println("Employee registered") }
        fp = File("relatorio_employees.txt")
        fp?.appendText("Name: ${employee.name} \nCPF: ${employee.cpf} \n\n" )
    }

    fun addCostumer(customer: Customer) {
        if (customerListMutable.contains(customer)) {
            println("Customer already registered")
            return
        }
        customerListMutable.add(customer).also {println("Customer registered")}
    }

    fun addShoe() {
        println("Choose a category: \n1 - FEMININO \n2 - MASCULINO \n3 - INFANTIL")
        val option: Int = readln().toInt()
        val category: String = when(option) {
            1 -> "FEMININO"
            2 -> "MASCULINO"
            3 -> "INFANTIL"
            else -> return
        }
        println("Enter a description: ")
        val description: String = readln()
        if(!descriptionShoes.contains(description))
            descriptionShoes.add(description)
        println("Shoe size: ")
        val size: Float = readln().toFloat()
        println("Price: ")
        val price: Double = readln().toDouble()
        println("Enter a quanitity: ")
        var quantity: Int = readln().toInt()

        repeat(quantity) {
            shoeListMutable.add(Shoe(category, description, size, price, countShoe))
        }
        countShoe = countShoe+1
        println("Shoe(s) registered")
    }

    fun showCostumerList() {
        if (customerList.isEmpty()) {
            println("There is no costumer in list")
            return
        }
        customerList.forEach { println("name: ${it.name} \nCPF: ${it.cpf}") }
    }

    fun showShoeList(): Boolean{
        if (shoeList.isEmpty()) {
            println("Empty stock")
            return false
        }

        println("Choose a category: \n1 - FEMININO \n2 - MASCULINO \n3 - INFANTIL")
        val option: Int = readln().toInt()
        var category: String = when(option) {
            1 -> "FEMININO"
            2 -> "MASCULINO"
            3 -> "INFANTIL"
            else -> ""
        }

        var thereItem: Boolean = false
        val shownId = mutableListOf<Int>()

        shoeList.forEach { shoe ->
            if ((shoe.category == category) && (shoe.id !in shownId)) {
                thereItem = true
                shownId.add(shoe.id)

                val totalQuantity = shoeList.count { it.description == shoe.description }
                println("quantity: $totalQuantity\n    (${shoe.id}) ${shoe.description}\n    Size: ${shoe.size}\n    Price: ${shoe.price}")
            }
        }

        if (thereItem == false) {
            println("There is not a shoe")
            return false
        } else
            return true
    }

    fun showEmplyeeList(): String {
        fp = File("relatorio_employees.txt")
        return fp?.readText() ?: "This txt file is empty"
    }
}