//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    do {
        println("SISTEMA DE CALÇADOS")
        println("1 - COSTUMER \n2 - EMPLOYEE")
        print("Choose an option: ")
        val option = readln().toInt()

        when(option) {
            1 -> println("A")
            2 -> println("B")
        }
    } while(option != 3)
}