package com.digitalsamurai.standaggregator.screens.hiddevices

import com.digitalsamurai.standaggregator.drawer.content.AppDrawerContentState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow

public interface HidDevicesScreenModel {

    val screenState: StateFlow<HidDevicesScreenState>

}

public expect fun buildHidDevicesScreenModel(scope: CoroutineScope): HidDevicesScreenModel

