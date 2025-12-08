package ru.stimmax.ru.stimmax.lessons.lesson25.homework

// Задание 1. Функция высшего порядка.
//Создайте функцию timeTracker, которая принимает другую функцию в качестве аргумента и измеряет время её выполнения.
// Функция timeTracker должна возвращать затраченное время в миллисекундах. Для измерения времени используйте System.currentTimeMillis()
// до и после выполнения переданной функции.
//Для проверки результата можно выполнить в ней например такой ресурсоёмкий код:
//
//val myFunction = {
//   val list = List(10000000) { (0..10000).random() }
//   list.sorted()
//}

fun timeTracker(func :() -> Unit): Long {
    val before = System.currentTimeMillis()
    func()
    return System.currentTimeMillis() - before

}
//Задания для работы со scope функциями
//Давайте создадим два класса, которые будут использоваться в заданиях для демонстрации работы scope функций с преобразованием
// объектов и инициализацией или обновлением полей. Классы будут представлять собой Person и Employee, где Employee может
// быть создан на основе данных класса Person.

//Классы для выполнения заданий

class Person(val name: String, val age: Int) {
   var email: String = ""
}

class Employee(val name: String, val age: Int, val position: String) {
   var email: String = ""
   var department: String = "General"
}

fun main() {


//Задание 2: Использование apply для инициализации объекта Employee
//Создайте объект Employee и используйте apply для инициализации его полей email и department.
    val employee = Employee(
        name = "name",
        age = 23,
        position = "2"
    ).apply {
        email
        department
    }

//Задание 3: Использование also для логирования
//Создайте функцию, принимающую объект Person и выводящую информацию об объекте в консоль в красивом, отформатированном виде.
// Используй with для создания контекста Person и возможности использовать поля объекта напрямую без обращения к переменной.
    val func = {
        with(
            Person(
                name = "Ann",
                age = 20
            )
        ) {
            println(email)
        }
    }
//Создайте объект Person и используйте also для добавления почты и печати данных в консоль с помощью метода который
// только что создали.
    Person(
        name = "Ann",
        age = 20
    ).also {
        it.email = "one@gmail.com"
        println(it.email)
    }


//Задание 4: Использование with для преобразование Person в Employee
//Создайте объект класса Person. Используйте функцию with, чтобы создать из этого объекта Employee, указав дополнительно
// должность. Возвращаемым значением должен быть новый объект Employee.

    val person = Person("Ann", 20)
    val employee1 = with(person) {
        Employee(name, age, "2").also {
            it.email
            it.department
        }
    }


//Задание 5: Использование run для преобразования и инициализации Employee
//Перепиши предыдущую задачу на использование run вместо with.
    val employee2 = person.run {
        Employee(name, age, "2").also {
            it.email
            it.department
        }
    }
}

//Задание 6: Использование let для безопасного преобразования Person в Employee
//Создайте функцию toEmployee, которая расширяет класс Person, который может быть null. В функции используйте функцию let
// для создания Employee, только если объект Person не null. В противном случае возвращается null

fun Person?.toEmployee(): Employee?{
    return this?.let {
        Employee(it.name, it.age, "2").also {
            it.email
            it.department
        }
    }
}
