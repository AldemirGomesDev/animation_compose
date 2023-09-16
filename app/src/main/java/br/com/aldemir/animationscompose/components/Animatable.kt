package br.com.aldemir.animationscompose.components

import androidx.compose.animation.Animatable
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimatableSample() {
    var isAnimated by remember { mutableStateOf(false) }

    val color = remember { Animatable(Color.DarkGray) }

    // animate to green/red based on `button click`
    LaunchedEffect(isAnimated) {
        color.animateTo(if (isAnimated) Color.Green else Color.Red, animationSpec = tween(2000))
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .background(color.value)
        )
        Button(
            onClick = { isAnimated = !isAnimated },
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text(text = "Animate Color")
        }
    }

}