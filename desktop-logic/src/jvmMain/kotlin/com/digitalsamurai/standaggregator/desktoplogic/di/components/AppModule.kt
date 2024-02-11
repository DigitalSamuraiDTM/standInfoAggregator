package com.digitalsamurai.standaggregator.desktoplogic.di.components

import com.digitalsamurai.standaggregator.desktoplogic.coroutines.BaseCoroutineScopes
import com.digitalsamurai.standaggregator.desktoplogic.di.AppScope
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope

@Module
public class AppModule {

    @Provides
    @AppScope
    public fun appScope(baseCoroutineScopes: BaseCoroutineScopes): CoroutineScope = baseCoroutineScopes.appScope

}