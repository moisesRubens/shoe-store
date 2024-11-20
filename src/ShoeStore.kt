class ShoeStore() {
    val costumerListMutable = mutableSetOf<Costumer>()
    val costumerList: Set<Costumer> = costumerListMutable
    val shoeListMutable = mutableListOf<Shoe>()
    val shoeList: List<Shoe> = shoeListMutable

    fun addCostumer(costumer: Costumer) {
        if(costumerListMutable.add(costumer)) {
            println("Registration successful")
            return
        }
        println("This costumer is already registered")
    }

    fun addShoe(shoe: Shoe) {
        shoeListMutable.add(shoe)
    }

    fun showCostumerList() {
        if(costumerList.isEmpty()) {
            println("There is no costumer in list")
            return
        }
        costumerList.forEach {println("name: ${it.name} \nCPF: ${it.cpf}") }
    }

    fun showShoeList(): List<Shoe>?{
        if(shoeList.isEmpty()) {
            println("There is no shoe in the stock")
            return null
        }
        shoeList.forEach() {println("ID - ${it.id} \nCATEGORY - ${it.category}\n")}
        return shoeList
    }
}