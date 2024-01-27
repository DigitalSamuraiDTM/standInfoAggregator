@file:OptIn(ExperimentalMaterial3Api::class)

package com.digitalsamurai.standaggregator.drawer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.digitalsamurai.standaggregator.drawer.content.AppDrawerContent
import com.digitalsamurai.standaggregator.drawer.content.AppDrawerContentState
import com.digitalsamurai.standaggregator.drawer.content.AppDrawerElement
import kotlinx.coroutines.launch

@Composable
fun AppDrawer(modifier: Modifier = Modifier) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
    val drawerCoroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = { AppDrawerContent(AppDrawerContentState(AppDrawerElement.SETTINGS), {}) },
        drawerState = drawerState,
        modifier = Modifier.fillMaxSize(),
        content = {},
    )
}

