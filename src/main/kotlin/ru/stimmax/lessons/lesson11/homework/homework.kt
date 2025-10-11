package ru.stimmax.ru.stimmax.lessons.lesson11.homework

fun main() {
    fun2(5,2)
    val list = listOf(1, 2, 3, 4, 5)
    fun4(list)

    println(multiplyByTwo(5))
    println(isEven(5))
    println(printNumbersUntil(5))
    val listDigits = listOf<Int>(1,2,3,4,-5, -8)
    println(findFirstNegative(listDigits))
    val listString = listOf<String?>("Kate", "Mary", null)
    println(processList(listString))

}

// Задачи на сигнатуру метода
//Напишите сигнатуру метода в которую входит модификатор доступа, название функции, список аргументов с типами и возвращаемое
// значение. В теле метода можешь сделать возврат объекта нужного типа если это требуется для устранения ошибок.

// 1 . Не принимает аргументов и не возвращает значения.
fun fun1() {}

// 2 . Принимает два целых числа и возвращает их сумму.
fun fun2(a: Int, b: Int): Int = a + b

// 3 . Принимает строку и ничего не возвращает.
fun fun3(a: String) {}

// 4 . Принимает список целых чисел и возвращает среднее значение типа Double.
fun fun4(a: List<Int>): Double{
    return a.average().toDouble()
}

// 5 . Принимает nullable строку и возвращает её длину в виде nullable целого числа и доступна только в текущем файле.
private fun fun5(a: String?): Int?{
    return a?.length?.toInt()
}

// 6 . Не принимает аргументов и возвращает nullable вещественное число.
fun fun6(): Float? {
    return 0F
}

// 7 . Принимает nullable список целых чисел, не возвращает значения и доступна только в текущем файле.
private fun fun7(a: List<Int>?) {}

// 8 . Принимает целое число и возвращает nullable строку.
fun fun8(a: Int): String? {
    return a.toString()
}

// 9 . Не принимает аргументов и возвращает список nullable строк.
fun fun9(): List<String?> {
    val a = listOf("1", "2", "3", "4", "5")
    return a
}

// 10 . Принимает nullable строку и nullable целое число и возвращает nullable булево значение.
fun fun10(a: String?, b: Int?): Boolean? {
    return null
}

//Задачи на написание кода
//Напишите валидную сигнатуру метода а так же рабочий код для задач.

// 11 . Напишите функцию multiplyByTwo, которая принимает целое число и возвращает его, умноженное на 2.
fun multiplyByTwo(a: Int): Int = a * 2

// 12 .  Создайте функцию isEven, которая принимает целое число и возвращает true, если число чётное, и false в противном случае.
fun isEven(a: Int): Boolean{
    if (a % 2 == 0)
        return true
    else
        return false
}

// 13 . Напишите функцию printNumbersUntil, которая принимает целое число n и выводит на экран числа от 1 до n. Если число
// n меньше 1, функция должна прекратить выполнение с помощью return без вывода сообщений.
fun printNumbersUntil(n: Int) {
    for (i in 1..n) {
        if (n > 1) {
            println(i)
        } else
            return
    }
}

// 14 . Создайте функцию findFirstNegative, которая принимает список целых чисел и возвращает первое отрицательное число
// в списке. Если отрицательных чисел нет, функция должна вернуть null.
fun findFirstNegative(a: List<Int>): Int? {
    for (i in a) {
        if (i < 0) {
            return i
            break
        }
    }
    return null
}

// 15 . Напишите функцию processList, которая принимает список строк. Функция должна проходить по списку и выводить
// каждую строку. Если встречается null значение, функция должна прекратить выполнение с помощью return без возврата значения.
fun processList(a: List<String?>) {
    for (i in a){
        if (i == null){
            return
        } else
            println(i)
    }
}