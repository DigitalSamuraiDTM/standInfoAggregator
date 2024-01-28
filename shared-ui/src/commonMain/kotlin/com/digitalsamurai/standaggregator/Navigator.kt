package com.digitalsamurai.standaggregator

import androidx.compose.runtime.Composable
import com.digitalsamurai.standaggregator.screens.hiddevices.HidDevicesScreen
import com.digitalsamurai.standaggregator.screens.stand.StandScreen

@Composable
fun Navigator(
    screenState: Screen,
    onNavigate: (Screen) -> Unit
) {

    when (screenState) {
        Screen.HidDevices -> HidDevicesScreen(onNavigate)
        Screen.Stand -> StandScreen(onNavigate)
    }
}


sealed interface Screen {
    object HidDevices : Screen

    object Stand : Screen
}