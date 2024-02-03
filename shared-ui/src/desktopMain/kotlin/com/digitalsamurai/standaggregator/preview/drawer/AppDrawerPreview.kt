package com.digitalsamurai.standaggregator.preview.drawer

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import com.digitalsamurai.standaggregator.drawer.AppDrawer
import com.digitalsamurai.standaggregator.drawer.AppDrawerViewState

@Preview
@Composable
fun previewAppDrawer() {
    AppDrawer(state = AppDrawerViewState.preview()){}
}