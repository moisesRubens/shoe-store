class Order(val shoe: Shoe, var quantity: Int, var paymentMethod: String, inputValue: Double = 0.0) {
    var unitValue: Double = shoe.price
    var totalValue: Double = unitValue*quantity
    var pendingAmount: Double = totalValue-inputValue
    var description: String = shoe.description

    fun getOrder() {
        println("DESCRIPTION: $description")
        println("TOTAL VALUE: $totalValue")
    }
}