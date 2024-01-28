package com.digitalsamurai.standaggregator.preview.drawer.content

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import com.digitalsamurai.standaggregator.drawer.content.AppDrawerContent
import com.digitalsamurai.standaggregator.drawer.content.AppDrawerContentState

@Preview
@Composable
private fun previewAppDrawerContent() {
    AppDrawerContent(AppDrawerContentState(AppDrawerContentState.Element.HID_DEVICES)) {

    }
}