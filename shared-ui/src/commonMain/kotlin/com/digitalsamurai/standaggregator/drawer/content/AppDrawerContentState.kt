package com.digitalsamurai.standaggregator.drawer.content

data class AppDrawerContentState(
    val selectedElement: Element
) {


    enum class Element {
        HID_DEVICES,
        STAND,
        SETTINGS,
    }

    companion object {
        fun preview(): AppDrawerContentState = AppDrawerContentState(Element.HID_DEVICES)
        fun default(): AppDrawerContentState = AppDrawerContentState(Element.HID_DEVICES)
    }
}

