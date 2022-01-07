package com.mintrocket.debugscreen.data.feature_toggling.repository.state

import com.mintrocket.debugscreen.data.feature_toggling.FeatureEnabledState

actual interface FeaturesStateRepository {
    actual fun getState(key: String): FeatureEnabledState
    actual fun setState(key: String, state: FeatureEnabledState)
}