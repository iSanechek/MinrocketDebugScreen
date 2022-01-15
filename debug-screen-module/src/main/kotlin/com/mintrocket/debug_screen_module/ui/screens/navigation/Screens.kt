package com.mintrocket.debug_screen_module.ui.screens.navigation

import androidx.compose.runtime.Composable
import com.github.terrakok.modo.android.compose.ComposeScreen
import com.mintrocket.debug_screen_module.ui.screens.main.MainScreenComposition
import kotlinx.parcelize.Parcelize

@Parcelize
class MainScreen : ComposeScreen("MainScreen") {

    @Composable
    override fun Content() {
        MainScreenComposition()
    }
}
// TODO Will be latter
//@Parcelize
//class ToggleScreen : ComposeScreen("ToggleScreen") {
//
//    @Composable
//    override fun Content() {
//
//    }
//}
//
//@Parcelize
//class EnvironmentScreen : ComposeScreen("EnvironmentScreen") {
//
//    @Composable
//    override fun Content() {
//
//    }
//}
//
//@Parcelize
//class ConsoleScreen : ComposeScreen("ConsoleScreen") {
//
//    @Composable
//    override fun Content() {
//
//    }
//}