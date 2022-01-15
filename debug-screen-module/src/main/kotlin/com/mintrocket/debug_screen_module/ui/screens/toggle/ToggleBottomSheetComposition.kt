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
private fun TitleAndStateBox() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, bottom = 2.dp)
    ) {
        Text(
            text = "Feature name",
            style = TextStyle(color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        )
        Text(
            text = "Disable"
        )
    }
}

@Composable
private fun SelectorButton(modifier: Modifier) {
    Box(
        modifier = modifier
            .requiredHeight(80.dp)
            .padding(8.dp)
            .background(color = Color.Gray, shape = RoundedCornerShape(8.dp))
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
private fun SelectorStateBox() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(3) {
            SelectorButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
        }
    }
}

@Composable
private fun LastUpdateInfoBox() {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Text(text = "Last update 23:17 22.10.22")
    }
}

@Composable
fun ToggleBottomSheetComposition(close: () -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        NavigationBox(close)
        TitleAndStateBox()
        Spacer(modifier = Modifier.height(24.dp))
        SelectorStateBox()
        Spacer(modifier = Modifier.height(24.dp))
        LastUpdateInfoBox()
        Spacer(modifier = Modifier.height(64.dp)) // need fix
    }
}

@Preview
@Composable
fun PreviewToggleBottomSheetComposition() {
    ToggleBottomSheetComposition {

    }
}