package com.digitalsamurai.standaggregator.desktoplogic.di.components

import com.digitalsamurai.standaggregator.desktoplogic.di.AppScope
import com.digitalsamurai.standaggregator.desktoplogic.hid.HidDeviceProvider
import dagger.BindsInstance
import dagger.Component

@Component
public interface AppComponent {


    @AppScope
    fun getHidDeviceProvider(): HidDeviceProvider


    @Component.Factory
    interface Factory{
        fun build(@BindsInstance environment: Environment): AppComponent
    }
}

public class Environment(
    val name: String
)