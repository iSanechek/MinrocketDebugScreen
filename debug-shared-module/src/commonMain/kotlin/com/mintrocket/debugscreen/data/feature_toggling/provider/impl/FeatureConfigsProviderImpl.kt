package com.mintrocket.debugscreen.data.feature_toggling.provider.impl

import com.mintrocket.debugscreen.data.feature_toggling.features.FeaturesDefaults
import com.mintrocket.debugscreen.data.feature_toggling.features.toggles.LocalFeatureToggle
import com.mintrocket.debugscreen.data.feature_toggling.features.toggles.RemoteFeatureToggle
import com.mintrocket.debugscreen.data.feature_toggling.provider.FeatureConfigsProvider
import com.mintrocket.debugscreen.data.feature_toggling.repository.remote.RemoteFeaturesRepository
import com.mintrocket.debugscreen.data.feature_toggling.repository.state.FeaturesStateRepository

class FeatureConfigsProviderImpl(
    private val featuresDefaults: FeaturesDefaults,
    private val remoteFeaturesRepository: RemoteFeaturesRepository,
    private val featuresStateRepository: FeaturesStateRepository
) : FeatureConfigsProvider {
    override fun isLocalEnabled(toggle: LocalFeatureToggle): Boolean {
        TODO("Not yet implemented")
    }

    override fun isRemoteEnabled(toggle: RemoteFeatureToggle): Boolean {
        TODO("Not yet implemented")
    }
}