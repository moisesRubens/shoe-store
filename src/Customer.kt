

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
                println("Error. You are nonpayment")
                return null
            }
        }
        if(rds.showShoeList() == false)
            return null

        println("Enter an option as buy: ")
        val option1: Int = readln().toInt()
        println("Enter an quantity: ")
        val quantity: Int = readln().toInt()
        if(quantity > store.shoeListMutable.count{ it.id == option1} || quantity < 1) {
            println("Enter a valid quantity")
            return null
        }
        collection.add(quantity)
        val shoes: List<Shoe> = store.shoeListMutable.filter { it.id == option1 }.take(quantity)
        collection.addAll(shoes)
        shoes.forEach { store.shoeListMutable.remove(it) }

        println("Total value: ${ shoes[0].price * quantity}")
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
            println("Enter the payment: ")
            payment = readln().toDouble()
            if(payment < shoes[0].price*quantity) {
                println("Error. Enter a suficient value")
                return null
            }
        } else {
            println("1 - INPUT VALUE\n 2 - NO")
            val input: Int = readln().toInt()
            var amountPending: Double = shoes[0].price * quantity

            if(input == 1) {
                println("Entry amount: ")
                inputValue = readln().toDouble()
                amountPending = amountPending - inputValue
            }
            collection.add(amountPending)
            println("Number of installments(1 - 10): ")
            val installments = readln().toInt()
            if(installments<1 || installments>10)
                return null
            collection.add(installments)
            val installmentsPrice: Double = amountPending / installments
            collection.add(installmentsPrice)
        }

        return collection
    }
}