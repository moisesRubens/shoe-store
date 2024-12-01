class Customer (var name: String = "", var cpf: String = "") {
    var nonpayment: Boolean = false

    fun buy(customer: Customer): Shoe? {
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
        rds.showShoeList()
        println("Enter an option as buy: ")
        val option1: Int = readln().toInt()
        println("Enter an quantity: ")
        val quantity: Int = readln().toInt()

        val shoe: Shoe? = rds.shoeListMutable.find { it.id == option1 }
        if(shoe == null) {
            println("This shoe does not in the stock")
            return null
        }
        println("Total value: ${shoe.price * quantity}")
        println("1 - ONE-TIME PAYMENT \n2 - INSTALLMENT PAYMENT")
        val option = readln().toInt()
        var paymentMethod: String = when(option) {
            1 -> "ONE-TIME PAYMENT"
            2 -> "INSTALLMENT PAYMENT"
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
            val installment = readln().toInt()
            if(installment<1 || installment>10)
                return null
        } else
            return null

        repeat(quantity) {
            rds.shoeListMutable.remove(shoe)
        }.also { println("Purchase successful") }

        return shoe
    }
}