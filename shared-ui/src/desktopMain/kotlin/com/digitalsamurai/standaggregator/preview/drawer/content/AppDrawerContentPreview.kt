package com.digitalsamurai.standaggregator.preview.drawer.content

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.digitalsamurai.standaggregator.drawer.content.AppDrawerContent
import com.digitalsamurai.standaggregator.drawer.content.AppDrawerContentState
import com.digitalsamurai.standaggregator.drawer.content.AppDrawerElement

@Preview
@Composable
private fun previewAppDrawerContent() {
    AppDrawerContent(AppDrawerContentState(AppDrawerElement.SETTINGS)) {

    }
}