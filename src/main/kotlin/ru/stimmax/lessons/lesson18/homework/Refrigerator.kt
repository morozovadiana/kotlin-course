package ru.stimmax.ru.stimmax.lessons.lesson18.homework

class Refrigerator(override val maxTemperature: Int) : SetTemperatureAndOpen(maxTemperature), LightEmitting{

    var isPoweredOn: Boolean = false
        private set

    override fun setTemperature(temp: Int) {
        if (isPoweredOn) {
            println("temperature is set")
        } else
            println("Device is off")
    }

    override fun powerOn() {
        isPoweredOn = true
        println("Device is on")
    }

    override fun powerOff() {
        isPoweredOn = false
        println("Device is off")
    }

    override fun programAction(action: String) {
        if (isPoweredOn) {
            println("$action programm is installed")
        }
        else
            println("Device is off, programm is not installed")
    }

    override fun execute() {
        println("execute")
    }

    override fun open() {
        println("Door id open")
    }

    override fun close() {
        println("Door is closed")
    }

    override fun emitLight() {
        println("Light is on")
    }

    override fun completeLiteEmission() {
        println("Complete lite emission")
    }

}

fun main() {
    val refrigerator = Refrigerator(15)
    refrigerator.powerOn()
    refrigerator.open()
    refrigerator.setTemperature(23)
    refrigerator.programAction("freeze")
    refrigerator.powerOff()
}