class Order(val collection: MutableList<Any>) {
    var doubles = collection.filterIsInstance<Double>().toTypedArray()
    var shoes = collection.filterIsInstance<Shoe>().toTypedArray()
    var strings = collection.filterIsInstance<String>().toTypedArray()
    var ints = collection.filterIsInstance<Int>().toTypedArray()

    fun getOrder(customer: Customer) {

        println("DETAILS ORDER\n")

        println("CUSTOMER:")
        println("NAME: ${customer.name}")
        println("CPF: ${customer.cpf}")
        println("----------")
        println("SHOE:")
        println("DESCRIPTION: ${shoes[0].description}")
        println("SIZE: ${shoes[0].size}")
        println("UNIT VALUE: ${shoes[0].price}")
        println("----------")

        val totalValue = shoes[0].price * ints[0]
        println("TOTAL VALUE: $totalValue")
        println("PAYMENT METHOD: ${strings[0]}")
        if (strings[0] == "INSTALLMENT PAYMENT") {
            if(doubles[0] < shoes[0].price*ints[0]) {
                println("AMOUNT PENDING: %.2f".format(doubles[0]))
            }
            println("QUANTITY INSTALLMENTS: ${ints[1]}")
            println("INSTALLMENT VALUE: %.2f".format(doubles[1]))
        }
    }
}