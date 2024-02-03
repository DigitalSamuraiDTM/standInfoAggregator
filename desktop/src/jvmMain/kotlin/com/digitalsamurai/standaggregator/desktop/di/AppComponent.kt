package com.digitalsamurai.standaggregator.desktop.di

import com.digitalsamurai.standaggregator.desktop.Environment
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.CoroutineScope

@Component
interface AppComponent {



    @Component.Factory
    interface Factory{
        fun build(@BindsInstance environment: Environment,
                  @BindsInstance appScope: CoroutineScope): AppComponent
    }
}