class Costumer (var name: String = "", var cpf: String = "") {
    var nonpayment: Boolean = false

    fun buy(shoeStore: ShoeStore, index: Int): Shoe? {
        if(nonpayment) {
            println("You cannot buy")
            return null
        }
        val shoe: Shoe? = shoeStore.shoeListMutable.find {it.id == index}

        if(shoe == null) {
            println("This shoe does not exist in the stock")
            return null
        }

        shoeStore.shoeListMutable.remove(shoe).also {
            println("Buy sucess")
        }
        return shoe
    }
}