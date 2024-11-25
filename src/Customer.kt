class Customer (var name: String = "", var cpf: String = "") {
    var nonpayment: Boolean = false

    fun buy(shoeStore: ShoeStore, index: Int, quantity: Int): Order? {
        if(nonpayment) {
            println("You cannot buy")
            return null
        }
        val shoe: Shoe? = shoeStore.shoeListMutable.find { it.id == index }

        if(shoe == null) {
            println("This shoe does not exist in the stock")
            return null
        }

        if(quantity > shoeStore.shoeList.count { it == shoe }) {
            println("Foi aqui")
            return null
        }

        println("1 - ONE-TIME PAYMENT\n 2 - INSTALLMENT PAYMENT")
        val option = readln().toInt()
        val paymentMethod: String = when(option) {
            1 -> "ONE-TIME PAYMENT"
            2 -> "INSTALLMENT PAYMENT"
            else -> ""
        }
        val payment: Double
        var inputValue: Double = 0.0
        if(option == 1) {
            payment = readln().toDouble()
            if(payment < shoe.price*quantity)
                return null
        } else if(option == 2) {
            println("1 - INPUT VALUE\n 2 - NO")
            val input: Int = readln().toInt()
            if(input == 1) {
                println("Value: ")
                inputValue = readln().toDouble()
            }
            println("Installment count(1 - 10): ")
            var installment = readln().toInt()
            if(installment<1 || installment>10)
                return null
        } else
            return null

        repeat(quantity) {
            shoeStore.shoeListMutable.remove(shoe)
        }.also { println("Shoe(s) removed") }

        val order = Order(shoe, quantity, paymentMethod, inputValue)
        return order
    }
}