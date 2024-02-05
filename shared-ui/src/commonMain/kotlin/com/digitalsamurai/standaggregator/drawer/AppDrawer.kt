@file:OptIn(ExperimentalMaterial3Api::class)

package com.digitalsamurai.standaggregator.drawer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.digitalsamurai.standaggregator.drawer.content.AppDrawerContent
import com.digitalsamurai.standaggregator.drawer.content.AppDrawerContentState
import kotlinx.coroutines.launch

@Composable
fun AppDrawer(state: AppDrawerViewState, onItemSelected: (AppDrawerContentState.Element) -> Unit) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            AppDrawerContent(state = state.appDrawerContentState) { element ->
                if (drawerState.currentValue == DrawerValue.Open) scope.launch {
                    drawerState.close()
                }
                onItemSelected(element)
            }
        },
        drawerState = drawerState,
        modifier = Modifier.fillMaxSize(),
        content = {}
    )
}

data class AppDrawerViewState(
    val appDrawerContentState: AppDrawerContentState
) {
    companion object {
        fun preview(): AppDrawerViewState = AppDrawerViewState(AppDrawerContentState.preview())

        fun default(): AppDrawerViewState = AppDrawerViewState((AppDrawerContentState.default()))
    }
}
