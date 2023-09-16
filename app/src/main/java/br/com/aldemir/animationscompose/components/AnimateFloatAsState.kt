package br.com.aldemir.animationscompose.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.aldemir.animationscompose.R

@Composable
fun AnimateAsFloatContent() {
    var isRotated by rememberSaveable { mutableStateOf(false) }
    val rotationAngle by animateFloatAsState(
        targetValue = if (isRotated) 360F else 0f,
        animationSpec = tween(durationMillis = 2500), label = ""
    )
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(R.drawable.fan2),
            colorFilter = ColorFilter.tint(color = Color.Black),
            contentDescription = "fan",
            modifier = Modifier
                .rotate(rotationAngle)
                .size(150.dp)
        )

        Button(
            onClick = { isRotated = !isRotated },
            modifier = Modifier
                .padding(top = 50.dp)
                .width(200.dp)
        ) {
            Text(text = "Rotate Fan")
        }
    }
}