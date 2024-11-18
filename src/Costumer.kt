class Costumer (var name: String, var cpf: String?) {
    var nonpayment: Boolean = false

    fun buy(shoeStore: ShoeStore, shoeType: String) {
        if(nonpayment) {
            println("You cannot buy")
            return
        }
        val shoe: Shoe? = shoeStore.shoeListMutable.find {it.category == shoeType}

        if(shoe == null) {
            println("This shoe does not exist in the stock")
            return
        }
        println("Buy sucess")
        shoeStore.shoeListMutable.remove(shoe)
    }
}