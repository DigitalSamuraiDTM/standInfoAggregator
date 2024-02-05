package com.digitalsamurai.standaggregator.desktop


import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.digitalsamurai.standaggregator.App

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


