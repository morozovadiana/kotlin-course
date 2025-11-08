package ru.stimmax.ru.stimmax.lessons.lesson17.homework.Calculator

class Division(inputString: String) : Operation(inputString) {
     fun makeDivision() : Int{
            return getFirstDigit() / getSecondDigit()
    }

}