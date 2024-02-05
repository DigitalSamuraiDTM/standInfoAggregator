@file:OptIn(ExperimentalMaterial3Api::class)

package com.digitalsamurai.standaggregator.drawer.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeviceHub
import androidx.compose.material.icons.filled.ElectricMeter
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun AppDrawerContent(
    state: AppDrawerContentState,
    modifier: Modifier = Modifier,
    onElementSelected: (AppDrawerContentState.Element) -> (Unit)
) {
    Column(modifier = modifier.widthIn(30.dp,100.dp)) {
        Spacer(Modifier.height(10.dp))
        NavigationDrawerItem(
            icon = { Icon(Icons.Default.DeviceHub, contentDescription = null) },
            label = { Text("HID Devices") },
            selected = state.selectedElement == AppDrawerContentState.Element.HID_DEVICES,
            onClick = {
                onElementSelected(AppDrawerContentState.Element.HID_DEVICES)
            }
        )
        NavigationDrawerItem(
            icon = { Icon(Icons.Default.ElectricMeter, contentDescription = null) },
            label = { Text("Stand") },
            selected = state.selectedElement == AppDrawerContentState.Element.STAND,
            onClick = {
                onElementSelected(AppDrawerContentState.Element.STAND)
            }
        )
        NavigationDrawerItem(
            icon = { Icon(Icons.Default.Settings, contentDescription = null) },
            label = { Text("Settings") },
            selected = state.selectedElement == AppDrawerContentState.Element.SETTINGS,
            onClick = {
                onElementSelected(AppDrawerContentState.Element.SETTINGS)
            }
        )
    }

}

