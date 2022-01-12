package com.mintrocket.debug_screen_module.ui.components

import androidx.compose.foundation.Image
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.mintrocket.debug_screen_module.R

sealed class BottomNavItem(val titleId: Int, val iconId: Int) {
    object ToggleScreen : BottomNavItem(
        titleId = R.string.bottom_nav_toggle_screen_title,
        iconId = R.drawable.ic_baseline_construction_24
    )

    object EnvironmentScreen : BottomNavItem(
        titleId = R.string.bottom_nav_environment_screen_title,
        iconId = R.drawable.ic_baseline_electrical_services_24
    )

    object ConsoleScreen : BottomNavItem(
        titleId = R.string.bottom_nav_console_screen_title,
        iconId = R.drawable.ic_baseline_pest_control_24
    )
}

@Composable
fun BottomNavigationComponent(navClick: (BottomNavItem) -> Unit) {
    var currentSelect by remember {
        mutableStateOf<BottomNavItem>(BottomNavItem.ToggleScreen)
    }
    BottomNavigation {
        listOf(
            BottomNavItem.ToggleScreen,
            BottomNavItem.EnvironmentScreen,
            BottomNavItem.ConsoleScreen
        ).forEach { item ->
            BottomNavigationItem(
                icon = {
                    Image(
                        painter = painterResource(id = item.iconId),
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = stringResource(id = item.titleId))
                },
                selected = currentSelect == item,
                onClick = {
                    currentSelect = item
                    navClick(item)
                }
            )
        }
    }
}