package ru.stimmax.ru.stimmax.lessons.lesson17.homework.Calculator

class Multiplication(inputString: String) : Operation(inputString) {
     fun makeMultiplication() : Int{
            return getFirstDigit() * getSecondDigit()
    }

}