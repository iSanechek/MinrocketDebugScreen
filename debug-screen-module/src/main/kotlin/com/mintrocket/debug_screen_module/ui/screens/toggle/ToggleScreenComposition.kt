package com.mintrocket.debug_screen_module.ui.screens.toggle

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mintrocket.debugscreen.data.feature_toggling.ItemDebugFeatureToggle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Composable
private fun Toolbar() {
    TopAppBar(title = {
        Text(text = "Toggle")
    })
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun Content(toggles: StateFlow<List<ItemDebugFeatureToggle>>, coroutineScope: CoroutineScope, bottomState: ModalBottomSheetState) {
    val data = toggles.collectAsState()
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        Toolbar()
    }) {
        val testItems = listOf(1, 2, 3, 4, 5)
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(it), content = {
            items(data.value) { feature ->
                ToggleListItemComposition(feature) {
                    coroutineScope.launch { bottomState.show() }
                }
            }
        })
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ToggleScreenComposition(paddingValues: PaddingValues) {
    val vm = getViewModel<ToggleViewModel>()
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
        Content(vm.featureToggle, coroutineScope, bottomState)
    }
}