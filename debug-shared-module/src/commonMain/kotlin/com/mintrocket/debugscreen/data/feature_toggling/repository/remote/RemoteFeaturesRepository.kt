package com.mintrocket.debugscreen.data.feature_toggling.repository.remote

interface RemoteFeaturesRepository {
    suspend fun updateToggles()
    fun isEnabled(key: String): Boolean
}