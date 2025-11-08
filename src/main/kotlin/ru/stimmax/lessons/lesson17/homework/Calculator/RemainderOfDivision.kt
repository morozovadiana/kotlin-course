package ru.stimmax.ru.stimmax.lessons.lesson17.homework.Calculator

open class RemainderOfDivision(inputString: String) : Operation(inputString) {
     fun makeRemainderOfDivision() : Int{
            return getFirstDigit() % getSecondDigit()
    }

}