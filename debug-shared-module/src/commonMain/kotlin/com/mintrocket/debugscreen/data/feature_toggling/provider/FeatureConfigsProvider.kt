package com.mintrocket.debugscreen.data.feature_toggling.provider

import com.mintrocket.debugscreen.data.feature_toggling.features.toggles.LocalFeatureToggle
import com.mintrocket.debugscreen.data.feature_toggling.features.toggles.RemoteFeatureToggle

interface FeatureConfigsProvider {
    fun isLocalEnabled(toggle: LocalFeatureToggle): Boolean
    fun isRemoteEnabled(toggle: RemoteFeatureToggle): Boolean
}