package com.mintrocket.debug_screen_module

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.mintrocket.debugscreen.di.initKoin
import org.koin.android.ext.koin.androidContext

abstract class BaseActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initKoin {
            androidContext(this@BaseActivity)
        }
    }
}