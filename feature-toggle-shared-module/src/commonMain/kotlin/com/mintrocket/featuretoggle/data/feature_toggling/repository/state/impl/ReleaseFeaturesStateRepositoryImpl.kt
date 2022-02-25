package com.mintrocket.featuretoggle.data.feature_toggling.repository.state.impl

import com.mintrocket.featuretoggle.data.feature_toggling.FeatureEnabledState
import com.mintrocket.featuretoggle.data.feature_toggling.repository.state.FeaturesStateRepository

class ReleaseFeaturesStateRepositoryImpl : FeaturesStateRepository {
    override fun getState(key: String): FeatureEnabledState = FeatureEnabledState.DEFAULT

    override fun setState(key: String, state: FeatureEnabledState) {
        // no op
    }
}