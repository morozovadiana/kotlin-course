package ru.stimmax.ru.stimmax.lessons.lesson31.homework

class PhoneNumberFormatter {
    fun formatPhoneNumber(param: String): String {
        var clearStringFromSymbols = param.replace("\\D".toRegex(), "")
        if (clearStringFromSymbols.length < 10 || clearStringFromSymbols .length > 11){
            throw IllegalArgumentException()
        }
        if (clearStringFromSymbols.length == 11 && clearStringFromSymbols[0] == '7' || clearStringFromSymbols[0] == '8') {
            clearStringFromSymbols.drop(1)
        } else if (clearStringFromSymbols.length == 10){
             clearStringFromSymbols = " " + clearStringFromSymbols
        } else throw IllegalArgumentException()
        val firstDigit = clearStringFromSymbols.substring(1, 4)
        val secondDigit = clearStringFromSymbols.substring(4,7)
        val thirdDigit = clearStringFromSymbols.substring(8,10)
        val fourDigit = clearStringFromSymbols.substring(9,11)
        return "+7 ($firstDigit) $secondDigit-$thirdDigit-$fourDigit"
    }
}

