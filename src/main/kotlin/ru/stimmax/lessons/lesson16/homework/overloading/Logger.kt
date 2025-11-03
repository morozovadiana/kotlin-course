package ru.stimmax.ru.stimmax.lessons.lesson16.homework.overloading

import ru.stimmax.ru.stimmax.lessons.lesson16.lesson.Background
import ru.stimmax.ru.stimmax.lessons.lesson16.lesson.Colors
import ru.stimmax.ru.stimmax.lessons.lesson16.lesson.printColored

// 5 . Класс “Логгер”: представляет из себя инструмент для вывода информации в консоль с разным префиксами уровня логирования
// (INFO, WARNING, ERROR, DEBUG)
class Logger {

    // 1 . Базовый метод log(message) выводит в консоль сообщение message с префиксом INFO
    fun log(message: String) {
        println("INFO -> $message")
    }

    // 2 . Выполнить перегрузку метода log, который:
// 1 . Принимает уровень логирования и сообщение. Выводит сообщения типа WARNING жёлтым цветом, а ERROR белым цветом
// на красном фоне.
    fun log(message: String, level: String) {
        when (level) {
            "WARNING" -> printColored(message, Colors.YELLOW)
            "ERROR" -> printColored(message, Colors.WHITE, Background.RED)
            else -> println(message)
        }
    }
        // 2 . Принимает список сообщений и все их выводит с уровнем INFO
        fun log(messageList: List<String>) {
            messageList.forEach { println(log(it)) }
        }

        // 3 . Принимает объект типа Exception и выводит его поле message с префиксом уровня ERROR
        fun log(exception: Exception) {
            println("ERROR -> ${exception.message}")
        }
}

fun main() {
    // 3 . Попробуй создать логгер и добавить в него сообщения разными способами. Проверь вывод в консоли.
    val logger = Logger()
    logger.log("smth went wrong")
    logger.log("smth went wrong", "ERROR")
    val list = listOf("smth went wrong", "smth went wrong", "smth went wrong" )
    logger.log(list)
    val e = IndexOutOfBoundsException("smth went wrong")
    logger.log(e)
}