package com.digitalsamurai.standaggregator

import com.digitalsamurai.standaggregator.desktoplogic.di.AppComponentHolder
import com.digitalsamurai.standaggregator.desktoplogic.lir.LirDeviceManager
import com.digitalsamurai.standaggregator.drawer.AppDrawerViewState
import com.digitalsamurai.standaggregator.drawer.content.AppDrawerContentState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlin.math.log

internal class AppScreenModelImpl : AppScreenModel {

    private val lirDeviceManager: LirDeviceManager = AppComponentHolder.get().getLirDeviceManager()

    private val logger = AppComponentHolder.get().getLoggerFactory().buildLogger(this)

    private val _screenState = MutableStateFlow<AppScreenState>(AppScreenState.default())
    override val screenState: StateFlow<AppScreenState> = _screenState

    init {
        logger.i("APP SCREEN MODEL INITED")
    }

    override fun onScreenChanged(newScreen: Screen) {
        _screenState.update { previous ->
            previous.copy(
                screen = newScreen, appDrawerViewState = AppDrawerViewState(
                    AppDrawerContentState(selectedElement = newScreen.toAppDrawerElement())
                )
            )
        }
    }

    override fun onAppDrawerElementSelected(element: AppDrawerContentState.Element) {
        _screenState.update { previous ->
            previous.copy(
                screen = element.toScreen(), appDrawerViewState = AppDrawerViewState(
                    AppDrawerContentState(selectedElement = element)
                )
            )
        }
    }

    private fun AppDrawerContentState.Element.toScreen(): Screen {
        return when (this) {
            AppDrawerContentState.Element.HID_DEVICES -> Screen.HidDevices
            AppDrawerContentState.Element.STAND -> Screen.Stand
            AppDrawerContentState.Element.SETTINGS -> Screen.HidDevices
        }
    }

    private fun Screen.toAppDrawerElement(): AppDrawerContentState.Element {
        return when (this) {
            Screen.HidDevices -> AppDrawerContentState.Element.HID_DEVICES
            Screen.Stand -> AppDrawerContentState.Element.STAND
        }
    }

}

actual fun buildAppScreenModel(): AppScreenModel {
    return AppScreenModelImpl()
}
