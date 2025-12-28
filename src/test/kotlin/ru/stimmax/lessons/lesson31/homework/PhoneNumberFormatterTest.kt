package ru.stimmax.lessons.lesson31.homework

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import ru.stimmax.ru.stimmax.lessons.lesson31.homework.PhoneNumberFormatter

class PhoneNumberFormatterTest {
    @ParameterizedTest
    @MethodSource("listOfNumbers")
    fun `should calculate valid phone number`(
        phoneNumber: String,
        formatPhoneNumber: String
    ) {
        assertEquals(formatPhoneNumber,
            PhoneNumberFormatter().formatPhoneNumber(phoneNumber))
    }

    @ParameterizedTest
    @MethodSource("invalidNumbers")
    fun `should calculate invalid phone number`(
        phoneNumber: String
    ) {
        assertThrows(IllegalArgumentException::class.java) {
            PhoneNumberFormatter().formatPhoneNumber(phoneNumber)
        }
    }


    companion object {
        @JvmStatic
        fun listOfNumbers() = listOf<Any>(
            arrayOf("8 (922) 941-11-11", "+7 (922) 941-11-11"),
            arrayOf("79229411111", "+7 (922) 941-11-11"),
            arrayOf("+7 922 941 11 11", "+7 (922) 941-11-11"),
            arrayOf("9229411111", "+7 (922) 941-11-11"),
            arrayOf("abc +7 922 941 11 11", "+7 (922) 941-11-11")
        )

        @JvmStatic
        fun invalidNumbers() = listOf<Any>(
            arrayOf("12345", "IllegalArgumentException"),
            arrayOf("+1 (922) 941-11-11", "IllegalArgumentException")
        )
    }
}
