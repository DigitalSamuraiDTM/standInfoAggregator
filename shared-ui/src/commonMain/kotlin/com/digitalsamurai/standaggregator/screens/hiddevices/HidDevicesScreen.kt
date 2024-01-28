package com.digitalsamurai.standaggregator.screens.hiddevices

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.digitalsamurai.standaggregator.Screen
import com.digitalsamurai.standaggregator.screens.hiddevices.lir.LirDevicesViewState

@Composable
fun HidDevicesScreen(navigator: (newScreen: Screen) -> Unit, modifier: Modifier = Modifier) {

//    val screenModel = remember { HidDevicesScreenModel() }


    Row(modifier = modifier.fillMaxSize()) {
        AvailableHidDevices()
    }
}

data class HidDevicesScreenState(
    val lirDevices: LirDevicesViewState
) {

    companion object {
        fun preview(): HidDevicesScreenState = HidDevicesScreenState(LirDevicesViewState.preview())
    }
}


@Composable
fun AvailableHidDevices() {
    LazyRow {

    }
}