package com.digitalsamurai.standaggregator.screens.stand

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.digitalsamurai.standaggregator.Screen

@Composable
fun StandScreen(navigation: (screen: Screen) -> Unit) {
    Column {
        val counter = remember { mutableStateOf(0) }
        Text("SECOND SCREEN: ${counter.value}")


        Button(onClick = { navigation(Screen.HidDevices) }) {
            Text("TO MAIN")

        }
        Button(onClick = { counter.value++ }) {
            Text("+1")

        }
    }
}