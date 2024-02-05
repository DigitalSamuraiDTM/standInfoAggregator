package com.digitalsamurai.standaggregator.screens.hiddevices

import com.digitalsamurai.standaggregator.desktoplogic.di.AppComponentHolder
import com.digitalsamurai.standaggregator.screens.hiddevices.device.HidDeviceViewState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class HidDevicesScreenModelImpl(private val scope: CoroutineScope): HidDevicesScreenModel {

    private val appComponent = AppComponentHolder.get()


    private val _screenState = MutableStateFlow<HidDevicesScreenState>(HidDevicesScreenState.default())
    override val screenState: StateFlow<HidDevicesScreenState>
        get() = _screenState

    init {
        observeHidDevices()
    }

    private fun observeHidDevices() = scope.launch {
        appComponent.getHidDeviceProvider().hidDevices.collect {devices ->
            _screenState.value = _screenState.value.copy(hidDevicesList = devices.map {
                HidDeviceViewState(
                    product = it.product ?: "Unknown product",
                    manufacturer = it.manufacturer
                )
            })
        }
    }
}

actual fun buildHidDevicesScreenModel(scope: CoroutineScope): HidDevicesScreenModel {
    return HidDevicesScreenModelImpl(scope)
}