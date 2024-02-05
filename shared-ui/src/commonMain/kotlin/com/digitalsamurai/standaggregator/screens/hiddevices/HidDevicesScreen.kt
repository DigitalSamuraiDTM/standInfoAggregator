package com.digitalsamurai.standaggregator.screens.hiddevices

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.digitalsamurai.standaggregator.Screen
import com.digitalsamurai.standaggregator.screens.hiddevices.device.HidDeviceView
import com.digitalsamurai.standaggregator.screens.hiddevices.device.HidDeviceViewState
import kotlinx.coroutines.launch

@Composable
fun HidDevicesScreen(navigator: (newScreen: Screen) -> Unit, modifier: Modifier = Modifier) {

    val scope = rememberCoroutineScope()
    val screenModel = remember { buildHidDevicesScreenModel(scope) }
    val state = screenModel.screenState.collectAsState().value

        val scrollstate = rememberLazyListState()
        val coroutinescope = rememberCoroutineScope()
        LazyColumn(
            state = scrollstate,
            modifier = modifier.fillMaxHeight().fillMaxWidth()
                .draggable(
                    orientation = Orientation.Vertical,
                    state = rememberDraggableState { delta ->
                        coroutinescope.launch {
                            scrollstate.scrollBy(-delta)
                        }
                    },
                )
        ) {
            items(state.hidDevicesList) {
                HidDeviceView(it)
            }
        }
}

data class HidDevicesScreenState(
    val hidDevicesList: List<HidDeviceViewState>
) {

    companion object {
        fun preview(): HidDevicesScreenState = HidDevicesScreenState(emptyList())
        fun default(): HidDevicesScreenState = HidDevicesScreenState(emptyList())
    }
}


