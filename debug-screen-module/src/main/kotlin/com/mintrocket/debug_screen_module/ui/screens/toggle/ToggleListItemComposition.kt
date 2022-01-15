package com.mintrocket.debug_screen_module.ui.screens.toggle

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
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
private fun IconStateBox(state: FeatureEnabledState) {
    Card(
        modifier = Modifier
            .size(60.dp),
        backgroundColor = Color.Green,
        shape = RoundedCornerShape(16.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_pest_control_24),
            contentDescription = null,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
private fun TitleAndSubtitleBox(modifier: Modifier, name: String, enable: Boolean) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 16.dp, top = 12.dp, bottom = 12.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = name,
            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        )
        Text(text = "Disable $enable")
    }
}

@Composable
fun ToggleListItemComposition(featureToggle: ItemDebugFeatureToggle, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(90.dp)
            .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 2.dp)
            .clickable { onClick.invoke() },
        elevation = 2.dp
    ) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            TitleAndSubtitleBox(
                modifier = Modifier.weight(1f),
                name = featureToggle.name,
                enable = featureToggle.featureLocalEnabled
            )
            Spacer(modifier = Modifier.width(16.dp))
            IconStateBox(featureToggle.featureState)
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

@Preview
@Composable
fun PreviewToggleListItemComposition() {
    ToggleListItemComposition(
        ItemDebugFeatureToggle(
            name = "Boom",
            key = "boom",
            featureLocalEnabled = true,
            featureState = FeatureEnabledState.DEFAULT
        )
    ) {
        // no op
    }
}