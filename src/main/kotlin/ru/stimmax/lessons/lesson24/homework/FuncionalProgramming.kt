package ru.stimmax.ru.stimmax.lessons.lesson24.homework

// Задачи на синтаксис функций высшего порядка.

// 1 . Создай функцию, которая:
//принимает булево значение
//принимает функцию, принимающую строку и ничего не возвращающую
//возвращает целое число
fun func1 (arg: Boolean, fnc: (String) -> Unit): Int {
    return 2
}

// 2 . Создай функцию расширения целого числа, которая:
//принимает функцию расширения целого числа, принимающую строку и возвращающую список строк
//возвращает список строк
fun Int.func2 (fnc: Int.(String) -> List<String>): List<String> {
    val a = "smth"
    return fnc(a)
}

// 3 . Создай функцию с двумя дженериками расширяющую первый дженерик, которая:
//принимает функцию расширяющую первый дженерик, ничего не принимает и возвращает второй дженерик
//возвращает второй дженерик
fun <T, K> T.func3(fnc: T.() -> K): K {
    return fnc()
}

// 4 . Создай функцию, которая:
//принимает строку
//возвращает функцию, которая ничего не принимает и возвращает строку
fun func4(arg: String) : () -> String {
    val fnc: () -> String = { arg }
    return fnc
}

// 5 . Создай функцию расширяющую дженерик, которая:
//ничего не принимает
//возвращает функцию, принимающую строку и возвращающую дженерик
fun <T> T.func5(): (String) -> T {
    val fnc: (String) -> T = { this }
    return fnc
}

//Задание 6.
//Скопируй набор кодов цвета и функцию окрашивания строки в переданный в неё цвет из набора.

object Colors {
   const val RESET = "\u001B[0m"
   const val RED = "\u001B[31m"
   const val GREEN = "\u001B[32m"
   const val YELLOW = "\u001B[33m"
   const val BLUE = "\u001B[34m"
   const val PURPLE = "\u001B[35m"
   const val CYAN = "\u001B[36m"
   const val WHITE = "\u001B[37m"
}

fun String.colorize(color: () -> String): String {
   return "$color$this${Colors.RESET}"
}
//Напиши функцию colorizeWords которая печатает слова из длинного предложения разбитого по пробелу разным цветом.
// Правило подбора цвета для каждого слова нужно передавать в виде функции, которая принимает слово и возвращает это же слово но
// уже "в цвете" через функцию colorize.
//Функция colorizeWords должна расширять строку и эту же строку и обрабатывать.

fun String.colorizeWords(fnc: (String) -> String) {
    val words = split(" ")
    words.joinToString(" ") { it.colorize { fnc(it) } }
    println(words)
}

//Напиши несколько функций обработки слов:

//цвет слова зависит от его характеристик (для каждой характеристики отдельный цвет):
//начинается с большой буквы
val fun1 = { word: String ->
    when {
        word[0] == word[0].uppercase()[0] -> Colors.WHITE
        //длина меньше трёх символов
        word.length < 3 -> Colors.RED
        //длина больше 6 символов
        word.length > 6 -> Colors.PURPLE
        //длина кратна двум
        word.length % 2 == 0 -> Colors.YELLOW
        //для всех прочих отдельный цвет.
        else -> Colors.GREEN

    }
}
//цвет слова выбирается по очереди из списка цветов для каждого слова через счётчик. Когда счётчик доходит до края списка
// слов - он обнуляется и начинается заново.
fun main() {
    var counter = 0

    val listColors = listOf(Colors.GREEN, Colors.YELLOW, Colors.PURPLE, Colors.RED, Colors.WHITE)
    val fun2 = { word: String ->
        if (counter >= listColors.size)
            counter = 0
        listColors[counter++]
    }
//цвет слова выбирается по очереди из списка цветов для каждого слова через счётчик. Счётчиком управляет функция,
// находящаяся в изменяемой переменной. Сначала это функция с инкрементом счётчика. Когда счётчик доходит до края списка
// цветов, нужно заменить функцию счётчика на функцию с декрементом. Когда счётчик доходит до нуля - заменить функцию
// счётчика на функцию с инкрементом и так далее.

    var counter2 = { counter++ }

    val fun3 = { word: String ->
        if ( counter < listColors.size)
            counter2 = { counter-- }
        if (counter < 0) {
            counter++
            counter2 = { counter++ }
        }
        listColors[counter2()]
    }

//Создай переменную с длинным текстом (например из этого урока) и вызови у этой переменной функцию colorizeWords и передай
// в неё по очереди каждую из функций, проверь результат в консоли.
    val longString =
        "Создай переменную с длинным текстом (например из этого урока) и вызови у этой переменной функцию colorizeWords и передай\n" +
                "// в неё по очереди каждую из функций, проверь результат в консоли"

    longString.colorizeWords ( fun1 )
    longString.colorizeWords (fun2 )
    longString.colorizeWords ( fun3 )


}
