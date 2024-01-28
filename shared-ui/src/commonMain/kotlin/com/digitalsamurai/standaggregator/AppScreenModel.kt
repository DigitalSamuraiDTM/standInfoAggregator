package com.digitalsamurai.standaggregator

import com.digitalsamurai.standaggregator.drawer.content.AppDrawerContentState
import kotlinx.coroutines.flow.StateFlow

interface AppScreenModel {

    val screenState: StateFlow<AppScreenState>

    fun onScreenChanged(newScreen: Screen)

    fun onAppDrawerElementSelected(element: AppDrawerContentState.Element)
}

expect fun buildAppScreenModel(): AppScreenModel

