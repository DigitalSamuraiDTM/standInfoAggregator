package com.digitalsamurai.standaggregator.screens.hiddevices.device

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HidDeviceView(state: HidDeviceViewState, modifier: Modifier = Modifier, onHidDeviceClicked: () -> Unit) {
    Card(shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .padding(start = 10.dp, end = 10.dp, top = 3.dp, bottom = 3.dp)
            .fillMaxWidth()
            .heightIn(50.dp, 80.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer),
        onClick = { onHidDeviceClicked.invoke() }) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 2.dp, bottom = 2.dp)
        ) {
            Text(state.product, modifier = Modifier)
            if (state.manufacturer != null) Text(
                state.manufacturer.toString(),
                modifier = Modifier,
                fontSize = 14.sp
            )
        }
    }
}

public data class HidDeviceViewState(
    val product: String,
    val manufacturer: String? = null
) {

    companion object {
        fun preview(): HidDeviceViewState = HidDeviceViewState("Example")
    }
}