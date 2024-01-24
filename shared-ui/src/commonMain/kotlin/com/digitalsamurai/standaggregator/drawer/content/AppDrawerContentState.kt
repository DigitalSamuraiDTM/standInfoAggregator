package com.digitalsamurai.standaggregator.drawer.content

public data class AppDrawerContentState(
    val selectedElement: AppDrawerElement
)

enum class AppDrawerElement {
    HID_DEVICES,
    STAND,
    SETTINGS,
}