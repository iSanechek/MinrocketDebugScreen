package com.mintrocket.debug_screen_module

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mintrocket.debugscreen.data.feature_toggling.repository.state.FeaturesStateRepository
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

class DebugScreenActivity : BaseActivity() {

    companion object {
        fun  newIntent(context: Context) = Intent(context, DebugScreenActivity::class.java)
    }

    private val re: FeaturesStateRepository by inject(named("DebugFeaturesStateRepositoryImpl"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestUi()
        }

        Log.d("DEBUG", "onCreate: ${re.getState("rr")}")
    }
}

@Composable
private fun TestUi() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Huyak")
    }
}