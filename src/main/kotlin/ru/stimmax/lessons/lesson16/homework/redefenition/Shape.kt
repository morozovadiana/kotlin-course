package ru.stimmax.ru.stimmax.lessons.lesson16.homework.redefenition

// 2 . Геометрические Фигуры и Их Площадь
//Абстрактный (базовый) класс: Shape с open методом area().
//Классы наследники: Circle, Square, Triangle.
//Метод area() возвращает 0.0.
//Переопределите метод area() в каждом классе-наследнике для расчета площади соответствующей фигуры.
//Подсказка: каждый класс должен иметь аргументы конструктора, позволяющие вычислить площадь (для круга это радиус,
// для квадрата это сторона, для треугольника это две стороны и угол между ними)
//Создай набор геометрических фигур и выведи в цикле их площадь

abstract class Shape {
    open fun area(): Double {
        return 0.0
    }
}

class Circle(
    val side: Int
): Shape() {
    override fun area(): Double {
        return  3.14 * side
    }
}

class Square(
    val side: Int
): Shape() {
    override fun area(): Double {
        return (side * side).toDouble()
    }
}
class Triangle(
    val side1: Int,
    val side2: Int,
    val sinus: Int
): Shape(){
    override fun area(): Double {
        return (side1 * side2) * 0.5 * sinus
    }
}


fun main() {
    // 2 .
    val circle = Circle(4)
    circle.area()
    val square = Square(2)
    square.area()
    val triangle = Triangle(1,3,6)
    triangle.area()

    val togethers = listOf(circle, square, triangle)
    togethers.forEach {
        println(it.area())
    }

}