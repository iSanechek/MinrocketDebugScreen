package com.mintrocket.featuretoggle.data.feature_toggling.repository.state.impl

import com.mintrocket.featuretoggle.data.feature_toggling.FeatureEnabledState
import com.mintrocket.featuretoggle.data.feature_toggling.repository.state.FeaturesStateRepository
import platform.Foundation.NSUserDefaults

class DebugFeaturesStateRepositoryImpl : FeaturesStateRepository {

    companion object {
        private const val PREF_NAME = "Boom"
    }

    override fun getState(key: String): FeatureEnabledState {
        val ordinal = get(key, FeatureEnabledState.DEFAULT.ordinal)
        return FeatureEnabledState.values().getOrNull(ordinal) ?: FeatureEnabledState.DEFAULT
    }

    override fun setState(key: String, state: FeatureEnabledState) {
        put(key, state.ordinal)
    }


    private fun get(key: String, default: Int): Int {
        NSUserDefaults.standardUserDefaults.dictionaryForKey(PREF_NAME)?.let {
            if (it.keys.contains(key)) {
                return it[key] as Int
            }
        }
        return default
    }

    @Suppress("UNCHECKED_CAST")
    private fun put(key: String, value: Int) {
        val targetMap: MutableMap<String, Any?> =
            NSUserDefaults.standardUserDefaults.dictionaryForKey(
                PREF_NAME
            )?.toMutableMap() as? MutableMap<String, Any?>
                ?: mutableMapOf()
        targetMap[key] = value
        NSUserDefaults.standardUserDefaults.setObject(targetMap, PREF_NAME)
    }
}