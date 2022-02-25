package com.mintrocket.featuretoggle.data.feature_toggling.repository.remote

interface RemoteFeaturesRepository {
    suspend fun updateToggles()
    fun isEnabled(key: String): Boolean
}