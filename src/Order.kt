class Order(val shoe: Shoe, val customer: Customer, var collection: Collection<Any>) {
    fun getOrder() {
        val paymentMethod = collection.find { it is String }
        println("\nORDER\n")
        println("CUSTOMER INFORMATION: ")
        println("Name: ${customer.name}")
        println("Cpf: ${customer.cpf}\n")
        println("ORDER DESCRIPTION: ")
        println("${shoe.category} - ${shoe.description}")
        println("Size: ${shoe.size}")
        println("Unit value: ${shoe.price}")
        println(" ")
        println("TOTAL VALUE: ${shoe?.price?.times(collection.find { it is Double } as? Double? ?: 0.0)}")
        println("PAYMENT METHOD: $paymentMethod")
        if(paymentMethod == "INSTALLMENT PAYMENT") {
            println("INSTALLMENTS: ${collection.find { it is Int }}")
            println("AMOUNT PENDING: ${shoe?.price?.times(collection.find { it is Double } as? Double ?: 0.0)}")

        }
    }
}