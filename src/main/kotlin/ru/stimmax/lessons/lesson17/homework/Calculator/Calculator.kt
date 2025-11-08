package ru.stimmax.ru.stimmax.lessons.lesson17.homework.Calculator


class Calculator(inputString: String) : Operation(inputString) {
    fun chooseOperation(){
        val operand = splitString().get(1)
        val result = when(operand) {
            "+" -> Plus(inputString).makePlus()
            "-" -> Minus(inputString).makeMinus()
            "*" -> Multiplication(inputString).makeMultiplication()
            "/" -> Division(inputString).makeDivision()
            "%" -> RemainderOfDivision(inputString).makeRemainderOfDivision()
            else -> {print("Nothing")}
        }
        print(result)
    }
}

fun main() {
    val expression = "20 % 3"
    val calculator = Calculator(expression)
    calculator.chooseOperation().toString()
}