class Order(val shoe: Shoe, val customer: Customer) {
    fun getOrder(quantity: Int, paymentMethod: String, installments: Int? = null) {
        println("\nORDER\n")
        println("CUSTOMER INFORMATION: ")
        println("Name: ${customer.name}")
        println("Cpf: ${customer.cpf}\n")
        println("ORDER DESCRIPTION: ")
        println("${shoe.category} - ${shoe.description}")
        println("Size: ${shoe.size}")
        println("Unit value: ${shoe.price}")
        println(" ")
        println("TOTAL VALUE: ${shoe.price*quantity}")
        println("PAYMENT METHOD: $paymentMethod")
        if(paymentMethod.equals("INSTALLMENT PAYMENT")) {
            println("INSTALLMENTS: $installments")
            println("AMOUNT PENDING: ${shoe.price * quantity}")
        }
    }
}