package com.mintrocket.debug_screen_module.ui.screens.toggle

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
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
fun ToggleScreenComposition(paddingValues: PaddingValues) {
    val vm = getViewModel<ToggleViewModel>()
    val bottomState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()

    // re-write later
    var model by remember {
        mutableStateOf<ItemDebugFeatureToggle?>(null)
    }

    ModalBottomSheetLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        sheetState = bottomState,
        sheetShape = RoundedCornerShape(16.dp),
        sheetContent = {
            ToggleBottomSheetComposition(model) {
                coroutineScope.launch { bottomState.hide() }
            }
        }) {
        val data = vm.featureToggle.collectAsState()
        Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
            Toolbar()
        }) {
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(it), content = {
                items(data.value) { feature ->
                    ToggleListItemComposition(feature) {
                        model = feature
                        coroutineScope.launch { bottomState.show() }
                    }
                }
            })
        }
    }
}