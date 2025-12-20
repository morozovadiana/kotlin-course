package ru.stimmax.ru.stimmax.lessons.lesson29.homework

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File
import kotlin.jvm.java

// Задание 1
//
//Создай дата класс сотрудника компании Employee, содержащий:

data class Employee(
//имя
    val name: String,
//статус трудоустройства (булево)
    val status: Boolean,
//дата рождения (строка)
    val birthdate: String,
//должность CharacterTypes
    val jobTitile: CharacterTypes,
//список подчинённых с типом Employee
    val listCollegues: List<Employee>,
)


enum class CharacterTypes {
    CTO,
    UX_UI,
    CRM, // Customer Relationship Manager
    FRONTEND_DEV,
    TEAM_LEAD,
    BACKEND_DEV,
    PM,
    SYSADMIN,
    QA
}

//Задание 2

//Создай объекты рабочей группы так, чтобы у CTO был PM и CRM, у PM было два тим-лида (на фронт и бэк) и у каждого было
// по группе сотрудников подходящего для его стека профиля.

val people = Employee(
    name = "Vanya",
    status = true,
    birthdate = "1993-02-23",
    jobTitile = CharacterTypes.CTO,
    listCollegues = listOf(
        Employee(
            name = "Sveta",
            status = true,
            birthdate = "1995-2-2",
            jobTitile = CharacterTypes.PM,
            listCollegues = listOf(
                Employee(
                    name = "Misha",
                    status = true,
                    birthdate = "1993-2-4",
                    jobTitile = CharacterTypes.TEAM_LEAD,
                    listCollegues = listOf(
                        Employee(
                            name = "Misha",
                            status = true,
                            birthdate = "1987-6-5",
                            jobTitile = CharacterTypes.BACKEND_DEV,
                            listCollegues = listOf()
                        )
                    )
                ),
                Employee(
                    name = "Anton",
                    status = true,
                    birthdate = "1993-2-5",
                    jobTitile = CharacterTypes.TEAM_LEAD,
                    listCollegues = listOf(
                        Employee(
                            name = "Vitya",
                            status = true,
                            birthdate = "1978-8-7",
                            jobTitile = CharacterTypes.FRONTEND_DEV,
                            listCollegues = listOf()
                        )
                    )
                )
            )
        ),
        Employee(
            "Nastya",
            true,
            "1976-4-5", CharacterTypes.CRM,
            listCollegues = listOf()
        )
    ),
)


//Задание 3

//Создай функцию в которой:
fun writeToFile() {
//сериализуй CTO в текст с настройкой prettyPrinting
    val gson = GsonBuilder()
        .setPrettyPrinting()
        .create()
//текст запиши в файл в корне проекта.
    with(File("filename.json")) {
        parentFile?.mkdirs()
        createNewFile()
        writeText(gson.toJson(people))
    }
}

//Задание 4
//Создай функцию в которой:
fun deserealization() {
//прочитай текст из файла
    val file = File("filename.json").readText()
//десериализуй его в объект класса Employee
    val gson = Gson()
    val result = gson.fromJson(file, Employee::class.java)
//распечатай в консоль
    println("User: $result")
}


//Задание 5

//Для любителей алгоритмов. Не обязательное для выполнения.
//Прочитай текст из файла и десериализуй в объект класса Employee.
//Сгруппируй всех сотрудников по их должности.
fun main() {
    ex5(people).groupBy { it.jobTitile }
        .map { group -> "${group.key}: ${group.value.joinToString { it.name }}" }
        .forEach { println(it) }
}
//Выведи в консоль в виде секций: должность и имена сотрудников через запятую.
//Получение всех сотрудников выполняется через рекурсивную функцию, которая принимает объект Employee а возвращает список
    // всех Employee без вложений.
fun ex5(arg: Employee): List<Employee> {
    return if (arg.listCollegues.isNotEmpty()) {
        arg.listCollegues
            .flatMap {
                ex5(it)
            } + arg.copy(listCollegues = emptyList())
    } else {
        listOf(arg)
    }
}