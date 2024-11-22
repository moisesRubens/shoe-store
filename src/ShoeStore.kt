class ShoeStore() {
    var countShoe: Int = 1
    val mutableEmployeeList = mutableListOf<Employee>()
    val employeeList: List<Employee> = mutableEmployeeList
    val customerListMutable = mutableSetOf<Customer>()
    val customerList: Set<Customer> = customerListMutable
    val shoeListMutable = mutableListOf<Shoe>()
    val shoeList: List<Shoe> = shoeListMutable

    fun addEmployee(employee: Employee) {
        if(employeeList.contains(employee)) {
            println("Employee already registered")
            return
        }
        mutableEmployeeList.add(employee).also{ println("Employee registered") }
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
        val category: String = when (option) {
            1 -> "FEMININO"
            2 -> "MASCULINO"
            3 -> "INFANTIL"
            else -> return
        }
        println("Enter a description: ")
        val description: String = readln()
        println("Shoe size: ")
        val size: Float = readln().toFloat()
        println("Price: ")
        val price: Double = readln().toDouble()

        val shoe = Shoe(category, description, size, price, countShoe)
        shoeListMutable.add(shoe).also {
            println("Shoe created")
        }
        countShoe = countShoe + 1
    }

    fun showCostumerList() {
        if (customerList.isEmpty()) {
            println("There is no costumer in list")
            return
        }
        customerList.forEach { println("name: ${it.name} \nCPF: ${it.cpf}") }
    }

    fun showShoeList() {
        if (shoeList.isEmpty()) {
            println("There is no shoe in the stock")
            return
        }

        println("Choose a category: \n1 - FEMININO \n2 - MASCULINO \n3 - INFANTIL")
        val option: Int = readln().toInt()
        var category: String = when (option) {
            1 -> "FEMININO"
            2 -> "MASCULINO"
            3 -> "INFANTIL"
            else -> ""
        }
        var thereItem: Boolean = false
        shoeList.forEach() {
            if (it.category.equals(category)) {
                thereItem = true
                println("(${it.id}) ${it.description}\n    Size: ${it.size}\n    Price: ${it.price}")
            }
        }
        if(thereItem == false)
            println("There is not a show in that category")


    }
}