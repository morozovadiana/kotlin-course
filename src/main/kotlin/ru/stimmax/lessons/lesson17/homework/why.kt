package ru.stimmax.ru.stimmax.lessons.lesson17.homework

// Нужно скопировать код к себе и постараться ответить на все “почему” в комментариях и заданным образом доработать класс
// ChildrenClass (BaseClass доработке не подлежит)

abstract class BaseClass(
    // 1. объясни, почему это поле доступно в main() для чтения из класса ChildrenClass -> нет доступа к данному классу, доступ идет к Child,
    //а там публичное значение
    private val privateVal: String,
    // 2. объясни, почему это поле недоступно в main() -> protected доступен только в классах и наследниках
    protected val protectedVal: String,
    val publicVal: String
) {
    var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "4. Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }
    protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"
    private var privateField = "6. добавь сеттер чтобы изменить меня из main()" //нельзя private менять в дочернем классе
    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
            "generate" to generate(),
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }
    fun printText() {
        privatePrint()
    }
    // 7. объясни, почему эта функция не может быть публичной - потому что она защищена и доступна только в родительском и дочернем классах
    protected open fun getProtectedClass() = ProtectedClass()
    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }
    // 8. Распечатай getAll() и объясни, почему в поле "generate" другой текст - потому что вызываем не родительский, а дочерний класс с переопределенным методом
    open fun generate(): String {
        return "Это генерация из родительского класса"
    }
    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }
    // 9. объясни, почему эта функция не может быть публичной или protected - потому что private только в родительском доступен
    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass() {}

    private class PrivateClass() {}
}
class ChildrenClass(
    val privateVal: String,
    protectedVal: String,
    // 10. объясни, почему этот аргумент доступен в main() несмотря на то, что это не поле - это аргумент конструктора не являющийся полем
    publicVal: String
) : BaseClass(privateVal, protectedVal, privateVal) {
    // 11. объясни, почему в main() доступна функция getAll() хотя её здесь нет - потому что дочерний класс наследует все от родительского
    // 12. проверь, что выводится на печать при вызове функции printText()
    // и объясни, почему не происходит переопределение метода privatePrint() - обе ф-ции private и не имеют переопределения т .к они не наследуются
    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }

    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }

    override open fun verifyPublicField(value: String): Boolean {
        return value.length < 50
    }

    //fun setProtectedField(meaning: String){
     //   protectedField = meaning
   // }
}

fun main() {
    val childrenClass = ChildrenClass(
        privateVal = "hjhjhj",
        protectedVal = "uiuiuiu",
        publicVal = "Антонио Бандераса"
    )
    childrenClass.publicField = "Антонио Бандераса"
    print(childrenClass.getAll())

}