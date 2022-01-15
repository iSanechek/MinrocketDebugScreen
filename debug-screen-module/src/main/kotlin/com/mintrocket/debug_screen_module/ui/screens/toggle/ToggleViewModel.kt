package com.mintrocket.debug_screen_module.ui.screens.toggle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mintrocket.debugscreen.data.feature_toggling.ItemDebugFeatureToggle
import com.mintrocket.debugscreen.data.feature_toggling.provider.FeatureConfigsProvider
import com.mintrocket.debugscreen.data.feature_toggling.repository.state.FeaturesStateRepository
import com.mintrocket.debugscreen.data.feature_toggling.repository.state.TestRepo
import com.mintrocket.debugscreen.data.feature_toggling.repository.state.TestRepoImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ToggleViewModel(
    private val toggleRepo: TestRepoImpl
) : ViewModel() {

    private val _featureToggles = MutableStateFlow(emptyList<ItemDebugFeatureToggle>())
    val featureToggle: StateFlow<List<ItemDebugFeatureToggle>> = _featureToggles

    init {
        viewModelScope.launch {
            _featureToggles.value = toggleRepo.getToggles()
        }
    }

}