package ru.stimmax.ru.stimmax.lessons.lesson10.homework

fun main() {

// Задачи на работу со словарём
// 1 . Создайте пустой неизменяемый словарь, где ключи и значения - целые числа.
    val map1 = mapOf<Int, Int>()

// 2 . Создайте словарь, инициализированный несколькими парами "ключ-значение", где ключи - float, а значения - double
    val map2 = mapOf<Float, Double>()

// 3 . Создайте изменяемый словарь, где ключи - целые числа, а значения - строки.
    val map3 = mutableMapOf<Int, String>()

// 4 . Имея изменяемый словарь, добавьте в него новые пары "ключ-значение".
    map3[1] = "Hello"
    map3[2] = "World"

// 5 . Используя словарь из предыдущего задания, извлеките значение, используя ключ. Попробуй получить значение с ключом,
// которого в словаре нет.
    val firstWord = map3[1]
    val thirdWord = map3[3]
    println("Первое словов ${firstWord} и третье слово $thirdWord")

// 6 . Удалите определенный элемент из изменяемого словаря по его ключу.
    map3.remove(2)

// 7 . Создайте словарь (ключи Double, значения Int) и выведи в цикле результат деления ключа на значение. Не забудь
// обработать деление на 0 (в этом случае выведи слово “бесконечность”)
    val map7 = mutableMapOf<Double, Int>(5.0 to 1, 6.0 to 2, 7.0 to 0)
    for ((key, value) in map7) {
        if ( value == 0) {
            println("бесконечность")
        } else
            println(key/value)
    }

// 8 . Измените значение для существующего ключа в изменяемом словаре.
    map7[5.0] = 8

// 9 . Создайте два словаря и объедините их в третьем изменяемом словаре через циклы.
    val map9 = mapOf<Int, Int>(1 to 2, 2 to 3, 3 to 4, 4 to 5)
    val map99 = mapOf<Int, Int>(6 to 7, 7 to 8, 8 to 9)
    val mutableMap9 = mutableMapOf<Int, Int>()
    for ((key, value) in map9) {
        mutableMap9[key] = value
    }

    for ((key, value) in map99) {
        mutableMap9[key] = value
    }

// 10 . Создайте словарь, где ключами являются строки, а значениями - списки целых чисел. Добавьте несколько элементов в
// этот словарь.
    val mutabbleMap10 = mutableMapOf<String, List<Int>>()
    mutabbleMap10["First"] = listOf<Int>(1,3,4)
    mutabbleMap10["Second"] = listOf<Int>(2,5,6,7)

// 11 . Создай словарь, в котором ключи - это целые числа, а значения - изменяемые множества строк. Добавь данные в словарь.
// Получи значение по ключу (это должно быть множество строк) и добавь в это множество ещё строку. Распечатай полученное множество.
    val mutableMap11 = mutableMapOf<Int, MutableSet<String>>()
    mutableMap11[1] = mutableSetOf( "One, one First, first")
    mutableMap11[2] = mutableSetOf("Two, two Second, second")
    println("Значение по ключу ${mutableMap11[1]}")
    mutableMap11[3] = mutableSetOf("Three, three Third, third")
    for ((key, value) in mutableMap11) {
        println(" $key, $value")
    }

// 12 . Создай словарь, где ключами будут пары чисел. Через перебор найди значение у которого пара будет содержать цифру
// 5 в качестве первого или второго значения.
val map12 = mutableMapOf<Pair<Int, Int>, Int>()
    map12[Pair(1, 2)] = 3
    map12[Pair(2,3)] = 4
    map12[Pair(3,24)] = 5
    map12[Pair(4,5)] = 6
    map12[Pair(5,26)] = 7

    for ((key, value ) in map12) {
        if (key.first == 5 || key.second == 5) {
            println("$key, $value")
        }
    }


//  Задачи на подбор оптимального типа для словаря
// 1 . Словарь библиотека: Ключи - автор книги, значения - список книг
    val authorBooks = mapOf<String, MutableList<String>>()

// 2 . Справочник растений: Ключи - типы растений (например, "Цветы", "Деревья"), значения - списки названий растений
    val plants = mapOf<String, MutableList<String>>()

// 3 . Четвертьфинала: Ключи - названия спортивных команд, значения - списки игроков каждой команды
    val sport = mapOf<String, MutableList<String>>()

// 4 . Курс лечения: Ключи - даты, значения - список препаратов принимаемых в дату
    val treatment = mapOf<Any, MutableList<String>>()

// 5 . Словарь путешественника: Ключи - страны, значения - словари из городов со списком интересных мест.
    val traveller = mapOf<String, Map<String, String>>()
}