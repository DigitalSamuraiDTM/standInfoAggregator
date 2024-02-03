package com.digitalsamurai.standaggregator.desktop.lir

import com.digitalsamurai.standaggregator.desktop.hid.HidDeviceProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject


class LirDeviceManager @Inject constructor(
    private val appScope: CoroutineScope,
    private val hidDeviceProvider: HidDeviceProvider
) {

    init {
        observeHidDevices()
    }

    private fun observeHidDevices() {
        appScope.launch {
            hidDeviceProvider.hidDevices.collect {
                // need to find LIR devices and provide reporting message bridge
                
            }
        }
    }
}