package ru.stimmax.ru.stimmax.lessons.lesson17.homework

// Игровой автомат
//Опиши схематически класс игрового автомата, правильно расставив объявление полей (val или var) и методов (аргументы и возвращаемые значения), включая модификаторы доступа (private для приватных)
class SlotMachine(
//Поля:
//цвет
    val color: String,
//модель
    val model: String,
//пин-код автомата
    private val pinCode: Int) {
//включен
    private var isOn = false
//ОС загружена
    private var os = false
//список установленных игр
    private val listGames = mutableListOf<String>("cs", "minecraft")
//наличие джойстика
    val joystick = true
//баланс вырученных средств
    private var moneyBalance = 0
//владелец
    private var owner = ""
//телефон поддержки.
    var phoneNumber = "+79214444444"
    private set
//игровой сеанс оплачен
    private var playPayment = false
//стоимость одного игрового сеанса
    var costPlay = 29
    private set
//Методы:
//включить
fun slotMachineIsOn() {
    if(isOn)
    println("Is On")
    else isOn = true
    downloadOs()
}
//выключить
fun slotMachineIsOff() {
    turnOffOs()
    isOn = false
    println("Is off")
}
//загрузить ОС
fun downloadOs(){
    os = true
    println("Start domnload")
}

//завершить работу ОС
fun turnOffOs() {
    os = false
    println("Turn off")
}
//показать список игр
fun showListPlayGames(listGames: List<String>) {
    this.listGames.forEach { println(it) }
}
//включить игру
fun turnOffGame(game: String) {
    this.listGames.forEach { it ->
        if (game in listGames) {
            if (playPayment) {
                println("Game $game started")
            } else
                println("Session doesn't not pay")
        } else
            println("This game doesn't in list of games")
    }
}
//оплатить игровой сеанс
fun payPlayGame() {
    moneyBalance += costPlay
    println("Payment successful")
}
//забрать наличные с помощью пин-кода
fun getCashWithinPin(pinCode: Int): Int {
    if (pinCode == this.pinCode) {
        return openSeif()
    }
    println("Incorrect pin")
    return 0
}
//открыть сейф и выдать наличные
    private fun openSeif(): Int {
        val currentBalance = moneyBalance
        moneyBalance = 0
        return currentBalance
    }
}