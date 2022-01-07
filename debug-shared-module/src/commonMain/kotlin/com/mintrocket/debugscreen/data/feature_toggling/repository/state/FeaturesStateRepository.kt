package com.mintrocket.debugscreen.data.feature_toggling.repository.state

import com.mintrocket.debugscreen.data.feature_toggling.FeatureEnabledState

expect interface FeaturesStateRepository {
    fun getState(key: String): FeatureEnabledState
    fun setState(key: String, state: FeatureEnabledState)
}