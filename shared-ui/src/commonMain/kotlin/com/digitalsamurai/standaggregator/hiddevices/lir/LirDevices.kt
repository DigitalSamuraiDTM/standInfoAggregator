package com.digitalsamurai.standaggregator.hiddevices.lir

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.digitalsamurai.standaggregator.hiddevices.lir.device.LirDevice
import com.digitalsamurai.standaggregator.hiddevices.lir.device.LirDeviceViewState

@Composable
fun LirDevices(state: LirDevicesViewState) {
    Row(modifier = Modifier.heightIn(40.dp, 200.dp)) {
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
    }
}