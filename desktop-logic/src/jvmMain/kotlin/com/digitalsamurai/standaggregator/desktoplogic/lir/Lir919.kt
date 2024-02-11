package com.digitalsamurai.standaggregator.desktoplogic.lir

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import org.hid4java.HidDevice
import org.hid4java.jna.HidApi
import java.util.concurrent.TimeUnit

/**
 * Lir-919 module connected via HID device
 *
 */
internal class Lir919 constructor(internal val device: HidDevice){

    init {
        if (!device.isOpen)  device.open()
    }


    public fun read() = flow<ByteArray> {
        while (true) {
            val data = device.read()
            println("RECEIVED FROM ${device.manufacturer}:${data.map { it.toInt() }}")
            println("USAGE ${device.usage}")
            emit(data.toByteArray())
            delay(500)
        }
    }


    public fun destroy() {
        device.close()
    }
}
