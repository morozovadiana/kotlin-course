package ru.stimmax.ru.stimmax.lessons.lesson18.homework

class Teapot(
    override val maxTemperature: Int,
    override val capacity: Int,
    override val sensorType: String,
    override val maxSensoredValue: Int
) : SetTemperatureAndOpen(), WaterContainer, AutomaticShutdown{

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
            println("temperature $temp is set")
        } else
            println("Device is off, temperature $temp is not set")
    }

    override fun programAction(action: String) {
        if (isPoweredOn) {
            println(" ${action} - programm is installed")
        }
        else
            println("$action - programm is not installed")
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

    override fun fillWater(amount: Int) {
        println("fill water - $amount")
    }

    override fun getWater(amount: Int) {
        println("get water - $amount")
    }

    override fun startMonitoring() {
        println("start monitoring")
    }
}


fun main() {
    val teapot = Teapot(
        maxTemperature = 100,
        capacity = 80,
        sensorType = "sensor",
        maxSensoredValue = 24
    )
    teapot.powerOn()
    teapot.open()
    teapot.fillWater(67)
    teapot.getWater(60)
    teapot.powerOff()
}