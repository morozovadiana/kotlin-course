package ru.stimmax.ru.stimmax.lessons.lesson08.homework

fun main() {
    upperCase("ghj ghj gjh ghj gjh")
    table(22, 68)
}
// 7. Все слова с большой буквы
// Напишите метод, который преобразует строку из нескольких слов в строку, где каждое слово начинается с заглавной буквы
// а все остальные - строчные. Используй перебор, анализ символов и замену букв на заглавную с помощью метода uppercase()
// для конкретной буквы.
//

fun upperCase(arg: String) {
    val words = arg.split(" ")
    var firstWord = true
    var resultString = ""
    for (word in words) {
        if (word.isNotEmpty()) {
            if (!firstWord) {
                resultString += " "
            }
            resultString += word[0].uppercase()
            for (i in 1..word.length) {
                resultString += word.lowercase()
            }
            firstWord = false
        }
    }
    println(resultString)
}

//8. Игра в разведчика
//Напишите шифратор/дешифратор для строки. Шифровка производится путём замены двух соседних букв между собой: Kotlin
// шифруется в oKltni. Дешифровка выполняется аналогично.
//
//Если длина строки - нечётная, в конец добавляется символ пробела до начала шифрования. Таким образом все шифрованные
// сообщения будут с чётной длинной. Должно получиться два публичных метода: encrypt() и decrypt() которые принимают строку
// и печатают результат в консоль.
//

fun evenOdd (arg: String) {
    if (arg.length % 2 != 0) {
        "$arg "
    } else {
        arg
    }
}

fun scoutGame(string: String) {
    val evenOddString = evenOdd(string).toString()
    var resultString = ""
    for (i in evenOddString.toString().indices step 2) {
        resultString += evenOddString[i + 1] + evenOddString[i].toString()
    }
    println(resultString)
}

fun encrypt(input: String) {
    println(scoutGame(input))
}

fun decrypt(input: String) {
    println(scoutGame(input)).toString().trimEnd()
}

//9. Таблица умножения
//
// Напишите функцию, которая принимает два числа и выводит таблицу умножения, у которой в заголовках столбцов и строк находятся
// перемножаемые числа, а в перекрестии заголовка и столбца - результат перемножения. Важно: каждый столбец должен быть
// выровнен по правому краю с помощью шаблона с форматированием строк. Размер форматирования каждой строки нужно вычислять
// динамически для каждого столбца. Результат должен быть похож на этот пример:
//
//Таблица умножения
fun table(arg1: Int, arg2: Int) {
    for (i in 1..arg1) {
        for (j in 1..arg2) {
                    print("${ (i * j).toString().format("%10s", arg2) } ")
                }
        println("\n")
    }
}