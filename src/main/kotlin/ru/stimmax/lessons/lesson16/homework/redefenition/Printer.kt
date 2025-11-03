package ru.stimmax.ru.stimmax.lessons.lesson16.homework.redefenition

import ru.stimmax.ru.stimmax.lessons.lesson16.lesson.Background
import ru.stimmax.ru.stimmax.lessons.lesson16.lesson.Colors
import ru.stimmax.ru.stimmax.lessons.lesson16.lesson.printColored

// 3 . Принтер
//Создай абстрактный принтер, который имеет абстрактный метод печати, принимающий в качестве аргумента строку.
//Создай классы наследники: лазерный и струйный
//Лазерный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно чёрными буквами на белом
// фоне (хорошо работает на тёмной теме)
//Струйный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно цветными буквами на цветном
// фоне. Слова должны быть разноцветны. Можно сделать список пар с цветом текста и фона и проходить циклически по этому
// списку при выводе текста. Проверить работу на длинном тексте

abstract class Printer {
    abstract fun print(text: String)
    protected fun printText(text: String, map: List<Pair<String, String>>) {
        val splitText = text.split(" ")
        var index = 0
        for (i in splitText.indices){
            if (index < map.size){
                printColored(splitText[i], map[index].first, map[index].second)
            }
        }
    }
}

class Laser: Printer() {
    override fun print(text: String) {
        val map = listOf(Colors.BLACK to Background.WHITE)
        printText(text, map)
    }
}

class Stryinyi: Printer() {
    override fun print(text: String) {
        val map = listOf(Colors.YELLOW to Background.WHITE, Colors.RED to Background.PURPLE, Colors.BLACK to Background.GREEN, Colors.CYAN to Background.BLUE)
        printText(text, map)
    }
}


fun main() {
    // 3 .
    val laser = Laser()
    laser.print("tetete trttrgt ghnhgn hjmfhmh")
    val stryinyi = Stryinyi()
    stryinyi.print("fdg dfg fg sd")
}