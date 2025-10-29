package ru.stimmax.ru.stimmax.lessons.lesson15.homework

// Потренируйся в создании иерархии классов с расширением базовой сущности.

//Для каждого задания опиши в коде базовый класс с базовыми свойствами и если применимо - методами.

//Для производных классов также добавь специфичные для класса свойства. Детально описывать не нужно, упражнение на то,
// чтобы усвоить иерархию наследования и развитие функциональности у наследников.

//Геометрические Фигуры
//Базовый класс: Геометрическая Фигура
abstract class Figura(
    val name: String,
    val side: Int,
    val color: String
){
    fun getName(){
        println(name)
    }
}
//Производные классы: Многоугольник, Круг
open class Polygon(
     name: String,
     side: Int,
     color: String
): Figura(name, side, color){}
open class Circle(
    name: String,
    side: Int,
    color: String
): Figura(name, side, color){}
//Дополнительное разветвление для Многоугольник: Треугольник, Четырехугольник
class Rectangle(
    name: String,
    side: Int,
    color: String
): Polygon(name, side, color){}
class Quadrilateral(
    name: String,
    side: Int,
    color: String
): Polygon(name, side, color){}


//Учебные Заведения
//Базовый класс: Учебное Заведение
abstract class EducationalInstitution(
    val name: String,
    val year: Int
){}
//Производные классы: Школа, …
open class School(
    name: String,
    year: Int
): EducationalInstitution(name, year){}
open class Univerity(
    name: String,
    year: Int
): EducationalInstitution(name, year){}
//Дополнительное разветвление для …: …
class PrimarySchool(
    name: String,
    year: Int
): School(name, year){}
class MiddleSchool(
    name: String,
    year: Int
): School(name, year){}

//Иерархия Мебели
//Базовый класс: Мебель
abstract class Furniture{}
//Производные классы: …
open class Sofa: Furniture(){}
open class Table: Furniture(){}
//Дополнительное разветвление для …: …
class BigSofa: Sofa(){}
class SmallSofa: Sofa(){}
//Это класс контейнера. Он абстрактный, это означает, что нельзя создавать экземлпяр этого класса, он нужен только для
// того, чтобы быть основой для подклассов.

