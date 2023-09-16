package br.com.aldemir.animationscompose.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimateColorAsState() {
    var isNeedColorChange by remember { mutableStateOf(false) }
    val startColor = Color.Blue
    val endColor = Color.Green

    val backgroundColor by animateColorAsState(
        if (isNeedColorChange) endColor else startColor,
        animationSpec = tween(
            durationMillis = 2000,
            delayMillis = 100,
            easing = LinearEasing
        ), label = ""
    )
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .background(backgroundColor)
        )
        Button(
            onClick = { isNeedColorChange = !isNeedColorChange },
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text(text = "Switch Color")
        }
    }
}