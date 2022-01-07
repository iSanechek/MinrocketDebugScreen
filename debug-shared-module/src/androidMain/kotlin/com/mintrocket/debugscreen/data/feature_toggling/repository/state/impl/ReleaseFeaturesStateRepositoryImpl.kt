package com.mintrocket.debugscreen.data.feature_toggling.repository.state.impl

import com.mintrocket.debugscreen.data.feature_toggling.FeatureEnabledState
import com.mintrocket.debugscreen.data.feature_toggling.repository.state.FeaturesStateRepository

class ReleaseFeaturesStateRepositoryImpl : FeaturesStateRepository {
    override fun getState(key: String): FeatureEnabledState = FeatureEnabledState.DEFAULT

    override fun setState(key: String, state: FeatureEnabledState) {
        // No op
    }
}