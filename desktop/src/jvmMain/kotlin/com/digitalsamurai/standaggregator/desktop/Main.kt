package com.digitalsamurai.standaggregator.desktop

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() {
    application {
        val windowState = rememberWindowState()

        Window(
            onCloseRequest = ::exitApplication,
            state = windowState,
            title = "Stand info aggregator"
        ) {
            Surface(modifier = Modifier.fillMaxSize()) {
                Button({

                }){
                    Text("FAK")
                }
            }
        }
    }
}