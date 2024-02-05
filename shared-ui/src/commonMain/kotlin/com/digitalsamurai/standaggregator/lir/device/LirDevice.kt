package com.digitalsamurai.standaggregator.lir.device

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cable
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun LirDevice(lirState: LirDeviceViewState, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = lirState.name ?: "Module",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 5.dp)
        )
        Icon(Icons.Default.Cable, contentDescription = null, tint = Color(0f, 0f, 0f))
        Row(modifier = Modifier.height(intrinsicSize = IntrinsicSize.Min)) {
            Canvas(modifier = Modifier.padding(end = 5.dp).fillMaxHeight()) {
                drawCircle(lirState.extractStateColor(), 5f)
            }
            Text(
                text = lirState.extractStateTitle(),
                textAlign = TextAlign.Center, modifier = Modifier
            )
        }
    }
}

private fun LirDeviceViewState.extractStateTitle(): String {
    return when (this.status) {
        LirDeviceViewState.Status.CONNECTED -> "Connected"
        LirDeviceViewState.Status.AWAIT -> "Await"
    }
}

private fun LirDeviceViewState.extractStateColor(): Color {
    return when (this.status) {
        LirDeviceViewState.Status.CONNECTED -> Color.Green
        LirDeviceViewState.Status.AWAIT -> Color.Red
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
        fun default(): LirDeviceViewState = LirDeviceViewState("", Status.AWAIT)
    }
}


