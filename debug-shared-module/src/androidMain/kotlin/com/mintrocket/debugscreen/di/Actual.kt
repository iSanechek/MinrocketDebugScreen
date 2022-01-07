package com.mintrocket.debugscreen.di

import android.content.Context
import android.content.SharedPreferences
import com.mintrocket.debugscreen.data.feature_toggling.repository.state.FeaturesStateRepository
import com.mintrocket.debugscreen.data.feature_toggling.repository.state.impl.DebugFeaturesStateRepositoryImpl
import com.mintrocket.debugscreen.data.feature_toggling.repository.state.impl.ReleaseFeaturesStateRepositoryImpl
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

val DEBUG_FEATURE_CONFIG_PREFS = named("DEBUG_FEATURE_CONFIG_PREFS")
val DEBUG_FEATURE_CONFIG_REPOSITORY = named("DEBUG_FEATURE_CONFIG_REPOSITORY")
val RELEASE_FEATURE_CONFIG_REPOSITORY = named("RELEASE_FEATURE_CONFIG_REPOSITORY")

actual fun platformModule(): Module = module {

    single<SharedPreferences>(DEBUG_FEATURE_CONFIG_PREFS) {
        get<Context>()
            .applicationContext
            .getSharedPreferences("debug_feature_configs_v2", Context.MODE_PRIVATE)
    }


    single<FeaturesStateRepository>(DEBUG_FEATURE_CONFIG_REPOSITORY) {
        DebugFeaturesStateRepositoryImpl(preferences = get(DEBUG_FEATURE_CONFIG_PREFS))
    }

    single<FeaturesStateRepository>(RELEASE_FEATURE_CONFIG_REPOSITORY) {
        ReleaseFeaturesStateRepositoryImpl()
    }

}