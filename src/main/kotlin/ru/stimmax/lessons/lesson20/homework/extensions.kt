package ru.stimmax.ru.stimmax.lessons.lesson20.homework
import kotlin.math.absoluteValue

// 1 . Определите функцию-расширение для массива чисел, которая не принимает аргументов и возвращает пару из чисел -
// первое и последнее. Если массив был пуст то вернуть пару из null значений.

fun Array<Int?>.extension(): Pair<Int?, Int?>{
        if (this.isEmpty()){
            return null to null
    }
    return this[0] to this[-1]
}
// 2 . Создайте функцию-расширение для изменяемого списка элементов:
// 1 . с дженериком T ограниченным интерфейсом Comparable<T>
// 2 . которая принимает булево значение
// 3 . возвращает этот же список только в виде неизменяемого
// 4 . сам изменяемый список при этом должен стать отсортированным по возрастанию, если в функцию передано true и по
// убыванию, если false (используем функции sort() и sortDescending()
fun <T : Comparable<T>> MutableList<T>.sorting(arg: Boolean): List<T> {
    if(arg){
        sort()
    } else
        sortDescending()
    return toList()
}
// 3 . Создайте функцию-расширение для nullable словаря с дженериком:
// 1 . Ключ является дженериком
// 2 . Значение является списком из дженериков
// 3 . Принимает целое число
// 4 . Возвращает nullable словарь из ключей изначального словаря приведённых к строке через toString()
// 5 . Значений из nullable дженерика, взятых из изначального ключа-списка по индексу из аргумента, если такого индекса нет
// - значением будет null
fun <T> Map<T, List<T>>?.nullableFunction(arg: Int): Map<String, T?>{
    val newKeys = this?.mapKeys {  it.key.toString()}
    val newValues = this?.mapValues { it.value.getOrNull(arg) }
    val newMap = mutableMapOf<String,T>()
    if (newKeys != null && newValues != null) {
        for (k in newKeys){
            for (v in newValues)
            newMap[k.toString()]= v as T
        }
    }
    return newMap.toMap()
}

//fun <R> Map<R, List<R>>?.mapByIndex(index: Int): Map<String, R?>? {
//    return this?.mapKeys { it.key.toString() }
//        ?.mapValues { it.value.getOrNull(index) }
//}

// 4 . Реализуйте метод расширения within для класса Number, который проверяет, что текущее число отклоняется от эталонного
// не более допустимого значения. Метод принимает два параметра: other — число для сравнения и deviation — максимально
// допустимое отклонение. Метод должен возвращать true, если разница между текущим числом и числом для сравнения не превышает
// заданное отклонение. Протестируйте функцию на разных типах чисел. Для получения отклонения, у разницы чисел нужно вызвать
// свойство absoluteValue.

    fun Number.within(other: Number, deviation: Number ): Boolean {
        if( (toDouble() - other.toDouble()).absoluteValue <= deviation.toDouble()){
            return true
        } else return false
    }

// 5 . Реализуйте для класса String два метода расширения: encrypt и decrypt. Метод encrypt должен сдвигать каждый символ
// исходной строки на заданное число позиций вперед по таблице Unicode, а метод decrypt — на то же число позиций назад.
// Оба метода принимают один параметр base типа Int, который определяет величину сдвига. Протестируйте вашу реализацию,
// убедившись, что после шифрования и последующей расшифровки строка возвращается к исходному состоянию.
// Сдвиг по таблице Unicode реализуется простым прибавлением или вычитанием размера сдвига к char символу.

fun String.encrypt(base: Int): String{
    return forEach { it + base }.toString()
}

fun String.decrypt(base: Int): String{
    return forEach { it - base }.toString()
}

// 6 . Многие уже знают любимую игру в Твиттере - собирание разных слов из букв через ответы (но мы то знаем что слово
// только одно, но не будем его называть). Напиши метод расширения строки, который будет принимать список имён пользователей
// и выводить в консоли исходную строку побуквенно в верхнем регистре в столбик: имя автора и букву под ним. Вот ссылка на референс:
//https://x.com/SadNSober_/status/1370280031616897026
//Если ссылка не открывается по понятным причинам, вот скриншот

fun String.twitterGame(name: List<String>){
    var counter = 0
    for( i in this){
        println(name[counter++])
        println(i.uppercase())

    }
}
