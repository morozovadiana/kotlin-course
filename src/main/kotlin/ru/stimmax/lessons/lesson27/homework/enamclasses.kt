package ru.stimmax.ru.stimmax.lessons.lesson27.homework

import ru.stimmax.ru.stimmax.lessons.lesson22.homework.tryException

// Задание 1
//Создай Enum со статусами прохождения теста (passed, broken, failed).

enum class Enum (){
    PASSED,
    BROKEN,
    FAILED
    ;
}
//Создай Enum с типами жилой недвижимости для сайта аренды, включая человекопонятные названия этих типов.

enum class Enum1 (val arg: String) {
    HOUSE("дом"),
    FLAT("квартира"),
    APARTMENT("апартаменты")
    ;
}

//Создай Enum с планетами солнечной системы, включая расстояние до солнца в астрономических единицах и вес планеты.

enum class Enum3 (destination: Double, weight: Double) {
    mercury (0.39, 0.055),
    venera(0.72, 0.815),
    worth(1.00, 1.0),
    mars(1.52, 0.107),
    upiter(5.20, 318.0),
    saturn(9.58, 95.0),
    uran(19.20, 14.5),
    neptun (30.05, 17.0)
    ;
}

//Задание 2
//Создай функцию, которая выводит на печать человекочитаемые названия типов недвижимости в порядке возрастания длины названия enum.

fun printRealEstate () {
    println(Enum1.entries.sortedBy { it.name.length })
}

//Задание 3
//Создай функцию, которая принимает лямбду без аргументов и возвращаемого значения и возвращает Enum со статусом прохождения
// теста в зависимости от того как выполнится принятая лямбда:

fun func1 (fnc: () -> Unit): Enum {
    return try {
        fnc()
//если без исключений - PASSED
        Enum.PASSED
    }
//если будет AssertionError - FAILED
    catch (e: AssertionError) {
        Enum.FAILED
    }
//прочие исключения  - BROKEN
    catch (e: Throwable) {
        Enum.BROKEN
    }


}
//Задание 4
//Создай функцию, которая принимает лямбду и возвращает enum планеты. Лямбда должна принимать планету и возвращать булево
// значение. Лямбда здесь выступает в качестве фильтра, который должен отфильтровать список всех планет по какому-либо
// (расстояние или вес). Вернуть нужно первый элемент из отфильтрованного списка или выкинуть исключение если список пустой.

fun func2 (fnc: (Enum) -> Boolean ) : Enum {
    return Enum.entries.firstOrNull(fnc) ?: throw IllegalArgumentException("doesn't found")
}




//Дополнительные задачи за дополнительные баллы

//Дополнительное задание 1 Светофор
//Заготовка для задачи:

enum class Colors(val value: String) {
   RED_COLOR("\u001B[31m"),
   YELLOW_COLOR("\u001B[33m"),
   GREEN_COLOR("\u001B[32m"),
   RESET_COLOR("\u001B[0m")
}

const val LIGHT_SYMBOL = "\u25CF"

// Функция для отображения сигнала
//fun showSignal(signal: TrafficLightSignal, altDuration: Long? = null) {
//    print("\r" + signal.color.value + LIGHT_SYMBOL + Colors.RESET_COLOR.value) // Выводим сигнал с возвратом каретки
//    Thread.sleep(altDuration ?: signal.duration)
//}

fun clear() {
    print("\r    ")
    Thread.sleep(300)
}
//Создай enum с перечислением для светофора. Enum должен включать цвет из класса Colors, длительность сигнала duration
// и количество миганий blinkTimes (может быть null). Мигание нужно установить только для зелёного сигнала.

enum class FlashLight(colors: Colors, val duration: Int, val blinkTimes: Int?) {
    GREEN(Colors.GREEN_COLOR, 10, 3),
    YELLOW(Colors.YELLOW_COLOR, 5, null),
    RED(Colors.RED_COLOR, 15, null)
    ;
}

//Реализовать функцию с бесконечным циклом, которая будет выводить сигналы светофора в порядке: красный (например 4 сек),
// жёлтый (например 2 сек), зелёный (например 3 сек), зелёный мигающий (например 4 раза).

//Отображение сигнала выполняется через showSignal(), после чего clear(), чтобы было видимое переключение.

//Мигание выполняется через попеременный вызов showSignal() с переопределением задержки в 300мс (второй аргумент) и clear().

//Дополнительное задание 2
//Заготовки для задачи

enum class CoffeeType(val cost: Double, val coffeeBase: String, val recommendedSugar: Int, val hasMilk: Boolean = false) {
   ESPRESSO(2.50, "Espresso", 0),
   LATTE(3.00, "Latte", 2, true),
   CAPPUCCINO(2.75, "Cappuccino", 1, true),
   AMERICANO(2.25, "Americano", 0);

   fun description() = "The $coffeeBase ${if (hasMilk) "with" else "without"} milk costs \$$cost and is best with $recommendedSugar spoons of sugar."
}

enum class CharacterTypes {
   CTO,
   UX_UI,
   CRM, // Customer Relationship Manager
   GAME_DEV,
   TEAM_LEAD,
   BACKEND_DEV,
   PM,
   SYSADMIN,
   QA
}


//Напиши функцию, которая определит, какой тип кофе предложить посетителю исходя из его функциональной принадлежности.

//Эспрессо - СТО или тимлид
//Латте - дизайнеры и геймдев
//Капучино - Менеджеры
//Американо - бэкендеры и сисадмины
//Для QA добавь в enum ещё один вид напитка: Nescafe classic

//Реши задачу через доработку enum CharacterTypes