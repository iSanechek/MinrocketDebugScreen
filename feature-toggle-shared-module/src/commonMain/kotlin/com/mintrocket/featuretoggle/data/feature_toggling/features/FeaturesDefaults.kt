package com.mintrocket.featuretoggle.data.feature_toggling.features

import com.mintrocket.featuretoggle.data.feature_toggling.features.toggles.LocalFeatureToggle
import com.mintrocket.featuretoggle.data.feature_toggling.features.toggles.RemoteFeatureToggle

class FeaturesDefaults {

    fun getLocalDefault(toggle: LocalFeatureToggle): Boolean = when (toggle) {
        LocalFeatureToggle.REMOTE_CONFIG -> false
        LocalFeatureToggle.IN_APP_UPDATE -> false
        LocalFeatureToggle.IN_APP_UPDATE_INSTALL_IMMEDIATE -> false
        LocalFeatureToggle.IMAGE_ONE -> false
        LocalFeatureToggle.SHOW_BUTTON -> false
    }

    @Suppress("ComplexMethod")
    fun getRemoteDefault(toggle: RemoteFeatureToggle): Boolean = when (toggle) {
        RemoteFeatureToggle.CORE_ENABLED -> true
    }
}