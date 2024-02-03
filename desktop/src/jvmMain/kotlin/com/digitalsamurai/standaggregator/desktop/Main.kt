package com.digitalsamurai.standaggregator.desktop


import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.digitalsamurai.standaggregator.App
import com.digitalsamurai.standaggregator.desktop.hid.HidDeviceProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun main() {

    application {
        val windowState = rememberWindowState()

        Window(
            onCloseRequest = ::exitApplication,
            state = windowState,
            title = "Stand info aggregator"
        ) {
            App()
        }
    }
}


data class Environment(
    val appName: String
)