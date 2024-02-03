package com.digitalsamurai.standaggregator.desktop.hid

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.hid4java.HidManager
import org.hid4java.HidServicesListener
import org.hid4java.HidServicesSpecification
import org.hid4java.ScanMode
import org.hid4java.event.HidServicesEvent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HidDeviceProvider @Inject constructor() {

    private val spec = HidServicesSpecification().apply {
        isAutoStart = true
        scanMode = ScanMode.SCAN_AT_FIXED_INTERVAL
        pauseInterval = 5000
    }

    private val service = HidManager.getHidServices(spec).also { service ->
        service.addHidServicesListener(object : HidServicesListener {
            override fun hidDeviceAttached(event: HidServicesEvent?) {
                updateDeviceStateFlow()
            }

            override fun hidDeviceDetached(event: HidServicesEvent?) {
                updateDeviceStateFlow()
            }

            override fun hidFailure(event: HidServicesEvent?) {
                updateDeviceStateFlow()
            }
        })

    }

    private val _hidDevices = MutableStateFlow<List<HidDevice>>(emptyList())
    public val hidDevices: StateFlow<List<HidDevice>> = _hidDevices

    init {
        service.start()
        service.scan()
        updateDeviceStateFlow()
    }

    /**
     * Update state flow
     */
    private fun updateDeviceStateFlow() {
        _hidDevices.tryEmit(
            service?.attachedHidDevices?.map { it.toDomain() } ?: emptyList()
        )
    }

    private fun org.hid4java.HidDevice.toDomain(): HidDevice {
        return HidDevice(manufacturer, product)
    }
}