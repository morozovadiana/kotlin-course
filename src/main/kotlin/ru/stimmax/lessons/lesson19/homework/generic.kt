package ru.stimmax.ru.stimmax.lessons.lesson19.homework

// Требуется описать класс, интерфейс или функцию и реализовать предложенную логику в коде.

    // 1 . Напиши функцию getMiddleElement с дженериком, которая будет принимать список и возвращать средний элемент, если он
// существует, иначе возвращать null. Например, у списка из четырёх элементов - среднего элемента нет.
    fun <T> getMiddleElement(arg: List<T>): T? {
        val middleIndex = arg.size / 2
        if (middleIndex == 0)
                return null
        return arg[middleIndex]
    }

// 2 . Напиши класс ListHolder, который будет хранить список элементов типа T и иметь метод для добавления нового элемента и
// получения всех элементов в виде неизменяемого списка.

class ListHolder <T: List<T>> {
    private val list = mutableListOf<T>()

    fun addNewElement(arg: T){
         list.add(arg)
    }
    fun getAllElements(): List<T> {
        return list.toList()
    }
}

// 3 . Создай интерфейс Mapper с двумя дженериками, который будет определять методы для преобразования:
interface Mapper <T,K> {

// 1 . элементов одного типа в элементы другого типа
    fun oneToAnother(arg: T): K
// 2 . списка элементов одного типа в список элементов другого типа
    fun anotherToOne(arg: List<T>): List<K>
}
// 4 . Создай класс PhrasesToListOfStrings и имплементируй интефрейс Mapper с типами String и List<String>. Метод преобразования
// должен разбивать входящую строку по символу пробела и возвращать список из полученных слов. Метод преобразования списков
// с аналогичной механикой.
class PhrasesToListOfStrings <T: List<T>>: Mapper<String, List<String>>{

    override fun oneToAnother(arg: String): List<String> {
        return arg.split(" ")
    }

    override fun anotherToOne(arg: List<String>): List<List<String>> {
    return arg.map { it.split(" ") }
    }
}

// 5 . Создай функцию transposition с двумя дженериками, которая принимает словарь с дженериками и возвращает словарь,
// в котором ключ и значения поменялись местами.
fun <T, K> transposition(arg: Map<T, K>): Map<K, T> {
    val newMap = mutableMapOf<K,T>()
    for ((k, v) in arg){
        newMap[v]= k
    }
    return newMap
    // arg.map { it }.associate { it.value to it.key }
}

// 6 . Напиши интерфейс Validator с дженериком с функцией валидации, которая будет принимать элемент с типом дженерика и
// возвращать булево значение.
interface Validator <T> {
    fun validate(arg: T): Boolean
}

// 7 . Создай класс StringValidator и имплементируй интерфейс Validator с типом String?. Реализуй проверку, что строка
// не является null, не пустая и не состоит из одних пробелов.
class StringValidator : Validator<String?>{
    override fun validate(arg: String?): Boolean {
        if (arg != null && arg != "" && !arg.contains(" "))
            return true
        return false
        // element?.isNotBlank() ?: false
    }
}
// 8 . Создай класс OddValidator и имплементируй интерфейс Validator типизированный по Int. Реализуй проверку, что число чётное.
class OddValidator : Validator<Int> {
    override fun validate(arg: Int): Boolean {
        return (arg % 2 == 0)
    }
}
// 9 . Создай класс ListValidator с дженериком, ограниченным типом Number, имплементируй интерфейс Validator типизированный
// по типу List с nullable типом дженерика класса
class ListValidator <T: Number>: Validator<List<T?>> {
    // 1 . Реализуй проверку:
    // 1 . Ни один элемент списка не является null
    // 2 . Ни один элемент приведённый к типу Double не равен 0.0
    override fun validate(arg: List<T?>): Boolean {
        arg.forEach { it ->
            if (it != null && it.toDouble() != 0.0) return true
        }
        return false
    }
}