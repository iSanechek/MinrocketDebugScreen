package com.mintrocket.debug_screen_module.ui.screens.toggle

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
private fun Toolbar() {
    TopAppBar(title = {
        Text(text = "Toggle")
    })
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun Content(coroutineScope: CoroutineScope, bottomState: ModalBottomSheetState) {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        Toolbar()
    }) {
        val testItems = listOf(1, 2, 3, 4, 5)
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(it), content = {
            items(testItems) {
                ToggleListItemComposition {
                    coroutineScope.launch { bottomState.show() }
                }
            }
        })
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ToggleScreenComposition(paddingValues: PaddingValues) {
    val bottomState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        sheetState = bottomState,
        sheetShape = RoundedCornerShape(16.dp),
        sheetContent = {
            ToggleBottomSheetComposition {
                coroutineScope.launch { bottomState.hide() }
            }
        }) {
        Content(coroutineScope, bottomState)
    }
}