package ru.stimmax.ru.stimmax.lessons.lesson15.homework

// Потренируйся в создании иерархии классов с расширением базовой сущности.

//Для каждого задания опиши в коде базовый класс с базовыми свойствами и если применимо - методами.

//Для производных классов также добавь специфичные для класса свойства. Детально описывать не нужно, упражнение на то,
// чтобы усвоить иерархию наследования и развитие функциональности у наследников.

//Геометрические Фигуры
//Базовый класс: Геометрическая Фигура
abstract class Figura{}
//Производные классы: Многоугольник, Круг
open class Polygon: Figura(){}
open class Circle: Figura(){}
//Дополнительное разветвление для Многоугольник: Треугольник, Четырехугольник
class Rectangle: Polygon(){}
class Quadrilateral: Polygon(){}


//Учебные Заведения
//Базовый класс: Учебное Заведение
abstract class EducationalInstitution{}
//Производные классы: Школа, …
open class School: EducationalInstitution(){}
open class Univerity: EducationalInstitution(){}
//Дополнительное разветвление для …: …
class PrimarySchool: School(){}
class MiddleSchool: School(){}

//Иерархия Мебели
//Базовый класс: Мебель
abstract class Furniture{}
//Производные классы: …
open class Sofa: Furniture(){}
open class Table: Furniture(){}
//Дополнительное разветвление для …: …
class BigSofa: Sofa(){}
class SmallSofa: Sofa(){}
//Это класс контейнера. Он абстрактный, это означает, что нельзя создавать экземлпяр этого класса, он нужен только для того, чтобы быть основой для подклассов.

