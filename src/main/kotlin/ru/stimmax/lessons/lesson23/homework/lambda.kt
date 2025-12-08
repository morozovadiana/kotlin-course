package ru.stimmax.ru.stimmax.lessons.lesson23.homework

// 1 . Создай функцию, которая принимает список чисел и возвращает среднее арифметическое всех чётных чисел этого списка.
// С помощью require проверь, что список не пустой.
fun fun1(arg: List<Int>): Double {
    var counter = mutableListOf<Int>()
    require(arg.isNotEmpty())
    arg.indices.forEach { if(arg[it] % 2 == 0 ) counter.add(arg[it])}
    return counter.average()
}
// 1 . Создай аналогичную анонимную функцию.
val fun2 = fun (arg: List<Int>): Double {
    var counter = mutableListOf<Int>()
    require(arg.isNotEmpty())
    arg.indices.forEach { if(arg[it] % 2 == 0 ) counter.add(arg[it])}
    return counter.average()
}
// 2 . Создай аналогичное лямбда выражение с указанием типа.

val fun3: (List<Int>) -> Double = {arg ->  var counter = mutableListOf<Int>()
    require(arg.isNotEmpty())
    arg.indices.forEach { if(arg[it] % 2 == 0 ) counter.add(arg[it])}
     counter.average()}

//Создай лямбда выражение без указания типа.
val fun4 = { arg: List<Int> ->  var counter = mutableListOf<Int>()
    require(arg.isNotEmpty())
    arg.indices.forEach { if(arg[it] % 2 == 0 ) counter.add(arg[it])}
    counter.average()}

//Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных (в том числе пустого).


// 2 . Создай функцию, которая принимает большое число и возвращает сумму цифр этого числа. Сделай проверку, что входящее
// число больше нуля. Подсказка: для парсинга символа в число можно использовать функцию digitToInt()
fun fun5(arg: Long): Int{
    require(arg > 0)
    return arg.toString().sumOf { it.digitToInt()}
}
//Создай аналогичную анонимную функцию.

val fun6 = fun(arg: Long): Int{
    require(arg > 0)
    return arg.toString().sumOf { it.digitToInt()}
}

//Создай аналогичное лямбда выражение с указанием типа.

val fun7: (Long) -> Int = { arg ->
    require(arg > 0)
    arg.toString().sumOf { it.digitToInt()}

}

//Создай лямбда выражение без указания типа.

val fun8 = {arg: Long -> require(arg > 0)
     arg.toString().sumOf { it.digitToInt()}
}

//Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.
// 3 . Создай функцию-расширение списка чисел, которая будет возвращать множество дубликатов чисел (встречающихся в списке
// более одного раза).

fun List<Int>.dubles(): Set<Int>{
    return toSet().associate { element ->
        element to this.count { it == element }
    }.filter { it.value > 1 }
        .keys
}
//Создай аналогичную анонимную функцию.

val dubles1 = fun List<Int>.(): Set<Int>{
    return toSet().associate { element ->
        element to this.count { it == element }
    }.filter { it.value > 1 }
        .keys
}

//Создай аналогичное лямбда выражение с указанием типа.
val dubles2: List<Int>.() -> Set<Int> = {
     toSet().associate { element ->
        element to this.count { it == element }
    }.filter { it.value > 1 }
        .keys
}

//Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.
fun main() {
    val list1 = listOf<Int>()
    val list2 = listOf(1)
    val list3 = listOf(1, 2, 3, 4, 5, 6)
    println(fun3(list3))

    val l = listOf(0, 1, 2, 4, 2, 5, 6, 5, 7)
    println(l.dubles2())
}