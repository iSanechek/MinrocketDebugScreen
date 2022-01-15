package com.mintrocket.debug_screen_module.ui.screens.toggle

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mintrocket.debug_screen_module.R
import com.mintrocket.debugscreen.data.feature_toggling.FeatureEnabledState
import com.mintrocket.debugscreen.data.feature_toggling.ItemDebugFeatureToggle

@Composable
private fun NavigationBox(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        IconButton(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(8.dp),
            onClick = onClick
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_close_24),
                contentDescription = "close_btn"
            )
        }
    }
}

@Composable
private fun TitleAndStateBox(model: ItemDebugFeatureToggle?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, bottom = 2.dp)
    ) {
        Text(
            text = model?.name ?: "",
            style = TextStyle(color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        )
        val stateText = if (model?.featureLocalEnabled == true) "Enable" else "Disable"
        val stateColor = if (model?.featureLocalEnabled == true) Color.Green else Color.Red

        Text(
            text = "Local state $stateText", color = stateColor
        )
    }
}

@Composable
private fun SelectorButton(modifier: Modifier, title: String, colorState: Color) {
    Box(
        modifier = modifier
            .requiredHeight(80.dp)
            .padding(8.dp)
            .background(color = colorState, shape = RoundedCornerShape(8.dp))
            .clickable { },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_pest_control_24),
            contentDescription = null,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
private fun SelectorStateBox(model: ItemDebugFeatureToggle?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        SelectorButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            title = "",
            colorState = Color.Green.copy(
                alpha = if (model?.featureState == FeatureEnabledState.ENABLED) 1.0f else .5f
            )
        )
        SelectorButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            title = "",
            colorState = Color.Red.copy(
                alpha = if (model?.featureState == FeatureEnabledState.DISABLED) 1.0f else .5f
            )
        )
        SelectorButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            title = "",
            colorState = Color.Gray.copy(
                alpha = if (model?.featureState == FeatureEnabledState.DEFAULT) 1.0f else .5f
            )
        )
    }
}

@Composable
private fun LastUpdateInfoBox() {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Text(text = "Last update 23:17 22.10.22")
    }
}

@Composable
fun ToggleBottomSheetComposition(model: ItemDebugFeatureToggle?, close: () -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        NavigationBox(close)
        TitleAndStateBox(model)
        Spacer(modifier = Modifier.height(24.dp))
        SelectorStateBox(model)
        Spacer(modifier = Modifier.height(24.dp))
        LastUpdateInfoBox()
        Spacer(modifier = Modifier.height(64.dp)) // need fix
    }
}

@Preview
@Composable
fun PreviewToggleBottomSheetComposition() {
    ToggleBottomSheetComposition(null) {

    }
}