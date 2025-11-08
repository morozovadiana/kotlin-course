package ru.stimmax.ru.stimmax.lessons.lesson17.homework.Calculator

 open class Plus(inputString: String) : Operation(inputString) {
     fun makePlus() : Int{
        return getFirstDigit() + getSecondDigit()

    }

}