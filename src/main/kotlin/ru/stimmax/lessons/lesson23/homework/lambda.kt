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
    return groupBy { it }
        .filter { it.value.size > 1 }
        .values.flatten() as Set<Int>
}
//Создай аналогичную анонимную функцию.

val dubles1 = fun List<Int>.(): Set<Int>{
    return groupBy { it }
        .filter { it.value.size > 1 }
        .values.flatten() as Set<Int>
}

//Создай аналогичное лямбда выражение с указанием типа.
val dubles2: List<Int>.() -> Set<Int> = {
    groupBy { it }
        .filter { it.value.size > 1 }
        .values.flatten() as Set<Int>
}

//Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.
