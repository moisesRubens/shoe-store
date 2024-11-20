class Costumer (var name: String, var cpf: String) {
    var nonpayment: Boolean = false

    constructor() : this("", "")

    fun buy(shoeStore: ShoeStore, shoeType: String): Shoe? {
        if(nonpayment) {
            println("You cannot buy")
            return null
        }
        val shoe: Shoe? = shoeStore.shoeListMutable.find {it.category == shoeType}

        if(shoe == null) {
            println("This shoe does not exist in the stock")
            return null
        }
        println("Buy sucess")
        shoeStore.shoeListMutable.remove(shoe)
        return shoe
    }
}