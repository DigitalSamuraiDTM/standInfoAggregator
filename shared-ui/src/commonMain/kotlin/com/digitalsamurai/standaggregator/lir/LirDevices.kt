package com.digitalsamurai.standaggregator.lir

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.digitalsamurai.standaggregator.lir.device.LirDevice
import com.digitalsamurai.standaggregator.lir.device.LirDeviceViewState

@Composable
fun LirDevices(state: LirDevicesViewState, modifier: Modifier) {
    Row(modifier = modifier) {
        LirDevice(state.firstDevice, Modifier.weight(1f))
        LirDevice(state.secondDevice, Modifier.weight(1f))
        LirDevice(state.thirdDevice, Modifier.weight(1f))
    }
}

data class LirDevicesViewState(
    val firstDevice: LirDeviceViewState,
    val secondDevice: LirDeviceViewState,
    val thirdDevice: LirDeviceViewState
) {

    companion object {
        fun preview(): LirDevicesViewState = LirDevicesViewState(
            LirDeviceViewState.preview(),
            LirDeviceViewState.preview(),
            LirDeviceViewState.preview()
        )

        fun default(): LirDevicesViewState = LirDevicesViewState(
            LirDeviceViewState.default(),
            LirDeviceViewState.default(),
            LirDeviceViewState.default()
        )
    }
}