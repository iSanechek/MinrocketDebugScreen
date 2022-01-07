package com.mintrocket.debugscreen.di.module

import com.mintrocket.debugscreen.data.feature_toggling.features.FeaturesDefaults
import com.mintrocket.debugscreen.data.feature_toggling.features.LocalFeatures
import com.mintrocket.debugscreen.data.feature_toggling.features.RemoteFeatures
import com.mintrocket.debugscreen.data.feature_toggling.provider.FeatureConfigsProvider
import com.mintrocket.debugscreen.data.feature_toggling.provider.impl.FeatureConfigsProviderImpl
import com.mintrocket.debugscreen.data.feature_toggling.repository.remote.RemoteFeaturesRepository
import com.mintrocket.debugscreen.data.feature_toggling.repository.remote.impl.RemoteFeaturesRepositoryImpl
import org.koin.dsl.module

val toggleModule = module {

    single { FeaturesDefaults() }
    single { LocalFeatures(get()) }
    single { RemoteFeatures(get()) }

    single<FeatureConfigsProvider> { FeatureConfigsProviderImpl(get(), get(), get()) }

    single<RemoteFeaturesRepository> {
        RemoteFeaturesRepositoryImpl(get())
    }

}