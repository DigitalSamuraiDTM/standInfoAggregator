package com.digitalsamurai.standaggregator.hiddevices.lir.device

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cable
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LirDevice(lirState: LirDeviceViewState, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 5.dp)
            .shadow(2.dp)
    ) {
        Column() {
            Text(lirState.name ?: "Device")
            Icon(Icons.Default.Cable, contentDescription = null, tint = Color(0f, 0f, 0f))
            Text(lirState.status.toString())
        }
    }
}


data class LirDeviceViewState(
    val name: String?,
    val status: Status
) {

    enum class Status {
        CONNECTED,
        AWAIT,
    }

    companion object {
        fun preview(): LirDeviceViewState = LirDeviceViewState("LIR-919", Status.AWAIT)
    }
}


