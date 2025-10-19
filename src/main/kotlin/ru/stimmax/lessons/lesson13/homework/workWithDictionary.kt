package ru.stimmax.ru.stimmax.lessons.lesson13.homework

fun main() {
    // Для решения каждой задачи постарайтесь использовать наиболее подходящий метод, не повторяясь с решением других задач.

    // 1 . Дан словарь с именем и временем выполнения каждого автоматизированного теста в секундах. Определите среднее
    // время выполнения теста.
    val dict1 = mapOf<String, Int>("test1" to 21, "test2" to 23, "test3" to 45)
    val result = dict1.values
    println(result.average())

    // 2 . Имеется словарь с метаданными автоматизированных тестов, где ключи — это имена тестовых методов а значения - строка
    // с метаданными. Выведите список всех тестовых методов.
    val dict2 = mapOf<String, String>("test1" to "data1", "test2" to "data2", "test3" to "data3")
    println(dict2.keys)

    // 3 . В изменяемый словарь с данными о прохождении тестов добавьте новый тест и его результат.
    val dict3 = mutableMapOf<String, Int>("test1" to 21, "test2" to 23, "test3" to 45)
    dict3["test4"] = 65

    // 4 . Посчитайте количество успешных тестов в словаре с результатами (ключ - название, значение - результат из
    // passed, failed, skipped).
    val dict4 = mapOf<String, String>("test1" to "passed", "test2" to "failed", "test3" to "skipped", "test4" to "passed", "test5" to "skipped")
    println(dict4.count({ it.value == "passed" }))

    // 5 . Удалите из изменяемого словаря с баг-трекингом запись о баге, который был исправлен (ключ - название, значение
    // - статус исправления).
    val dict5 = mutableMapOf<String, String>("bug1" to "passed", "bug2" to "failed", "bug3" to "skipped", "bug4" to "passed", "bug5" to "skipped")
    dict5.values.remove("passed")

    // 6 . Для словаря с результатами тестирования веб-страниц (ключ — URL страницы, значение — статус ответа), выведите
    // сообщение о странице и статусе её проверки.
    val dict6 = mapOf("https://url1" to "200", "https://url2" to "400", "https://url3" to "500")
    dict6.forEach { (key, values) -> println("$key -> $values") }

    // 7 . Найдите в словаре с названием и временем ответа сервисов только те, время ответа которых превышает заданный порог.
    val dict7 = mapOf<String, Int>("name1" to 21, "name2" to 22, "name3" to 37)
    val timeToResponse = 30
    dict7.forEach {if (it.value > timeToResponse) println("${it.key} -> ${it.value}")}

    // 8 . В словаре хранятся результаты тестирования API (ключ — endpoint, значение — статус ответа в виде строки).
    // Для указанного endpoint найдите статус ответа, если endpoint отсутствует, предположите, что он не был протестирован.
    val dict8 = mapOf<String, String>("endpoint1" to "200", "endpoint2" to "100", "endpoint3" to "404")
    val endpoint = "endpoint4"
    dict8.forEach { if(it.value == endpoint) println("${it.key} -> ${it.value}") else println("not testing")}

    // 9 . Из словаря, содержащего конфигурации тестового окружения (ключ — название параметра конфигурации, значение -
    // сама конфигурация), получите значение для "browserType". Ответ не может быть null.
    val dict9 = mapOf<String, String>("name1" to "conf1", "browserType" to "conf2")
    val res = dict9
        .filterKeys {it.contains("browserType")}
    println(res)

    // 10 . Создайте копию неизменяемого словаря с данными о версиях тестируемого ПО, добавив новую версию.
    val dict10 = mapOf<String, String>()
    dict10 + ("PO" to "version")

    // 11 . Используя словарь с настройками тестирования для различных мобильных устройств (ключ — модель устройства,
    // значение - строка с настройками), получите настройки для конкретной модели или верните настройки по умолчанию.
    val dict11 = mapOf<String, String>("android" to "settings1", "iphone" to "settings2", "desktop" to "settings3")
    println(dict11.getOrDefault(
        "android",
        defaultValue = "default"
    ))

    // 12 . Проверьте, содержит ли словарь с ошибками тестирования (ключ - код ошибки, значение - описание ошибки) 
    // определенный код ошибки.
    val dict12 = mapOf<Int, String>(200 to "Success", 100 to "informative", 400 to "bad request", 404 to "not found")
    val code = 500
    println(dict12.contains(code))
    
    // 13 . Дан неизменяемый словарь, где ключи — это идентификаторы тестовых сценариев в формате "TestID_Version",
    // а значения — статусы выполнения этих тестов ("Passed", "Failed", "Skipped"). Отфильтруйте словарь, оставив только
    // те сценарии, идентификаторы которых соответствуют определённой версии тестов, то-есть в ключе содержится требуемая версия.
    val dict13 = mapOf<String, String>("TestID_Version1" to "Passed","TestID_Version2" to "Failed", "TestID_Version3" to "Skipped")
    val version = "Passed"
    println(dict13.filterValues { it.contains(version) })

    // 14 . У вас есть словарь, где ключи — это названия функциональных модулей приложения, а значения — результаты их
    // тестирования. Проверьте, есть ли модули с неудачным тестированием.
    val dict14 = mapOf<String, String>("name1" to "success", "name2" to "success", "name3" to "failed")
    val failResult = "failed"
    println(dict14.filterValues { it.contains(failResult) })

    // 15 .  Добавьте в изменяемый словарь с настройками тестовой среды настройки из другого словаря.
    val dict15 = mapOf<String, String>("name1" to "test environment1", "name2" to "test environment2")
    val newDict15 = mutableMapOf<String, String>("name3" to "test environment3")
        newDict15.putAll(dict15)

    // 16 . Объедините два неизменяемых словаря с данными о багах.
    val dict16bug1 = mutableMapOf<String, String>()
    val dict16bug2 = mutableMapOf<String, String>()
    dict16bug2.putAll(dict16bug1)

    // 17 . Очистите изменяемый словарь с временными данными о последнем прогоне автоматизированных тестов.
    val dict17 = mutableMapOf<String, String>()
    dict17.clear()

    // 18 . Исключите из отчета по автоматизированному тестированию те случаи, где тесты были пропущены (имеют статус “skipped”).
    // Ключи - название теста, значения - статус.
    val dict18 = mutableMapOf<String, String>("name1" to "Passed","name2" to "Failed", "name3" to "Skipped")
    println(dict18.filterNot { it.value == "Skipped" })

    // 19 . Создайте копию словаря с конфигурациями тестирования удалив из него несколько конфигураций.
    val dict19 = mutableMapOf<String, String>("name1" to "conf1", "name2" to "conf2", "name3" to "conf3", "name4" to "conf4")
    val newDict19 = dict19 - "name3"

    // 20 . Создайте отчет о тестировании, преобразовав словарь с результатами тестирования (ключ — идентификатор теста,
    // значение — результат) в список строк формата "Test ID: результат".
    val dict20 = mapOf<String, String>("ID1" to "result1", "ID2" to "result2", "ID3" to "result3")
    for (entry in dict20.entries) {
        println("${entry.key}: ${entry.value}")
    }

    // 21 . Преобразуйте изменяемый словарь с результатами последнего тестирования в неизменяемый для архивации.
    val dict21 = mutableMapOf<String, String>()
    val newDict21 = dict21.toMap()

    // 22 . Преобразуйте словарь, содержащий числовой ID теста и данные о времени выполнения тестов, заменив идентификаторы
    // тестов на их строковый аналог (например через toString()).
    val dict22 = mutableMapOf<Int, String>(1 to "data1", 2 to "data2", 3 to "data3")
    dict22.keys.toString()

    // 23 . Для словаря с оценками производительности различных версий приложения (ключи - строковая версия, значения -
    // дробное число времени ответа сервера) увеличьте каждую оценку на 10%, чтобы учесть новые условия тестирования.
    val dict23 = mutableMapOf<String, Double>("name1" to 1.23)
    dict23.mapValues { it.value * 0.1 }

    // 24 . Проверьте, пуст ли словарь с ошибками компиляции тестов.
    val dict24 = mapOf<String, String>()
    dict24.isEmpty()

    // 25 . Убедитесь, что словарь с результатами нагрузочного тестирования не пуст.
    val dict25 = mapOf<String, String>()
    dict25.isNotEmpty()

    // 26 . Проверьте, прошли ли успешно все автоматизированные тесты в словаре с результатами.
    val dict26 = mutableMapOf<String, String>("name1" to "Passed","name2" to "Failed", "name3" to "Skipped")
    dict26.all { it.value == "Passed" }

    // 27 . Определите, содержит ли словарь с результатами тестирования хотя бы один тест с ошибкой.
    dict26.any{it.value == "Failed"}

    // 28 . Отфильтруйте словарь с результатами тестирования сервисов, оставив только те тесты, которые не прошли успешно
    // и содержат в названии “optional”.
    val dict28 = mutableMapOf<String, String>("name1" to "Passed","name2" to "Failed", "name3" to "Skipped", "name4" to "Optional")
    dict28.filter { it.value =="Optional" && it.value != "Passed" }
}