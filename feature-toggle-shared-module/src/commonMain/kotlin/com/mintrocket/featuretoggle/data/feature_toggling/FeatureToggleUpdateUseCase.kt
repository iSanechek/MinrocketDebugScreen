package com.mintrocket.featuretoggle.data.feature_toggling

import com.mintrocket.featuretoggle.data.feature_toggling.repository.remote.RemoteFeaturesRepository

class FeatureToggleUpdateUseCase(
    private val remoteFeaturesRepository: RemoteFeaturesRepository,
    private val remoteConfigEnabled: () -> Boolean
) {

    suspend fun updateFeatureToggles() {
        if (remoteConfigEnabled.invoke()) {
            remoteFeaturesRepository.updateToggles()
        }
    }
}