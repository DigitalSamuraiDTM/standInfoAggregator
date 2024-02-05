package com.digitalsamurai.standaggregator

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.digitalsamurai.standaggregator.drawer.AppDrawerViewState
import com.digitalsamurai.standaggregator.drawer.content.AppDrawerContent
import com.digitalsamurai.standaggregator.lir.LirDevices
import com.digitalsamurai.standaggregator.lir.LirDevicesViewState


@Composable
fun App() {
    val baseModifier = Modifier
    MaterialTheme(
        shapes = Shapes(
            extraSmall = RoundedCornerShape(20),
            small = RoundedCornerShape(25),
            medium = RoundedCornerShape(25),
            large = RoundedCornerShape(30),
            extraLarge = RoundedCornerShape(30)
        ),
        colorScheme = MaterialTheme.colorScheme.copy(
            primary = Color(0, 0, 0),
            primaryContainer = Color(191, 207, 255),
            background = Color.White

        )
    ) {

        val screenModel = remember { buildAppScreenModel() }
        val appState = screenModel.screenState.collectAsState().value

        Surface(shape = RectangleShape, modifier = baseModifier) {
            Row {
                AppDrawerContent(
                    state = appState.appDrawerViewState.appDrawerContentState,
                    modifier = Modifier.weight(1f)
                ) { element ->
                    screenModel.onAppDrawerElementSelected(element = element)
                }

                Column(modifier = Modifier.weight(3f)) {
                    // HEADER
                    Row(
                        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        LirDevices(
                            state = LirDevicesViewState.preview(),
                            modifier = Modifier.wrapContentHeight()
                        )
                    }

                    // CONTENT
                    Box(modifier = baseModifier) {
                        Navigator(appState.screen) { screen ->
                            screenModel.onScreenChanged(newScreen = screen)
                        }
                    }
                }
            }
//            AppDrawer(state = appState.value.appDrawerViewState) { element ->
//                screenModel.onAppDrawerElementSelected(element = element)
//            }
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


