package com.mintrocket.debug_screen_module.ui.screens.toggle

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ToggleScreenComposition() {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Expanded)
    )
    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            ToggleBottomSheetComposition {
                coroutineScope.launch { bottomSheetScaffoldState.bottomSheetState.collapse() }
            }
        }) {
        val testItems = listOf(1, 2, 3, 4, 5)
        LazyColumn(modifier = Modifier.fillMaxSize(), content = {
            items(testItems) {
                ToggleListItemComposition()
            }
        })
    }
}