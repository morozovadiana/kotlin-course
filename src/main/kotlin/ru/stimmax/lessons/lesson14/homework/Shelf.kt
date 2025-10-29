package ru.stimmax.ru.stimmax.lessons.lesson14.homework

import kotlin.compareTo

//Задание 6. Стеллаж и полки.
//Цель задания: Создать систему управления складским пространством с использованием классов "Стеллаж" и "Полка стеллажа".
//Класс Shelf (Полка Стеллажа)
//Характеристики:
//Вместимость полки (capacity): максимальная сумма букв всех названий предметов, которые могут быть размещены на полке.
//Список предметов (items): хранит названия предметов на полке.


data class Shelf(val capacity: Int) {
    private val items = mutableListOf<String>("rev", "ref")
    //Методы:
    //Добавление Предмета (addItem):
    //Принимает название предмета.
    fun addItem(name: String): Boolean {
        //Проверяет, поместится ли предмет на полку, учитывая длину его названия и текущее заполнение полки.
        //Возвращает true и добавляет предмет, если есть место. В противном случае возвращает false.
        if (canAccommodate(name)) {
            items.add(name)
            return true
        } else return false
    }


    //Удаление Предмета (removeItem):
    //Принимает название предмета.
    fun removeItem(name: String): Boolean {
        //Удаляет предмет, если он найден на полке.
        //Возвращает true, если предмет был удален, и false, если такой предмет не найден.
        if (items.contains(name)) {
            items.remove(name)
            return true
        } else return false
    }

    //Проверка Вместимости (canAccommodate):
    //Принимает название предмета.
    fun canAccommodate(name: String): Boolean {
        //Определяет, вместится ли предмет на полку.
        //Возвращает true, если предмет вместится, и false, если места недостаточно.
        val space = items.sumOf { it.length }
        return space + name.length < capacity
    }

    //Проверка наличия предмета (containsItem):
    //Принимает название предмета
    fun containsItem(name: String): Boolean {
        //Возвращает true если такой предмет есть
        return items.contains(name)
    }

    //Получение списка предметов (getItems):
    fun getItems() = items.toList()
}

fun main() {
    val shelf = Shelf(23)
    println(shelf.addItem("red"))
    shelf.getItems()
    println(shelf.removeItem("ref"))
    shelf.getItems()
    println(shelf.canAccommodate("red"))
    println(shelf.containsItem("rev"))

}