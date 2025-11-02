package ru.stimmax.ru.stimmax.lessons.lesson16.homework.overloading

import kotlin.collections.component1
import kotlin.collections.component2

// Перегрузка методов

// 4 . Класс “Корзина товаров”: содержит поле словаря из ID товаров и их количества.
class Bag (
    val map: MutableMap<String, Int>
) {

    // 1 . Базовый метод addToCart(itemId) добавляет одну единицу товара к уже существующим в корзине.
    fun addToCart(itemId: String) {
        map.getOrDefault(itemId, 0) + 1


    }
// 2 . Выполнить перегрузку addToCart который:
// 1 . Принимает два аргумента (itemId и количество amount)
    fun addToCart(itemId: String, amount: Int) {
        map.getOrDefault(itemId, 0) + amount

}
// 2 . Принимает словарь из id и количества и добавляет всё в корзину
    fun addToCart(map1: Map<String, Int>){
       map1.forEach { (k, v) ->
           addToCart(k,v)
        }
    }
// 3 . Принимает список из id (добавляет по одной единице).
    fun addToCart(id: List<String>) {
       id.forEach { it->
            addToCart(it)
       }
    }
// 3 . Учесть, что если товар уже есть в корзине, нужно увеличить его количество, если нет - добавить.
}


fun main() {
    //4 . Попробуй создать корзину и положить в неё товар разными способами, потом распечатать корзину в консоль.
    val goods = mutableMapOf("apple" to 1, "peer" to 2)
    val bag = Bag(goods)
    bag.addToCart("apple")
    bag.addToCart("lemon")
    bag.addToCart("pineapple", 2)
    bag.addToCart("pineapple", 2)
    val goods1 = mapOf("bread" to 3)
    bag.addToCart(goods1)
    val listGoods = listOf("water", "sweet")
    bag.addToCart(listGoods)
    // 5 . Переопредели у корзины метод toString для красивого форматирования содержимого таблицы, включая итоговое количество
// артикулов и общее количество всего товара в корзине.
    goods.forEach { (k, v) ->
        println("Артикул $k -- Количество $v")
    }

}