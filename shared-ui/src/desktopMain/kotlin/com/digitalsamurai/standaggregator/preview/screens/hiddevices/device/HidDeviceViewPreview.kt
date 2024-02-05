package com.digitalsamurai.standaggregator.preview.screens.hiddevices.device

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.digitalsamurai.standaggregator.screens.hiddevices.device.HidDeviceView
import com.digitalsamurai.standaggregator.screens.hiddevices.device.HidDeviceViewState

@Composable
@Preview
private fun previewHidDeviceView() {
    HidDeviceView(
        state = HidDeviceViewState.preview(), modifier = Modifier
            .padding(5.dp)
            .background(Color.LightGray)
    )
}