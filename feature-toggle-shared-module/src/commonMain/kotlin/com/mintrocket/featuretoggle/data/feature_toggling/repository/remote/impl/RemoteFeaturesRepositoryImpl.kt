package com.mintrocket.featuretoggle.data.feature_toggling.repository.remote.impl

import com.mintrocket.featuretoggle.data.feature_toggling.features.FeaturesDefaults
import com.mintrocket.featuretoggle.data.feature_toggling.features.toggles.RemoteFeatureToggle
import com.mintrocket.featuretoggle.data.feature_toggling.repository.remote.RemoteFeaturesRepository

class RemoteFeaturesRepositoryImpl(
    private val featuresDefaults: FeaturesDefaults
) : RemoteFeaturesRepository {

    private val currentToggles = mutableListOf<String>()

    init {
        currentToggles.addAll(getFakeToggles().map { it.key })
    }

    override suspend fun updateToggles() {
        currentToggles.clear()
        currentToggles.addAll(getFakeToggles().map { it.key })
    }

    override fun isEnabled(key: String): Boolean {
        return currentToggles.contains(key)
    }

    // todo add api when it will be ready
    private fun getFakeToggles() = RemoteFeatureToggle.values()
        .filter { featuresDefaults.getRemoteDefault(it) }
}