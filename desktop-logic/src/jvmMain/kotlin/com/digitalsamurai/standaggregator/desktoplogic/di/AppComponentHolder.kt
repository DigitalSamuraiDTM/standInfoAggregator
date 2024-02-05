package com.digitalsamurai.standaggregator.desktoplogic.di

import com.digitalsamurai.standaggregator.desktoplogic.di.components.AppComponent
import com.digitalsamurai.standaggregator.desktoplogic.di.components.DaggerAppComponent
import com.digitalsamurai.standaggregator.desktoplogic.di.components.Environment

public object AppComponentHolder {

    private var appComponent: AppComponent? = null


    public fun get(): AppComponent {
        return appComponent ?: synchronized(this) {
            appComponent ?: DaggerAppComponent.factory().build(Environment("StandInfo"))
                .also { newComponent ->
                    appComponent = newComponent
                }
        }
    }

}