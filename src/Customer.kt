

class Customer (var name: String = "", var cpf: String = "") {
    var nonpayment: Boolean = false

    fun buy(customer: Customer, store: ShoeStore): MutableList<Any>? {
        val collection = mutableListOf<Any>()
        when {
            rds.shoeList.isEmpty() -> {
                println("Empty stock")
                return null
            }
            customer.nonpayment -> {
                println("Error. You are nopayment")
                return null
            }
        }
        if(rds.showShoeList() == false)
            return null

        println("Enter an option as buy: ")
        val option1: Int = readln().toInt()
        println("Enter an quantity: ")
        val quantity: Int = readln().toInt()

        if(quantity > store.shoeListMutable.count{ it.id == option1} || quantity < 1)
            return null

        repeat(quantity) {
            collection.add(store.shoeListMutable.removeAt(option1-1))
        }

        val shoe = collection[0] as Shoe
        println("Total value: ${ shoe.price * quantity}")
        println("Enter your name: ")
        customer.name = readln()
        println("Enter your cpf: ")
        customer.cpf = readln()
        println("1 - ONE-TIME PAYMENT \n2 - INSTALLMENT PAYMENT")
        val option = readln().toInt()
        var paymentMethod: String = when(option) {
            1 -> "ONE-TIME PAYMENT".also { collection.add(it) }
            2 -> "INSTALLMENT PAYMENT".also { collection.add(it) }
            else -> {
                println("Enter an available option")
                return null
            }
        }
        var payment: Double = 0.0
        var inputValue: Double = 0.0
        if(option == 1) {
            println("Enter with a payment: ")
            payment = readln().toDouble()
            if(payment < shoe.price*quantity) {
                println("Error. Enter a suficient value")
                return null
            }
        } else if(option == 2) {
            println("1 - INPUT VALUE\n 2 - NO")
            val input: Int = readln().toInt()
            if(input == 1) {
                println("Input value: ")
                inputValue = readln().toDouble()
            }
            println("Installment count(1 - 10): ")
            val installment = readln().toInt().also { collection.add(it) }
            if(installment<1 || installment>10)
                return null
        } else
            return null

        repeat(quantity) {
            rds.shoeListMutable.remove(shoe)
        }.also { println("Purchase successful") }

        return collection
    }
}