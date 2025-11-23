package ru.stimmax.ru.stimmax.lessons.lesson22.homework

 //Задание 10. Напиши функцию, которая принимает nullable аргумент типа Any и в блоке try/catch выполни набор действий с
// этим аргументом которые могут потенциально вызвать одно из исключений в этом же порядке:
//NullPointerException
//IndexOutOfBoundsException
//ClassCastException
//IllegalArgumentException
//NumberFormatException
//IllegalStateException
//В блоке catch перехватывай исключение с общим типом Throwable а внутри через when определи тип исключения и выведи
// сообщение с названием исключения. Сразу после when выброси перехваченное исключение через throw, чтобы прекратить работу
// программы. Если аргумент функции не вызвал исключение, то выведи текст, сообщающий что переданный аргумент фантастически хорош!
fun tryException(arg: Any?) {
    try {
        arg as String
        arg!!.length
        arg.toList()
        arg[20000]
    } catch (e: Throwable) {
        when (e) {
            is NullPointerException -> println("NullPointerException")
            is IndexOutOfBoundsException  -> println("IndexOutOfBoundsException")
            is ClassCastException  -> println("ClassCastException")
            is IllegalArgumentException  -> println("IllegalArgumentException")
            is NumberFormatException  -> println("NumberFormatException")
            is IllegalStateException -> println("IllegalStateException")
        }
    }
}
