package ru.stimmax.ru.stimmax.lessons.lesson18.homework

import java.io.InputStream

class WashingMachine(
    override val maxTemperature: Int,
    override val sensorType: String,
    override val maxSensoredValue: Int
) : SetTemperatureAndOpen(), WaterConnection, AutomaticShutdown, Drainable, Timable, SoundEmitting, Cleanable{

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
            println(" $action programm is installed")
        }
        else
            println("$action programm is not installed")
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

    override fun connectToWaterSupply() {
        println(" connect Water")    }

    override fun getWater(amount: Int) {
        println("get water $amount")
    }

    override fun startMonitoring() {
        println("start monitoring")
    }

    override fun connectToDrain() {
        println("connection to dry")
    }

    override fun drain() {
        println("dry")
    }

    override fun setTimer(time: Int) {
        println("set timer - $time")
    }

    override fun setVolume(volume: Int) {
        println("set volume $volume after finishing")
    }

    override fun mute() {
        println("set mute after finishing")
    }

    override fun playSound(stream: InputStream) {
        println("$stream play sound after finishing")
    }

    override fun clean() {
        println("start cleaning")
    }

}

fun main() {
    val washingMachine = WashingMachine(
        maxTemperature = 80,
        sensorType = "sensor",
        maxSensoredValue = 20
    )
    washingMachine.powerOn()
    washingMachine.setTemperature()
    washingMachine.programAction("washing")
    washingMachine.powerOff()
}