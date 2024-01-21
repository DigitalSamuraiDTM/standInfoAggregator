package com.digitalsamurai.standaggregator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
//import androidx.compose.material3.Button
//import androidx.compose.material3.DrawerValue
//import androidx.compose.material3.Icon
//import androidx.compose.material3.ModalDrawerSheet
//import androidx.compose.material3.ModalNavigationDrawer
//import androidx.compose.material3.NavigationDrawerItem
//import androidx.compose.material3.NavigationDrawerItemDefaults
//import androidx.compose.material3.Text
//import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun appDrawer() {

//    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
//
//    ModalNavigationDrawer(
//        drawerContent = { drawerContent() },
//        drawerState = drawerState,
//        modifier = Modifier,
//        content = {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(16.dp),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(text = if (drawerState.isClosed) ">>> Swipe >>>" else "<<< Swipe <<<")
//                Spacer(Modifier.height(20.dp))
//                Button(onClick = { }) {
//                    Text("Click to open")
//                }
//            }
//        }
//    )
//}
//
//@Composable
//internal fun drawerContent() {
//    ModalDrawerSheet {
//        Spacer(Modifier.height(10.dp))
//        NavigationDrawerItem(
//            icon = { Icon(Icons.Default.Face, contentDescription = null) },
//            label = { Text("Drawer") },
//            selected = false,
//            onClick = {
//
//            },
//            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
//        )
//    }
}