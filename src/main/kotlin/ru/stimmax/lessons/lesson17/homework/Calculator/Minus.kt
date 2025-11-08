package ru.stimmax.ru.stimmax.lessons.lesson17.homework.Calculator

 class Minus(inputString: String) : Operation(inputString) {
     fun makeMinus() : Int{
            return getFirstDigit() - getSecondDigit()
    }

}