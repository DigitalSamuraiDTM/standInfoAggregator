package com.digitalsamurai.standaggregator.desktop.di.components

import com.digitalsamurai.standaggregator.desktop.Environment
import com.digitalsamurai.standaggregator.desktop.di.AppScope
import com.digitalsamurai.standaggregator.desktop.hid.HidDeviceProvider
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.CoroutineScope

@Component
interface AppComponent {


    @AppScope
    fun getHidDeviceProvider(): HidDeviceProvider


    @Component.Factory
    interface Factory{
        fun build(@BindsInstance environment: Environment): AppComponent
    }
}