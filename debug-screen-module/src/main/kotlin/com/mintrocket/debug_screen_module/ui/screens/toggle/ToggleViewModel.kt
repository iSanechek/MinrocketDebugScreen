package com.mintrocket.debug_screen_module.ui.screens.toggle

import androidx.lifecycle.ViewModel
import com.mintrocket.debugscreen.data.feature_toggling.provider.FeatureConfigsProvider
import com.mintrocket.debugscreen.data.feature_toggling.repository.state.FeaturesStateRepository

class ToggleViewModel(
    private val featureEnabledState: FeaturesStateRepository,
    private val conf: FeatureConfigsProvider
) : ViewModel() {


}