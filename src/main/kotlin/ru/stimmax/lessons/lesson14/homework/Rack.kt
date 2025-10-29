package ru.stimmax.ru.stimmax.lessons.lesson14.homework

//Класс Rack (Стеллаж)
//Характеристики:
//Список полок (shelves): хранит полки стеллажа.
//Максимальное количество полок.
class Rack(val maxShelvesCount: Int) {
    private val shelves =  mutableListOf<Shelf>()
    //Методы:
    //Добавление Полки (addShelf):
    //Добавляет новую полку в стеллаж.
    //Возвращает true, если полка была успешно добавлена или false если стеллаж уже заполнен или была попытка добавить
    // полку которая уже установлена.
    fun addShelf(newShelf: Shelf): Boolean {
        if (shelves.contains(newShelf) && shelves.size >= maxShelvesCount)
            return false
        shelves.add(newShelf)
        return true
    }

    //Удаление Полки (removeShelf):
    //Принимает индекс полки для удаления.
    //Удаляет полку по указанному индексу.
    //Возвращает список предметов полки, если полка была успешно удалена или пустой список если полка не существует.
    fun removeShelf(indexShelf: Int): List<String> {
        if (indexShelf in shelves.indices) {
            val otherItems = shelves[indexShelf].getItems()
            shelves.removeAt(indexShelf)
            return otherItems
        }
        return emptyList()
    }

    //Добавление Предмета (addItem):
    //Добавляет предмет на первую свободную полку.
    //Возвращает true, если предмет успешно добавлен, и false, если на всех полках недостаточно места.
    fun addItem(name: String): Boolean {
        for (shelf in shelves) {
            if (shelf.canAccommodate(name))
                shelf.addItem(name)
                return true
        }
        return false
    }

    //Удаление Предмета (removeItem):
    //Находит и удаляет только один предмет с любой полки.
    //Возвращает true, если предмет был удален, и false, если такой предмет не найден.
    fun removeItem(name: String): Boolean {
        for (shelf in shelves) {
            if (shelf.containsItem(name)) {
                shelf.removeItem(name)
                return true
            }
        }
        return false
    }

    //Проверка наличия предмета на стеллаже (containsItem):
    //Возвращает true если предмет есть на одной из полок
    fun containsItem(name: String): Boolean {
        return shelves.any { it.containsItem(name) }
    }

    //Получение списка полок (getShelves):
    //Возвращает неизменяемый список полок
    fun getShelves(): List<Shelf> {
        return shelves.toList()
    }

    //Печать Содержимого (printContents):
    //Выводит в консоль информацию о каждой полке: индекс, вместимость, оставшуюся вместимость, список предметов.
    // Информацию выводить в наглядном читаемом виде
    fun printContents() {
        shelves.forEachIndexed { i, shelf ->
            val index = i
            val capacity = shelf.capacity
            val usedSpace = shelf.getItems().sumOf { it.length }
            val otherCapacity = capacity - usedSpace
            val listNames = shelf.getItems()

            println("индекс - $index, " +
                    "вместимость - $capacity, " +
                    "оставшаяся вместимость - $otherCapacity, " +
                    "список предметов - $listNames")
        }
    }

    //Сложное удаление полки (advancedRemoveShelf):
    //Принимает индекс полки для удаления
    //Перераспределяет предметы по имеющимся полкам, начиная с самых длинных. Если очередной предмет никуда не вмещается,
    // его нужно пропустить и попробовать разместить следующий.
    //Удаляет полку с оставшимися предметами
    //Возвращает неизменяемый список предметов, которые не удалось удалить или пустой список если полки с таким индексом нет.
    fun advancedRemoveShelf(indexShelf: Int): List<String> {
        if (indexShelf !in shelves.indices) {
            return emptyList()
        }
        val notReplacedItems = mutableListOf<String>()
        for (item in shelves[indexShelf].getItems()) {
            if (shelves.none { it.addItem(item) }) {
                notReplacedItems.add(item)
            }
        }
        shelves.removeAt(indexShelf)
        return notReplacedItems.toList()
    }
}

fun main() {
    val rack = Rack(23)
    //println(rack.addShelf())
    println(rack.removeShelf(3))
    println(rack.addItem("hj"))
    println(rack.removeItem("kl"))
    println(rack.containsItem("hj"))
    println(rack.getShelves())
    println(rack.printContents())
    println(rack.advancedRemoveShelf(3))
}