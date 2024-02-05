package com.digitalsamurai.standaggregator.hiddevices.lir.device

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import com.digitalsamurai.standaggregator.lir.device.LirDevice
import com.digitalsamurai.standaggregator.lir.device.LirDeviceViewState


@Composable
@Preview
fun LirDevicePreview() {
    LirDevice(LirDeviceViewState.preview())
}