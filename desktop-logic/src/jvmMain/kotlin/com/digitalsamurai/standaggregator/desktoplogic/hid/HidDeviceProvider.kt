package com.digitalsamurai.standaggregator.desktoplogic.hid

import com.digitalsamurai.standaggregator.desktoplogic.di.AppScope
import com.digitalsamurai.standaggregator.desktoplogic.hid.models.HidDevice
import com.digitalsamurai.standaggregator.desktoplogic.logging.LoggerFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.hid4java.HidManager
import org.hid4java.HidServicesListener
import org.hid4java.HidServicesSpecification
import org.hid4java.ScanMode
import org.hid4java.event.HidServicesEvent
import org.hid4java.jna.HidApi
import org.hid4java.jna.HidApiLibrary
import org.hid4java.jna.LibusbHidApiLibrary
import javax.inject.Inject

@AppScope
public class HidDeviceProvider @Inject constructor(
    private val loggerFactory: LoggerFactory
) {

    private val log = loggerFactory.buildLogger(this)

    private val spec = HidServicesSpecification().apply {
        isAutoStart = true
        scanMode = ScanMode.SCAN_AT_FIXED_INTERVAL
        pauseInterval = 5000
    }

    internal val service = HidManager.getHidServices(spec).also { service ->
        service.addHidServicesListener(object : HidServicesListener {
            override fun hidDeviceAttached(event: HidServicesEvent?) {
                log.i("Device attached: ${event?.hidDevice}")
                updateDeviceStateFlow()
            }

            override fun hidDeviceDetached(event: HidServicesEvent?) {
                log.i("Device detached: ${event?.hidDevice}")
                updateDeviceStateFlow()
            }

            override fun hidFailure(event: HidServicesEvent?) {
                log.i("Device failure: ${event?.hidDevice}")
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
        log.i("PROVIDER INITED WITH DEVICES:\n ${service?.attachedHidDevices?.joinToString("\n")}")
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
        return HidDevice(this,manufacturer, product)
    }
}