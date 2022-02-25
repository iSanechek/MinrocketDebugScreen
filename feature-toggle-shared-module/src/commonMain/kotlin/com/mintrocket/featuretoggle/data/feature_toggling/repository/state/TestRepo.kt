package com.mintrocket.featuretoggle.data.feature_toggling.repository.state

import com.mintrocket.featuretoggle.data.feature_toggling.FeatureEnabledState
import com.mintrocket.featuretoggle.data.feature_toggling.ItemDebugFeatureToggle
import com.mintrocket.featuretoggle.data.feature_toggling.features.toggles.LocalFeatureToggle
import com.mintrocket.featuretoggle.data.feature_toggling.features.toggles.RemoteFeatureToggle
import com.mintrocket.featuretoggle.data.feature_toggling.provider.FeatureConfigsProvider
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class TestRepoImpl(
) : KoinComponent {

    private val featureConfigsProvider: FeatureConfigsProvider by inject()
//    private val localFeatureController: FeaturesStateRepository by inject(named(""))
    suspend fun getToggles(): List<ItemDebugFeatureToggle> {
        val localFeatures = LocalFeatureToggle.values().map {
            ItemDebugFeatureToggle(
                it.title,
                it.key,
                FeatureEnabledState.DEFAULT,
                featureConfigsProvider.isLocalEnabled(it)
            )
        }

        val remoteFeatures = RemoteFeatureToggle.values().map {
            ItemDebugFeatureToggle(
                it.key,
                it.key,
                FeatureEnabledState.DEFAULT,
                featureConfigsProvider.isRemoteEnabled(it)
            )
        }

        return mutableListOf<ItemDebugFeatureToggle>().apply {
            addAll(localFeatures)
            addAll(remoteFeatures)
        }
    }
}