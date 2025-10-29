package ru.stimmax.ru.stimmax.lessons.lesson15.homework

import kotlin.collections.forEach
import kotlin.math.max


//Создай подклассы этого контейнера, которые будут добавлять строку material (или коллекции или словари строк) в какое-то
// определённое место (места).

abstract class Materials {
    private val materials = mutableListOf<String>()
    fun addMaterial(material: String) {
        materials.add(material)
    }
    fun extractMaterials(): List<String> {
        val extracted = materials.toList()
        materials.clear()
        return extracted
    }
    fun printContainer() {
        materials.forEachIndexed { index, layer ->
            println("[$index]: $layer")
        }
    }
}

//Первый класс должен вставлять строку на дно контейнера (должно появиться под индексом 0)

class FirstClassMaterial: Materials(){
    fun inputString(material: String) {
        val getMaterial = extractMaterials()
        addMaterial((material))
        getMaterial.forEach { addMaterial(it )
        }
    }
}

//Второй класс должен получать список строк и вставлять их в начало контейнера но поочерёдно с теми данными, которые уже есть.
// То-есть, наш список должен появиться в контейнере по индексам 0, 2, 4 и так далее.

class SecondClassMaterials: Materials(){
    fun inputSequences(material: List<String>){
        val getMaterial = extractMaterials()
        val maxMeaning = max(getMaterial.size, material.size)
        for (i in 0..maxMeaning) {
            if (i < material.size){
                addMaterial(material[i])

            if (i < getMaterial.size)
                addMaterial(material[i])
            }
        }
    }
}

//Третий класс при добавлении строки должен отсортировать весь список метиралов в алфавитном порядке включая добавляемый материал.

class ThirdClassMaterials: Materials(){
    fun sortedMaterial(material: String) {
        val string = (extractMaterials() + material).sorted()
        string.forEach { addMaterial(it) }
    }
}

//Четвёртый класс должен принимать словарь (ключи и значения строки). Каждая пара ключа и значения должна попадать в
// контейнер следующим образом - ключ в начало, значение в конец. Таким образом в начале должны быть ключи в обратном порядке,
// потом существующие материалы, потом все значения.

class FourClassMaterial: Materials(){
    fun makeMap(map: Map<String, String>){
         map.keys.reversed().forEach { addMaterial(it)}
        extractMaterials().forEach { addMaterial(it)}
        map.values.forEach { addMaterial(it)}
        }
}
