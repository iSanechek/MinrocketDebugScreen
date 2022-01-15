package com.mintrocket.debug_screen_module.ui.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.github.terrakok.modo.Modo
import com.mintrocket.debug_screen_module.di.appModule
import com.mintrocket.debugscreen.di.initKoin
import org.koin.android.ext.koin.androidContext

abstract class BaseActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initKoin {
            androidContext(this@BaseActivity)
            modules(appModule)
        }
    }
}