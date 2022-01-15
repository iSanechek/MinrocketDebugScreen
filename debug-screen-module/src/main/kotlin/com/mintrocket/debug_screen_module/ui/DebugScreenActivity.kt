package com.mintrocket.debug_screen_module.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import com.github.terrakok.modo.Modo
import com.github.terrakok.modo.android.compose.ComposeRender
import com.github.terrakok.modo.android.compose.init
import com.github.terrakok.modo.android.compose.saveState
import com.github.terrakok.modo.back
import com.mintrocket.debug_screen_module.ui.base.BaseActivity
import com.mintrocket.debug_screen_module.ui.screens.main.MainScreenComposition
import com.mintrocket.debug_screen_module.ui.screens.navigation.MainScreen
import com.mintrocket.debug_screen_module.ui.theme.ScreenTheme
import org.koin.android.ext.android.inject

class DebugScreenActivity : BaseActivity() {

    private val modo: Modo by inject()
    private val render = ComposeRender(this)

    companion object {
        fun  newIntent(context: Context) = Intent(context, DebugScreenActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        modo.init(savedInstanceState, MainScreen())
        setContent {
            ScreenTheme { render.Content() }
        }
    }

    override fun onResume() {
        super.onResume()
        modo.render = render
    }

    override fun onPause() {
        super.onPause()
        modo.render = null
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        modo.saveState(outState)
    }

    override fun onBackPressed() {
        modo.back()
    }
}