class ShoeStore() {
    fun setShoeList(vararg items: Shoe) {
        val shoeList = items.toMutableList()
        println("shoeList : ${shoeList.map{it.type}}")
    }

    fun setCostumerList(vararg costumer: Costumer) {
        val costumerList = costumer.toMutableList()
        println("comtumerList: ${costumerList.map{it.name}}")
    }
}