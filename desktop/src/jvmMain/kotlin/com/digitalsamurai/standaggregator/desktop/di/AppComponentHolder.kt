package com.digitalsamurai.standaggregator.desktop.di

import com.digitalsamurai.standaggregator.desktop.Environment
import com.digitalsamurai.standaggregator.desktop.di.components.AppComponent
import com.digitalsamurai.standaggregator.desktop.di.components.DaggerAppComponent

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