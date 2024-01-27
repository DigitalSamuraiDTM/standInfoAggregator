package com.digitalsamurai.standaggregator

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.lightColors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.digitalsamurai.standaggregator.drawer.AppDrawer
import com.digitalsamurai.standaggregator.hiddevices.HidDevicesScreen
import com.digitalsamurai.standaggregator.hiddevices.lir.LirDevices
import com.digitalsamurai.standaggregator.hiddevices.lir.LirDevicesViewState
import kotlinx.coroutines.launch

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
        Surface(shape = RectangleShape, modifier = baseModifier) {

            Box(modifier = baseModifier.padding(start = 60.dp)) {
                Navigator(initial = { Screen.HidDevices })
            }

            //draw at end because it need for show at top of all ui
            Row(modifier = Modifier.fillMaxWidth().wrapContentHeight(), verticalAlignment = Alignment.CenterVertically) {
                Button(
                    modifier = Modifier.wrapContentWidth(),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Black
                    ), border = BorderStroke(0.dp, Color.Transparent),
                    shape = RectangleShape,
                ) {
                    Image(Icons.Default.Menu, contentDescription = null)
                }
                LirDevices(LirDevicesViewState.preview(), modifier = Modifier.wrapContentHeight())
            }
                AppDrawer(baseModifier)
        }
    }

}

@Composable
fun Navigator(
    initial: () -> Screen,
) {
    val screenState = remember { mutableStateOf(initial()) }
    val navigatorFun: (Screen) -> Unit = { newScreen ->
        screenState.value = newScreen
    }
    when (screenState.value) {
        Screen.HidDevices -> HidDevicesScreen(navigatorFun)
        Screen.SecondScreen -> SecondScreen(navigatorFun)
    }
}


sealed interface Screen {
    object HidDevices : Screen

    object SecondScreen : Screen
}

@Composable
fun SecondScreen(navigation: (screen: Screen) -> Unit) {
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


