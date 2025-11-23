package ru.stimmax.ru.stimmax.lessons.lesson22.homework

import ru.stimmax.ru.stimmax.lessons.lesson16.homework.redefenition.Animal
import ru.stimmax.ru.stimmax.lessons.lesson16.homework.redefenition.Dog
import java.util.LinkedList

// Воспроизвести фрагменты кода, которые могут привести к возникновению исключений:
fun main() {


//NullPointerException
    var name: String? = null // Переменная, которая может быть null
    val length: Int = name!!.length // Попытка получить длину строки без проверки на null

//IndexOutOfBoundsException
    val arg = listOf(1, 2, 3, 4, 5)
    println(arg[20])

//ClassCastException

    val myAnimal: Animal = Dog()
    // Эта строка вызовет ClassCastException
    val myDog: Dog = myAnimal as Dog // Ошибка, потому что myAnimal не является Dog

//IllegalArgumentException
    val number = -1
    if (number < 0) {
        println(number)
    }

//NumberFormatException
    val str2 = "abc"
    val num2 = str2.toInt() // Эта строка вызовет исключение

//IllegalStateException
    val numbers = listOf(1, 2, 3)
    val iterator = numbers.iterator()
    println(iterator.next())
    println(iterator.next())
    println(iterator.next())
    println(iterator.next())

//OutOfMemoryError
    val list = LinkedList<ByteArray>()
    var i = 0
    while (true) {
        val largeArray = ByteArray(10 * 1024 * 1024) // 10 МБ
        list.add(largeArray)
        i++
        println("Добавлено $i объектов")
    }

//StackOverflowError
    infiniteRecursion()
}

fun infiniteRecursion() {
    // Функция вызывает саму себя, не имея условия для завершения
    infiniteRecursion()
}

open class Animal
class Dog : Animal(){}
