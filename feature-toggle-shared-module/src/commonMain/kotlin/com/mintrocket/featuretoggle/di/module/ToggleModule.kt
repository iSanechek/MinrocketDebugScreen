package com.mintrocket.featuretoggle.di.module

import com.mintrocket.featuretoggle.data.feature_toggling.features.FeaturesDefaults
import com.mintrocket.featuretoggle.data.feature_toggling.features.LocalFeatures
import com.mintrocket.featuretoggle.data.feature_toggling.features.RemoteFeatures
import com.mintrocket.featuretoggle.data.feature_toggling.provider.FeatureConfigsProvider
import com.mintrocket.featuretoggle.data.feature_toggling.provider.impl.FeatureConfigsProviderImpl
import com.mintrocket.featuretoggle.data.feature_toggling.repository.state.FeaturesStateRepository
import com.mintrocket.featuretoggle.data.feature_toggling.repository.state.impl.ReleaseFeaturesStateRepositoryImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

val RELEASE_FEATURE_CONFIG_REPOSITORY = named("RELEASE_FEATURE_CONFIG_REPOSITORY")

val toggleModule = module {

    single { FeaturesDefaults() }
    single { LocalFeatures(get()) }
    single { RemoteFeatures(get()) }

    single<FeatureConfigsProvider> { FeatureConfigsProviderImpl(get(), get(), get(named("DEBUG_FEATURE_CONFIG_REPOSITORY"))) }

//    single<RemoteFeaturesRepository> {
//        RemoteFeaturesRepositoryImpl(get())
//    }

    single<FeaturesStateRepository>(RELEASE_FEATURE_CONFIG_REPOSITORY) {
        ReleaseFeaturesStateRepositoryImpl()
    }
}