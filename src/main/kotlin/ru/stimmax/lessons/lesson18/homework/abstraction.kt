package ru.stimmax.ru.stimmax.lessons.lesson18.homework

import java.io.InputStream

interface Powerable {
    fun powerOn()
    fun powerOff()
}

interface Openable {
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
    fun getChargeLevel(): Double
    fun recharge()
}

// Задача 1. Создай абстрактные классы устройств, используя эти интерфейсы. Реализовывать методы не нужно.

//Холодильник
abstract class Refrigerators: Powerable, Openable, TemperatureRegulatable, LightEmitting
//Стиральная машина
abstract class WachingMashines: Powerable, Openable, TemperatureRegulatable, WaterConnection, AutomaticShutdown, Drainable, Timable, SoundEmitting, Programmable, Cleanable
//Умная лампа
abstract class SmartLamps: Powerable, TemperatureRegulatable, AutomaticShutdown, LightEmitting, Programmable
//Электронные часы
abstract class SmartWatches: Powerable, BatteryOperated, Rechargeable
//Робот-пылесос
abstract class VacuumCliners: Powerable, WaterContainer, AutomaticShutdown, Timable, BatteryOperated, SoundEmitting, Programmable, Movable, Cleanable, Rechargeable
//Механические часы
abstract class MechanicalWatches: BatteryOperated, Mechanical
//Фонарик
abstract class Flashlights: Powerable, TemperatureRegulatable, BatteryOperated, LightEmitting
//Кофемашина
abstract class CoffeeMachines: Powerable, WaterContainer, TemperatureRegulatable, WaterConnection, AutomaticShutdown, Timable, Programmable, Cleanable
//Умная колонка
abstract class SmartColones: Powerable, AutomaticShutdown, Timable, LightEmitting, SoundEmitting, Programmable, Rechargeable

//Задача 2. Создай абстрактный класс для включаемого оборудования и имплементируй соответствующий интерфейс с реализацией
// методов (достаточно println с выполняемым действием).
abstract class TurnOnEquipment: Powerable{
    var turnOn: Boolean = false
        private set
    override fun powerOn(){
        turnOn = true
        powerOn()
        println("Turn On")
    }
    override fun powerOff(){
        turnOn = false
        powerOff()
        println("Turn Off")
    }
}

//Задача 3. Создай абстрактный класс для программируемого оборудования (с имплементацией соответствующего интерфейса и
// реализацией методов) и наследуй его от абстрактного класса включаемого оборудования.

abstract class ProgrammingEquipment: TurnOnEquipment(), Programmable{
    fun setProgramm(){
        programAction("do smth")
    }
}


//Задача 4. Создай абстрактный класс оборудования с возможностью устанавливать температуру и открываться и с наследованием
// от программируемого оборудования. Также имплементируй интерфейсы.
abstract class SetTemperatureAndOpen: ProgrammingEquipment(), Openable, TemperatureRegulatable{
    fun openEquipment(){
        open()
    }
    fun setTemperature(){
        maxTemperature
        setTemperature(maxTemperature)
    }
}

//Задача 5. Создай не абстрактные классы устройств с наследованием от абстрактного класса с возможностью устанавливать
// температуру и открываться. Пусть это будет холодильник, стиральная машина, чайник, духовка. Добавь недостающие интерфейсы
// и реализуй необходимые методы (достаточно вывод в консоль производимого действия). Обрати внимание на то, что установка
// температуры и программирование устройства (считай - задание режима работы) не имеет смысла при выключенном питании -
// добавь эту проверку.


//Создай объекты этих устройств и позапускай их с различными методами.