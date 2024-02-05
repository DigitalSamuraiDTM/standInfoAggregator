package com.digitalsamurai.standaggregator.screens.hiddevices.device

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HidDeviceView(state: HidDeviceViewState, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(50.dp)
            .background(MaterialTheme.colorScheme.primaryContainer, MaterialTheme.shapes.medium)
            .padding(10.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(state.name)
    }
}

public data class HidDeviceViewState(
    val name: String
) {

    companion object {
        fun preview(): HidDeviceViewState = HidDeviceViewState("Example")
    }
}