package ru.stimmax.ru.stimmax.lessons.lesson17.homework.Calculator

abstract class Operation(
    val inputString: String
) {
    protected fun splitString(): List<String> {
        return inputString.split(" ")
    }

   protected fun getFirstDigit(): Int {
        return splitString().first().toInt()
    }

    protected fun getSecondDigit(): Int {
        return splitString().last().toInt()
    }

}
