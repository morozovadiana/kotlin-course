package ru.stimmax.ru.stimmax.lessons.lesson9.homework

fun main() {

// Работа с массивами Array
// 1 . Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
    val array1 = arrayOf(1,2,3,4,5)

// 2 . Создайте пустой массив строк размером 10 элементов.
    val array2 = Array(10){""}

// 3 . Создайте массив из 5 элементов типа Double и заполните его значениями, являющимися удвоенным индексом элемента.
    val array3 = doubleArrayOf()
    array3[0] = 3.34
    array3[1] = 4.23

// 4 . Создайте массив из 5 элементов типа Int. Используйте цикл, чтобы присвоить каждому элементу значение, равное его индексу,
// умноженному на 3.
    val array4 = Array(5){ 0 }
    for (element in array4.indices) {
        array4[element] = (element + 1) * 3
    }

// 5 . Создайте массив из 3 nullable строк. Инициализируйте его одним null значением и двумя строками.
    val array5: Array<String?> = arrayOf(null, "kotik", "kotiik")

// 6 . Создайте массив целых чисел и скопируйте его в новый массив в цикле.
    val array6 = arrayOf(1,2,3,4,5)
    var newArray = emptyArray<Int>()
    for (element in 1..array6.size) {
        newArray += array6[element]
    }
    println(newArray)


// 7 . Создайте два массива целых чисел одинаковой длины. Создайте третий массив, вычев значения одного из другого.
// Распечатайте полученные значения.
    val array7 = arrayOf(1,2,3,4,5)
    val newArray7 = arrayOf(6,7,8,9,0)
    var newArray77 = emptyArray<Int>()
    for (element in 1..newArray77.size) {
        newArray77 += array7[element]-newArray7[element]
        println(newArray77)
    }

// 8 . Создайте массив целых чисел. Найдите индекс элемента со значением 5. Если значения 5 нет в массиве, печатаем -1.
// Реши задачу через цикл while.

    val array8 = arrayOf(1,2,3,4,5)
    var i = array8.lastIndex
    while (i++ < array8.size) {
        if (5 in array8) {
            println(5)
            break
        } else
            println(-1)
    }
// 9 . Создайте массив целых чисел. Используйте цикл для перебора массива и вывода каждого элемента в консоль. Напротив
// каждого элемента должно быть написано “чётное” или “нечётное”.
    val array9 = arrayOf(1,2,3,4,5)
    for (i in array9.indices +1) {
        if ((i + 1) % 2 == 0) {
            println("Четное число - ${array9[i]}")
        } else
            println("Нечетное число - ${array9[i]}")
    }

// 10 . Создай функцию, которая принимает массив строк и строку для поиска. Функция должна находить в массиве элемент, в
// котором принятая строка является подстрокой (метод contains()). Распечатай найденный элемент.
    val array10 = arrayOf("My", "Love", "Kotlin")
    arrrayStrings(array10, "Kotlin")


// Работа со списками List
// 1 . Создайте пустой неизменяемый список целых чисел.
    val list1 = emptyList<Int>()

// 2 . Создайте неизменяемый список строк, содержащий три элемента (например, "Hello", "World", "Kotlin").
    val list2 = listOf<String>("Hello", "World", "Kotlin")

// 3 . Создайте изменяемый список целых чисел и инициализируйте его значениями от 1 до 5.
    val list3 = mutableListOf(1,2,3.4,5)

// 4 . Имея изменяемый список целых чисел, добавьте в него новые элементы (например, 6, 7, 8).
    list3.add(6)
    list3.add(7)
    list3.add(8)

// 5 . Имея изменяемый список строк, удалите из него определенный элемент (например, "World").
    val list5 = mutableListOf<String>("Hello", "World", "Kotlin")
    list5.remove( "World")

// 6 . Создайте список целых чисел и используйте цикл для вывода каждого элемента на экран.
    val lisy6 = listOf<Int>(1,2,3,4,5)
    for (el in lisy6) {
        println(el)
    }

// 7 . Создайте список строк и получите из него второй элемент, используя его индекс.
    val list7 = mutableListOf<String>("Hello", "World", "Kotlin")
    list7[1]

// 8 . Имея изменяемый список чисел, измените значение элемента на определенной позиции (например, замените элемент с
// индексом 2 на новое значение).
    val list8 = mutableListOf<Int>(1,2,3,4,5)
    list8[2] = 8

// 9 . Создайте два списка строк и объедините их в один новый список, содержащий элементы обоих списков. Реши задачу с
// помощью циклов.
    val list9 = listOf<Int>(1,2,3,4,5)
    val list91 = listOf<Int>(6,7,8,9)
    val newList = mutableListOf<Int>()
    for (el in list9) {
        newList.add(list9[el])
    }
    for (element in list91) {
        newList.add(list91[element])
    }

// 10 . Создайте список целых чисел и найдите в нем минимальный и максимальный элементы используя цикл.
    val list10 = listOf<Int>(1,2,3,4,5)
    var min = 0
    var max = 0
    for (element in 1..list10.size) {
        if (element > max) {
            max = list10[element]
        }
        else if (element < min) {
            min = list10[element]
        }
    }


// 11 . Имея список целых чисел, создайте новый список, содержащий только четные числа из исходного списка используя цикл.
    val list11 = listOf<Int>(1,2,3,4,5)
    val newList11 = mutableListOf<Int>()
    for (element in list11.indices) {
        if (element % 2 == 0) {
            newList11.add(element)
        }
    }

//Работа с Множествами Set
// 1 . Создайте пустое неизменяемое множество целых чисел.
    val set1 = setOf<Int>()

// 2 . Создайте неизменяемое множество целых чисел, содержащее три различных элемента (например, 1, 2, 3).
    val set2 = setOf<Int>(1,2,3)

// 3 .  Создайте изменяемое множество строк и инициализируйте его несколькими значениями (например, "Kotlin", "Java", "Scala").
    val set3 = mutableSetOf<String>("Kotlin", "Java", "Scala")

// 4 . Имея изменяемое множество строк, добавьте в него новые элементы (например, "Swift", "Go").
    set3.add("Swift")
    set3.add("Go")

// 5 . Имея изменяемое множество целых чисел, удалите из него определенный элемент (например, 2).
    val set4 = mutableSetOf<Int>(1,2,3)
    set4.remove(1)

// 6 .  Создайте множество целых чисел и используйте цикл для вывода каждого элемента на экран.
    val set5 = mutableSetOf<Int>(1,2,3,4,5)
    for (element in set5.indices) {
        println(element)
    }

// 7 . Создай функцию, которая принимает множество строк (set) и строку и проверяет, есть ли в множестве указанная строка.
// Нужно вернуть булево значение true если строка есть. Реши задачу через цикл.
    val set7 = setOf<String>("Kotik", "Kitkat", "kotlin")
    setStrings(set7, "Kotlin")


// 8 . Создайте множество строк и конвертируйте его в изменяемый список строк с использованием цикла.
    val set9 = mutableSetOf<Int>(1,2,3,4,5)
    val newlist9 = mutableListOf<Int>()
    for (element in set9) {
        newlist9.add(element)
    }
}

fun arrrayStrings(string: Array<String>, string1: String) {
    for (element in 1..string.size) {
        if (string[element].contains(string1)) {
            println(string[element])
        } else
            println("Nothing")
    }
}

fun setStrings(string: Set<String>, string1: String) {
    for (element in string) {
        if (element == string1) {
            println("True")
        } else
            println("False")
    }
}