package com.mintrocket.debug_screen_module.ui.screens.toggle

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mintrocket.debug_screen_module.ui.components.MultiToggleButton

@Composable
fun ToggleListItemComposition() {

    Card(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)) {
        
        val l = listOf("Disable", "Enable", "Default")

        MultiToggleButton(currentSelection = l.first(), toggleStates = l, onToggleChange = {})

    }

}