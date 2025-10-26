package ru.stimmax.ru.stimmax.lessons.lesson14.homework

import javax.security.auth.Subject

// 1 . Событие: вечеринка. Создайте класс Party, который описывает вечеринку. У него должны быть свойства location (String)
    // и attendees (Int). Добавьте метод details(), который выводит информацию о месте проведения и количестве гостей.

class Party(val location: String, val attendees: Int) {
    fun details(){
        println("Вечеринка будет проходить в $location, количество гостей - $attendees")
    }
}

    // 2 . Аспект реальности: эмоция. Создайте класс Emotion, который представляет эмоцию. У него должно быть свойство type
    // (String) и intensity (Int). Добавьте метод express(), который выводит описание эмоции в зависимости от её типа и интенсивности.

class Emotion(val type: String, val intensity: Int){
    fun express() {
        println("$type -> $intensity")
    }
}

    // 3 . Природное явление: луна. Создайте объект Moon, который будет представлять Луну. Добавьте свойства isVisible (Boolean),
    // чтобы отображать, видна ли Луна в данный момент, и phase (String), чтобы отображать текущую фазу Луны (например, "Full Moon",
    // "New Moon"). Добавьте метод showPhase(), который выводит текущую фазу Луны.

object Moon{
    fun showPhase(isVisible: Boolean, phase: String){
        val state = if (isVisible) "видна" else "не видна"
        println("$phase -> $state")
    }
}

    // 4 . Покупка: продукт. Создайте дата класс для продукта, который будет представлять продукт в магазине. У него должны
    // быть свойства “название”, “цена”, “количество”.

data class Product(val name: String, val price: Int, var quality: Int)

    // 5 . Мероприятие: концерт. Создайте класс, который будет представлять концерт. У него должны быть свойства “группа”,
    // “место проведения”, “стоимость”, “вместимость зала”. Также приватное поле “проданные билеты”. Добавьте метод,
    // который выводит информацию о концерте и метод “купить билет”, который увеличивает количество проданных билетов на один.

class Concert(val group: String, val location: String, val cost: Int, val place: Int, private var tickets: Int) {
    fun concertInfo(){
        println("Информация о концерте: выступаяющая группа - $group, место проведения - $location, стоимость билетов - $cost, вместимость заала - $place")
    }
    fun buyTicket(){
        if (tickets < place) {
            println("купить билет")
            tickets++
        }
    }
}


    fun main() {
        val party = Party("restaurant", 24)
        party.details()

        val emotion = Emotion("Smile", 10)
        emotion.express()

        Moon.showPhase(true, "New Moon")

        Product("apple", 23, 25)

        val concert = Concert("bi2", "scene", 245, 250, 45)
        concert.concertInfo()
        concert.buyTicket()

        val shelf = Shelf(23)
        println(shelf.addItem("red"))
        shelf.getItems()
        println(shelf.removeItem("ref"))
        shelf.getItems()
        println(shelf.canAccommodate("red"))
        println(shelf.containsItem("rev"))

        val rack = Rack(23)
        println(rack.addShelf(shelf))
        println(rack.removeShelf(3))
        println(rack.addItem("hj"))
        println(rack.removeItem("kl"))
        println(rack.containsItem("hj"))
        println(rack.getShelves())
        println(rack.printContents())
        println(rack.advancedRemoveShelf(3))


}