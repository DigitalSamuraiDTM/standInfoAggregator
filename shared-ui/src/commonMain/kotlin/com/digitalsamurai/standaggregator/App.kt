package com.digitalsamurai.standaggregator

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.lightColors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.digitalsamurai.standaggregator.drawer.AppDrawer
import com.digitalsamurai.standaggregator.drawer.AppDrawerViewState
import com.digitalsamurai.standaggregator.screens.hiddevices.lir.LirDevices
import com.digitalsamurai.standaggregator.screens.hiddevices.lir.LirDevicesViewState

private val LightColorPalette = lightColors(
    background = Color(0x00ff00)

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun App() {
    val baseModifier = Modifier
    MaterialTheme(
        shapes = Shapes(
            extraSmall = RoundedCornerShape(0),
            small = RoundedCornerShape(0),
            medium = RoundedCornerShape(0),
            large = RoundedCornerShape(0),
            extraLarge = RoundedCornerShape(0)
        )
    ) {

        val screenModel = remember { buildAppScreenModel() }
        val appState = screenModel.screenState.collectAsState()


        Surface(shape = RectangleShape, modifier = baseModifier) {
            Column {
                // HEADER
                Row(
                    modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        modifier = Modifier.wrapContentWidth(),
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.Black
                        ),
                        border = BorderStroke(0.dp, Color.Transparent),
                        shape = RectangleShape,
                    ) {
                        Image(Icons.Default.Menu, contentDescription = null)
                    }
                    LirDevices(
                        state = LirDevicesViewState.preview(),
                        modifier = Modifier.wrapContentHeight()
                    )
                }

                // CONTENT
                Box(modifier = baseModifier) {
                    Navigator(appState.value.screen) { screen ->
                        screenModel.onScreenChanged(newScreen = screen)
                    }
                }
            }

            AppDrawer(state = appState.value.appDrawerViewState) { element ->
                screenModel.onAppDrawerElementSelected(element = element)
            }
        }
    }
}


data class AppScreenState(
    val screen: Screen,
    val lirDevicesViewState: LirDevicesViewState,
    val appDrawerViewState: AppDrawerViewState
) {

    companion object {
        fun preview(): AppScreenState = AppScreenState(
            Screen.HidDevices,
            LirDevicesViewState.preview(),
            AppDrawerViewState.preview()
        )

        fun default(): AppScreenState = AppScreenState(
            screen = Screen.HidDevices,
            lirDevicesViewState = LirDevicesViewState.default(),
            appDrawerViewState = AppDrawerViewState.default()
        )
    }
}


