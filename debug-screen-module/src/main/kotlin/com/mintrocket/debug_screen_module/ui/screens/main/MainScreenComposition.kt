package com.mintrocket.debug_screen_module.ui.screens.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.mintrocket.debug_screen_module.ui.components.BottomNavItem
import com.mintrocket.debug_screen_module.ui.components.BottomNavigationComponent
import com.mintrocket.debug_screen_module.ui.screens.console.ConsoleScreenComposition
import com.mintrocket.debug_screen_module.ui.screens.environment.EnvironmentScreenComposition
import com.mintrocket.debug_screen_module.ui.screens.toggle.ToggleScreenComposition
import org.koin.androidx.compose.getViewModel

@Composable
fun MainScreenComposition(
    vm: MainViewModel = getViewModel()
) {
    Scaffold(Modifier.fillMaxSize(), bottomBar = {
        BottomNavigationComponent(navClick = {
            vm.showChildScreen(it)
        })
    }) {
        when(vm.navState.collectAsState().value) {
            BottomNavItem.ToggleScreen -> ToggleScreenComposition()
            BottomNavItem.EnvironmentScreen -> EnvironmentScreenComposition()
            BottomNavItem.ConsoleScreen -> ConsoleScreenComposition()
        }
    }
}