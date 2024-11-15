class ShoeStore() {
    val costumerList = mutableListOf<Costumer>()
    val shoeList = mutableListOf<Shoe>()

    fun addCostumer(costumer: Costumer) {
        costumerList.add(costumer)
    }

    fun addShoe(shoe: Shoe) {
        shoeList.add(shoe)
    }
}