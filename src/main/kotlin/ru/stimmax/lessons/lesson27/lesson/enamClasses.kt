package ru.stimmax.ru.stimmax.lessons.lesson27.lesson
enum class Seasons (val firstMonthNumber: Int, val isVariableDuration: Boolean) {
    WINTER(12, true),
    SPRING(3, false),
    SUMMER(6, false),
    AUTUMN(9, false)
    ;


    companion object {
        fun getSeason(firstMonth: Int): Seasons {
            return entries.firstOrNull { it.firstMonthNumber == firstMonth } ?: throw IllegalArgumentException(
                "wrong arg $firstMonth"
            )
        }
    }

    fun seasonInfo() {
        println(firstMonthNumber)
        println(isVariableDuration)
        println(name)
    }


    fun temperature(season: Seasons) {
        when (season) {
            WINTER -> "cold"
            SPRING -> "warm"
            SUMMER -> "hot"
            AUTUMN -> "colder"
        }.also { println(it)}
    }
}

interface HasValue {
    val value: String
}

interface HasAction {
    fun Action()
}


enum class HomeTech(override val value: String): HasValue, HasAction {
    VACUUM("Пылесос") {
        override fun Action() {
            println("Make noise")
        }
    },
    WASHING("Стиральная машина") {
        override fun Action() {
            println("Make spin")
        }
    },
    FRIDGE("Холодильник") {
        override fun Action() {
            println("Make cold")
        }
    },
    KETTLE("Чайник") {
        override fun Action() {
            println("Make hot")
        }
    },
    ;

    override fun Action() {
        println("Is Working")
    }
}

fun main() {
    HomeTech.KETTLE.Action()
    HomeTech.WASHING.Action()
}