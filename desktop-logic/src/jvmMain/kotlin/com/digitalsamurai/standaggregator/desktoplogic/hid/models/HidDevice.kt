package com.digitalsamurai.standaggregator.desktoplogic.hid.models

import org.hid4java.HidDevice

public data class HidDevice(
    internal val device: HidDevice,
    val manufacturer: String?,
    val product: String?,
)