package com.mintrocket.debug_screen_module.di

import com.github.terrakok.modo.Modo
import com.github.terrakok.modo.android.compose.AppReducer
import com.github.terrakok.modo.android.compose.LogReducer
import com.mintrocket.debug_screen_module.BuildConfig
import com.mintrocket.debug_screen_module.ui.screens.main.MainViewModel
import com.mintrocket.debug_screen_module.ui.screens.toggle.ToggleViewModel
import com.mintrocket.debugscreen.data.feature_toggling.repository.state.TestRepoImpl
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        val ctx = androidContext().applicationContext
        val reducer = if (BuildConfig.DEBUG) LogReducer(AppReducer(ctx)) else AppReducer(ctx)
        Modo(reducer)
    }

    viewModel {
        MainViewModel(navigator = get())
    }

    single {
        TestRepoImpl()
    }

    viewModel {
        ToggleViewModel(get())
    }
}