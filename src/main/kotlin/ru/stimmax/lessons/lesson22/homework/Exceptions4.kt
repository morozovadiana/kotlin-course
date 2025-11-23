package ru.stimmax.ru.stimmax.lessons.lesson22.homework

//Задание 11. Создай свой тип исключения в отдельном файле, наследуемый от AssertionError и принимающий текст. Выброси
// это исключение в main
class MyExc(message: String?): AssertionError(message){
}
//Задание 12. Создай свой тип исключения в отдельном файле, наследуемый от RuntimeException и принимающий IndexOutOfBoundsException
// тип в качестве аргумента. Напиши код, который спровоцирует выброс IndexOutOfBoundsException, перехвати его с помощью try-catch
// и в блоке catch выведи сообщение в консоль и сделай выброс своего типа исключения.
class MyExc1(message: IndexOutOfBoundsException): RuntimeException(message){
}

fun main() {
   // throw MyExc("Error")
    val list = listOf("a", "b", "c")

    try {
        val element = list[5]
        println("Элемент: $element")
    } catch (e: IndexOutOfBoundsException) {
        throw MyExc1(e)
    }
}