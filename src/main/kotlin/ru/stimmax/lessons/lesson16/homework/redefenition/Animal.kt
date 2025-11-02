package ru.stimmax.ru.stimmax.lessons.lesson16.homework.redefenition

import ru.stimmax.ru.stimmax.lessons.lesson16.lesson.Colors
import ru.stimmax.ru.stimmax.lessons.lesson16.lesson.printColored

// Переопределение методов

// 1 . Животные и Их Звуки
//Базовый класс: Animal с методом makeSound().
//Классы наследники: Dog, Cat, Bird.
//Базовый метод makeSound() в классе Animal выводит "This animal makes no sound."
//Переопределите метод makeSound() в каждом классе-наследнике, чтобы Dog выводил "Bark", Cat - "Meow", Bird - "Tweet".
// Обогати вывод звуков цветом.
//Создайте список животных List<Animal> и вызовите в цикле метод makeSound()
abstract class Animal() {
    open fun makeSound(color: String) {
        println("This animal makes no sound $color")
    }
}

class Dog: Animal() {
    override fun makeSound(color: String) {
        println("Bark $color")
    }
}

class Cat: Animal() {
    override fun makeSound(color: String) {
        println("Meow $color")
    }
}

class Bird: Animal() {
    override fun makeSound(color: String) {
      println("Tweet $color")
    }
}


fun main() {
    // 1 .
    val dog = Dog()
    dog.makeSound(Colors.RED)
    val cat = Cat()
    cat.makeSound(Colors.GREEN)
    val bird = Bird()
    bird.makeSound(Colors.PURPLE)

    val together = listOf(dog, cat, bird)
        together.forEach {
            it.makeSound(Colors.RED)
        }
}