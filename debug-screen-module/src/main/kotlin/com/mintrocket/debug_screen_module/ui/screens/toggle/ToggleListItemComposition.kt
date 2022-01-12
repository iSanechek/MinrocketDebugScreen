package com.mintrocket.debug_screen_module.ui.screens.toggle

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ToggleListItemComposition(onClick: () -> Unit) {

    Card(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp).clickable { onClick.invoke() }) {
        
        val l = listOf("Disable", "Enable", "Default")

    }

}