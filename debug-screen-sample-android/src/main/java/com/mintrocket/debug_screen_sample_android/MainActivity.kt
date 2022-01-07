package com.mintrocket.debug_screen_sample_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mintrocket.debug_screen_module.DebugScreenHelper
import com.mintrocket.debug_screen_sample_android.ui.theme.DebugScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DebugScreenTheme {
                TestContent {

                }
            }
        }

        DebugScreenHelper(true).showDebugNotificationIfRequired(this)
    }
}

@Composable
private fun TestContent(onClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick) {
            Text(text = "Click")
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    DebugScreenTheme {
//
//    }
//}