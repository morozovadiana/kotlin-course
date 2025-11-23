package ru.stimmax.ru.stimmax.lessons.lesson22.homework

import ru.stimmax.ru.stimmax.lessons.lesson16.homework.redefenition.Animal
import ru.stimmax.ru.stimmax.lessons.lesson16.homework.redefenition.Dog
import java.util.LinkedList

//Задание 9. Оберни все вызовы из предыдущего задания в блок try-catch и создай для каждого типа ошибки свой catch блок

fun main() {


//NullPointerException
    val nullableString: String? = null // Пример: здесь строка равна null

    try {
        val length = nullableString!!.length // Попытка получить длину у null-строки
        println("Длина строки: $length")
    } catch (e: NullPointerException) {
        println("Произошла ошибка: ${e.message}")

//IndexOutOfBoundsException
        val arg = listOf(1, 2, 3, 4, 5)
        try {
            // Попытка получить доступ к элементу с индексом 10 (которого нет)
            println(arg[10])
        } catch (e: IndexOutOfBoundsException) {
            // Обработка исключения, если доступ по индексу невозможен
            println("Ошибка: Неверный индекс элемента")
        }

// ClassCastException
        val myAnimal: Animal = Dog()

        try {
            // Попытка привести Any (строку) к Int, что приведет к ClassCastException
            val intValue = myAnimal as Dog
            println("Успешно")
        } catch (e: ClassCastException) {
            // Обработка исключения, если приведение не удалось
            println("Ошибка приведения типов: ${e.message}")
        }

//IllegalArgumentException
        try {
            checkAge(25)
            checkAge(-5) // Это вызовет исключение
        } catch (e: IllegalArgumentException) {
            // Блок catch перехватывает IllegalArgumentException.
            println("Ошибка: ${e.message}")
        }

//NumberFormatException
        val str2 = "abc"
        try {
            str2.toInt()
        } catch (e: NumberFormatException) {
        // Эта строка вызовет исключение
            println("Ошибка: ${e.message}")
        }

//IllegalStateException
        val numbers = listOf(1, 2, 3)
        val iterator = numbers.iterator()
        try {
            println(iterator.next())
            println(iterator.next())
            println(iterator.next())
            println(iterator.next())
        } catch (e:IllegalStateException ){
            println("Ошибка: ${e.message}")
        }

//OutOfMemoryError
        try {
            // Создаем большой список, который, вероятно, вызовет ошибку
            val list = mutableListOf<ByteArray>()
            while (true) {
                list.add(ByteArray(1_000_000)) // Добавляем большой массив в список
            }
        } catch (e: OutOfMemoryError) {
            // Обрабатываем исключение, когда память заканчивается
            println("Произошла ошибка OutOfMemoryError: ${e.message}")
        }

//StackOverflowError
        infiniteRecursion()
    }

    fun infiniteRecursion() {
        // Функция вызывает саму себя, не имея условия для завершения
        infiniteRecursion()
    }
}

open class Animal{}
class Dog : Animal(){}

    fun checkAge(age: Int) {
        // Блок try выполняется, пока нет ошибок.
        if (age < 0) {
            // Если возраст отрицательный, генерируется исключение.
            throw IllegalArgumentException("Возраст не может быть отрицательным: $age")
        }
        println("Возраст: $age")
    }
