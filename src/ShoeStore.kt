class ShoeStore() {
    var countShoe: Int = 1
    val costumerListMutable = mutableSetOf<Costumer>()
    val costumerList: Set<Costumer> = costumerListMutable
    val shoeListMutable = mutableListOf<Shoe>()
    val shoeList: List<Shoe> = shoeListMutable

    fun addCostumer(costumer: Costumer) {
        if (costumerListMutable.add(costumer)) {
            println("Registration successful")
            return
        }
        println("This costumer is already registered")
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
        if (costumerList.isEmpty()) {
            println("There is no costumer in list")
            return
        }
        costumerList.forEach { println("name: ${it.name} \nCPF: ${it.cpf}") }
    }

    fun showShoeList() {
        if (shoeList.isEmpty())
            println("There is no shoe in the stock")

        println("Choose a category: \n1 - FEMININO \n2 - MASCULINO \n3 - INFANTIL")
        val option: Int = readln().toInt()
        var category: String = when (option) {
            1 -> "FEMININO"
            2 -> "MASCULINO"
            3 -> "INFANTIL"
            else -> ""
        }
        shoeList.forEach() {
            if (!it.category.equals(category)) {
                println("There are shoes of this type")


                println("(${it.id}) ${it.description} - ${it.size} - ${it.price}")
            }
        }
    }
}