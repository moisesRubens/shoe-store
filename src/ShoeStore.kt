class ShoeStore() {
    fun setShoes(vararg items: Shoe) {
        val stock = items.toMutableList()
        println("Stock : ${stock.map{it.type}}")
    }

}