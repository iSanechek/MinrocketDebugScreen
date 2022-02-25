package com.mintrocket.featuretoggle.di

import android.content.Context
import android.content.SharedPreferences
import com.mintrocket.featuretoggle.data.feature_toggling.repository.state.FeaturesStateRepository
import com.mintrocket.featuretoggle.data.feature_toggling.repository.state.impl.DebugFeaturesStateRepositoryImpl
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

val DEBUG_FEATURE_CONFIG_PREFS = named("DEBUG_FEATURE_CONFIG_PREFS")
val DEBUG_FEATURE_CONFIG_REPOSITORY = named("DEBUG_FEATURE_CONFIG_REPOSITORY")

actual fun platformModule(): Module = module {

    single<SharedPreferences>(DEBUG_FEATURE_CONFIG_PREFS) {
        get<Context>()
            .applicationContext
            .getSharedPreferences("debug_feature_configs_v2", Context.MODE_PRIVATE)
    }


    single<FeaturesStateRepository>(DEBUG_FEATURE_CONFIG_REPOSITORY) {
        DebugFeaturesStateRepositoryImpl(preferences = get(DEBUG_FEATURE_CONFIG_PREFS))
    }

}