package com.digitalsamurai.standaggregator.hiddevices.lir

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.digitalsamurai.standaggregator.lir.LirDevices
import com.digitalsamurai.standaggregator.lir.LirDevicesViewState

@Composable
@Preview
fun LirDevicesPreview() {
    LirDevices(LirDevicesViewState.preview(), modifier = Modifier)
}