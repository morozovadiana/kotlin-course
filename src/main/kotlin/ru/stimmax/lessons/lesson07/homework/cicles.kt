package ru.stimmax.ru.stimmax.lessons.lesson07.homework

fun main() {

// Задания для цикла for
// Прямой диапазон
// 1 . Напишите цикл for, который выводит числа от 1 до 5.
    val consequence = 1..5
    for (i in consequence) {
         //println(i)
    }
// 2 . Напишите цикл for, который выводит четные числа от 1 до 10.
    val consequen = 1..10
    for (i in consequen) {
        if (i % 2 == 0) {
            //println(i)
        }
    }

// Обратный диапазон
// 3 . Создайте цикл for, который выводит числа от 5 до 1.
    val conseq = 5 downTo 1
    for (i in conseq) {
        //println(i)
    }

// 4 . Создайте цикл for, который выводит числа от 10 до 1, уменьшая их на 2.
    val con = 10 downTo 1
    for (i in con - 1) {
        //println(i-2)
    }

// С шагом (step)
// 5 . Используйте цикл for с шагом 2 для вывода чисел от 1 до 9.
    val enumirate = 1..9
    for (i in enumirate step 2) {
        //println(i)
    }

// 6 . Напишите цикл for, который выводит каждое третье число в диапазоне от 1 до 20.
    val enum = 1..20
    for (i in enum step 3) {
        //println(i)
    }

// Использование до (until)
// 7 . Создайте числовую переменную 'size'. Используйте цикл for с шагом 2 для вывода чисел от 3 до size не включая size.
    val size = 13
    for (i in 3 until size step 2) {
        //println(i)
    }

// Задания для цикла while
// Цикл while
// 8 . Создайте цикл while, который выводит квадраты чисел от 1 до 5.
    var counter = 0
    while (counter++ < 5) {
        //println(counter * counter)
    }

// 9 . Напишите цикл while, который уменьшает число от 10 до 5. После этого вывести результат в консоль
    var counte = 10
    while (counte >= 5) {
        //println(counte)
        counte--
    }

//Цикл do while
// 10 . Используйте цикл do while, чтобы вывести числа от 5 до 1.
    var count = 5
    do {
        //println(count)
        count--
    } while (count >= 1)

// 11 . Создайте цикл do while, который повторяется, пока счетчик меньше 10, начиная с 5.
    var coun = 5
    do {
        //println(coun)
        coun++
    } while (coun < 10)

// Задания для прерывания и пропуска итерации
// Использование break
// 12 . Напишите цикл for от 1 до 10 и используйте break, чтобы выйти из цикла при достижении 6.
    for (i in 1..10) {
        if (i == 6) break
        //println(i)
    }

// 13 . Создайте цикл while, который бесконечно выводит числа, начиная с 1, но прерывается при достижении 10.
    var cou = 1
    while (cou < 100) {
        if (cou == 10) break
        //println(cou)
        cou++
    }

// Использование continue
// 14 . В цикле for от 1 до 10 используйте continue, чтобы пропустить четные числа.
    for (i in 1..10) {
        if (i % 2 == 0) continue
        //println(i)
    }

// 15 . Напишите цикл while, который выводит числа от 1 до 10, но пропускает числа, кратные 3.
    var co = 0
    while (co <= 10) {
        co++
        if (co % 3 == 0) continue
        //println(co)

    }

    multiplicationTable(10)
    sumArg(10)
    factorial(5)
    sumEvenNumbers(10)
    rectangle(5, 3)
    sumEvenAndOddNumbers(7)
}
// Задача повышенной сложности (разбирается отдельно от основной домашки и награждается отдельным стимом за разбор).
// Её выполнять по желанию, проверка не выполняется.

// 1 . Используя вложенный цикл реализовать таблицу умножения, как на картинке.
fun multiplicationTable (arg: Int) {
    for(i in 1..arg){
        for(j in 1..arg){
            print((i * j).toString() + " ")
        }
        println()
    }
}

// 2 . Напишите функцию, которая суммирует числа от 1 до 'arg' с помощью цикла for. 'arg' - целочисленный аргумент функции.
fun sumArg (arg: Int) {
    var counter = 0
    for (i in 1..arg) {
        counter += i
    }
    println("Сумма чисел от 1 до " + arg + " = " + counter)
}

// 3 . Напишите функцию, которая вычисляет факториал числа 'arg' с использованием цикла while.
// произведение всех натуральных чисел
fun factorial (arg: Int) {
    var counter = 1
    for (i in 1..arg) {
        counter *= i
    }
    println("Факториал числа " + counter)
}

// 4 . Напишите функцию, которая находит сумму всех четных чисел от 2 до 'arg', используя цикл while.
fun sumEvenNumbers (arg: Int) {
    var counter = 2
    var sum = 0
    while (counter <= arg) {
        counter++
        if (counter % 2 == 0)
            sum += counter
    }
   println("Сумма четных чисел " + sum)
}

// 5 . Напишите функцию, которая используя вложенные циклы while, выведет заполненный прямоугольник размером 5x3 из символов *.
fun rectangle (arg1: Int, arg2: Int) {
    var rows = 0
    var coloms = 0
    while (rows <= arg1){
        rows++
        while (coloms <= arg2) {
            coloms++
            print("*")
        }
        coloms = 0
        println()
    }
}
// 6 . Напишите функцию, которая используя цикл for найдёт суммы чётных и нечётных значений чисел от 1 до arg.
fun sumEvenAndOddNumbers (arg: Int) {
    var even = 0
    var odd = 0
    var counter = 0
    for (i in 1..arg){
        if (i % 2 == 0) {
            even += i
        } else
            odd  += i
    }
    println("Сумма четных чисел " + even)
    println("Сумма нечетных чисел " + odd)
}

