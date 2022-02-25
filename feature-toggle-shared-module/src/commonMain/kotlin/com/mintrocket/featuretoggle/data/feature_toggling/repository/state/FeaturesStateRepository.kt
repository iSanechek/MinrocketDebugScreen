package com.mintrocket.featuretoggle.data.feature_toggling.repository.state

import com.mintrocket.featuretoggle.data.feature_toggling.FeatureEnabledState

expect interface FeaturesStateRepository {
    fun getState(key: String): FeatureEnabledState
    fun setState(key: String, state: FeatureEnabledState)
}