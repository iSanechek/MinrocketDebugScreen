package com.mintrocket.debugscreen.di

import com.mintrocket.debugscreen.data.feature_toggling.repository.state.FeaturesStateRepository
import com.mintrocket.debugscreen.data.feature_toggling.repository.state.impl.DebugFeaturesStateRepositoryImpl
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

val DEBUG_FEATURE_CONFIG_REPOSITORY = named("DEBUG_FEATURE_CONFIG_REPOSITORY")

actual fun platformModule(): Module = module {

    single<FeaturesStateRepository>(DEBUG_FEATURE_CONFIG_REPOSITORY) {
        DebugFeaturesStateRepositoryImpl()
    }
}