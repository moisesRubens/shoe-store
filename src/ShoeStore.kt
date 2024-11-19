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
        costumerList.forEach {println("name: ${it.name} \nCPF: ${it.cpf}") }
    }

    fun showShoeList() {
        shoeList.forEach() {println("ID - ${it.id} \nCATEGORY - ${it.category}\n")}
    }
}