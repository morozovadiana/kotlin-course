package ru.stimmax.ru.stimmax.lessons.lesson18.lesson

import java.io.InputStream

interface Powarable {
    fun turnOn()
    fun ternOff()
}

interface Openable{
    fun open()
    fun close()
}

interface WaterContainer {
    val capacity: Int
    fun fillWater(amount: Int)
    fun getWater(amount: Int)
}
interface TemperatureRegulatable {
    val maxTemperature: Int
    fun setTemperature(temp: Int)
}
interface WaterConnection {
    fun connectToWaterSupply()
    fun getWater(amount: Int)
}
interface AutomaticShutdown {
    val sensorType: String
    val maxSensoredValue: Int
    fun startMonitoring()
}
interface Drainable {
    fun connectToDrain()
    fun drain()
}
interface Timable {
    fun setTimer(time: Int)
}
interface BatteryOperated {
    fun getCapacity(): Double
    fun replaceBattery()
}
interface Mechanical {
    fun performMechanicalAction()
}
interface LightEmitting {
    fun emitLight()
    fun completeLiteEmission()
}
interface SoundEmitting {
    fun setVolume(volume: Int)
    fun mute()
    fun playSound(stream: InputStream)
}
interface Programmable {
    fun programAction(action: String)
    fun execute()
}
interface Movable {
    fun move(direction: String, distance: Int)
}
interface Cleanable {
    fun clean()
}
interface Rechargeable {
    fun getCapacity(): Double
    fun recharge()
}

abstract class TeaPot: Powarable, Openable, WaterContainer, AutomaticShutdown
abstract class Vacuum: Powarable, Cleanable
abstract class Alice: Powarable, SoundEmitting, Timable, Rechargeable
abstract class Oven: Powarable, Openable, Timable, TemperatureRegulatable

fun closeObject(list: List<Openable>){
list.forEach { it ->
    it.close()
}
}

