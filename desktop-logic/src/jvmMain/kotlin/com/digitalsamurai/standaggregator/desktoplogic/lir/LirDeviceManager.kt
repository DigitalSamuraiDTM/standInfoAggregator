package com.digitalsamurai.standaggregator.desktoplogic.lir

import com.digitalsamurai.standaggregator.desktoplogic.hid.HidDeviceProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


public class LirDeviceManager @Inject constructor(
    private val appScope: CoroutineScope,
    private val hidDeviceProvider: HidDeviceProvider
) {

    private val firstDevice: Lir919? = null
    private val secondDevice: Lir919? = null
    private val thirdDevice: Lir919? = null

    init {
        observeHidDevices()
    }

    private val _deviceConnectionStatus = MutableStateFlow(
        ConnectionStatus(
            isFirstDeviceConnected = false,
            isSecondDeviceConnected = false,
            isThirdDeviceConnected = false
        )
    )
    public val deviceConnectionStatus: StateFlow<ConnectionStatus> = _deviceConnectionStatus

    private fun observeHidDevices() {
        appScope.launch {
            hidDeviceProvider.hidDevices.collect { hidDevices ->
                println(hidDevices.filter { it.product?.contains("Arduino") == true }.joinToString("\n"))
                // need to find LIR devices and provide reporting message bridge
                
            }
        }
    }

    public data class ConnectionStatus(
        val isFirstDeviceConnected: Boolean,
        val isSecondDeviceConnected: Boolean,
        val isThirdDeviceConnected: Boolean,
    )
}