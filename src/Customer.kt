

class Customer (var name: String = "", var cpf: String = "") {

    var nonpayment: Boolean = false

    fun buy(customer: Customer, store: ShoeStore): Order? {
        val collection = mutableListOf<Any>()

        if(rds.shoeList.isEmpty() || customer.nonpayment || !rds.showShoeList())
            return null

        println("Enter the ID of the shoe: ")
        val optionId: Int = readln().toInt()
        println("Enter the quantity of shoes: ")
        val quantity: Int = readln().toInt()

        if(quantity > store.shoeListMutable.count{ it.id == optionId} || quantity < 1) {
            println("Enter a valid quantity")
            return null
        }
        collection.add(quantity)
        collection.addAll(store.shoeListMutable.filter { it.id == optionId })

        var count: Int = 0
        store.shoeListMutable.removeAll {
            if(it.id == optionId && count<=quantity) {
                count++
                true
            } else
                false
        }
        val shoe: Shoe = collection.find { it is Shoe } as Shoe
        println("Total value: ${shoe.price* quantity}")
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
            if(payment < shoe.price*quantity) {
                println("Error. Enter a suficient value")
                return null
            }
        } else {
            println("1 - INPUT VALUE\n 2 - NO")
            val input: Int = readln().toInt()
            var amountPending: Double = shoe.price * quantity

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

        val order = Order(collection)
        return order
    }
}