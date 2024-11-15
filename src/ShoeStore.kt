class ShoeStore() {
    val costumerListMutable = mutableListOf<Costumer>()
    val costumerList: List<Costumer> = costumerListMutable
    val shoeListMutable = mutableListOf<Shoe>()
    val shoeList: List<Shoe> = shoeListMutable

    fun addCostumer(costumer: Costumer) {
        costumerListMutable.add(costumer)
    }

    fun addShoe(shoe: Shoe) {
        shoeListMutable.add(shoe)
    }

    fun showCostumerList() {
        println(costumerList.map{it.name})
    }

    fun showShoeList() {
        println(shoeList.map{it.type})
    }
}