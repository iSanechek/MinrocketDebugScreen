package com.mintrocket.featuretoggle.data.feature_toggling

data class ItemDebugFeatureToggle(
    val name: String,
    val key: String,
    val featureState: FeatureEnabledState,
    val featureLocalEnabled: Boolean
)
