package com.mintrocket.debug_screen_module

import android.content.Context
import com.mintrocket.debug_screen_module.di.appModule
import com.mintrocket.debug_screen_module.helpers.DebugScreenHelper
import com.mintrocket.featuretoggle.data.feature_toggling.repository.remote.RemoteFeaturesRepository
import com.mintrocket.featuretoggle.di.initKoin
import org.koin.core.module.Module

@DslMarker
annotation class DebugScreenBuilder

@DebugScreenBuilder
class LibBuilder {

    private var ctx: Context? = null
    private var mModule: Module? = null
    private var netw: RemoteFeaturesRepository? = null

    fun libContext(context: Context) {
        ctx = context
    }

//    fun koinModule(module: Module) {
//        mModule = module
//    }

    init {
//        requireNotNull(ctx) { "Context not be null" }
//        requireNotNull(mModule) { "Debug not null" }

        initKoin {
            modules(appModule)
//            Module().single<RemoteFeaturesRepository> {
//
//            }
        }

        DebugScreenHelper(true).showDebugNotificationIfRequired(ctx!!)
    }

}


object initDebugScreen {
    operator fun invoke(init: LibBuilder.() -> Unit) = LibBuilder().init()
}