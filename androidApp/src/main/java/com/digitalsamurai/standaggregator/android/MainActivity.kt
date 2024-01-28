package com.digitalsamurai.standaggregator.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.digitalsamurai.standaggregator.App
import com.tri_tail.ceal_chronicler.android.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            MyApplicationTheme {
                App()
            }
        }
    }
}

