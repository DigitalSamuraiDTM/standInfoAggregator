package com.digitalsamurai.standaggregator.desktoplogic.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Inject

public class BaseCoroutineScopes @Inject constructor() {

    private val appSuperVisor = SupervisorJob()

    public val appScope: CoroutineScope = CoroutineScope(Dispatchers.IO + appSuperVisor)
}