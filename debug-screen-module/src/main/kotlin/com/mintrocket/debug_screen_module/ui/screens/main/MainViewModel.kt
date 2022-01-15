package com.mintrocket.debug_screen_module.ui.screens.main

import androidx.annotation.MainThread
import androidx.lifecycle.ViewModel
import com.github.terrakok.modo.Modo
import com.mintrocket.debug_screen_module.ui.components.BottomNavItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(private val navigator: Modo) : ViewModel() {

    private val _navState = MutableStateFlow<BottomNavItem>(BottomNavItem.ToggleScreen)
    val navState: StateFlow<BottomNavItem> = _navState

    @MainThread
    fun showChildScreen(item: BottomNavItem) {
        _navState.value = item
    }
}