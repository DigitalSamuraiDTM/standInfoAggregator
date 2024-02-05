package com.digitalsamurai.standaggregator

import dagger.BindsInstance
import dagger.Component

@Component
interface SComponent {

    @Component.Factory
    interface Factory{
        fun build(@BindsInstance environment: Environment): SComponent
    }
}