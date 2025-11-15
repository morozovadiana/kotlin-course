package ru.stimmax.ru.stimmax.lessons.lesson18.homework

class Oven(override val maxTemperature: Int) : SetTemperatureAndOpen(34), Timable{

    var isPoweredOn: Boolean = false
        private set

    override fun powerOn() {
        isPoweredOn = true
        println("Device is on")
    }

    override fun powerOff() {
        isPoweredOn = false
        println("Device is off")
    }

    override fun setTemperature(temp: Int) {
        if (isPoweredOn) {
            println("temperature - $temp is set")
        } else
            println("Device is off, temperature - $temp is not set")
    }

    override fun programAction(action: String) {
        if (isPoweredOn) {
            println("$action -  programm is installed")
        }
        else
            println(" programm is not installed")
    }

    override fun execute() {
        println("execute")
    }

    override fun open() {
        println("device id open")
    }

    override fun close() {
        println("device is closed")
    }

    override fun setTimer(time: Int) {
        println("set timer - $time")
    }

}


fun main() {
    val oven = Oven(100)
    oven.powerOn()
    oven.open()
    oven.programAction("defrosting")
    oven.powerOff()
}