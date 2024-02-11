package com.digitalsamurai.standaggregator.desktoplogic.di.components

import com.digitalsamurai.standaggregator.desktoplogic.di.AppScope
import com.digitalsamurai.standaggregator.desktoplogic.hid.HidDeviceProvider
import com.digitalsamurai.standaggregator.desktoplogic.lir.LirDeviceManager
import com.digitalsamurai.standaggregator.desktoplogic.logging.LoggerFactory
import dagger.BindsInstance
import dagger.Component
import java.util.logging.Logger

@AppScope
@Component(modules = [AppModule::class])
public interface AppComponent {


    @AppScope
    public fun getHidDeviceProvider(): HidDeviceProvider

    @AppScope
    public fun getLirDeviceManager(): LirDeviceManager

    @AppScope
    public fun getLoggerFactory(): LoggerFactory


    @Component.Factory
    public interface Factory{
        public fun build(@BindsInstance environment: Environment): AppComponent
    }
}

public class Environment(
    public val name: String
)