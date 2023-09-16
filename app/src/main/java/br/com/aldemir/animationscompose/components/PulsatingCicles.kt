package br.com.aldemir.animationscompose.components

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.aldemir.animationscompose.R
import br.com.aldemir.animationscompose.ui.theme.LightBeige
import br.com.aldemir.animationscompose.ui.theme.Orange

@Composable
fun PulsatingCircles() {
    Column {
        val infiniteTransition = rememberInfiniteTransition()
        val size by infiniteTransition.animateValue(
            initialValue = 35.dp,
            targetValue = 25.dp,
            Dp.VectorConverter,
            animationSpec = infiniteRepeatable(
                animation = tween(300, easing = FastOutLinearInEasing),
                repeatMode = RepeatMode.Reverse
            ), label = ""
        )
        val smallCircle by infiniteTransition.animateValue(
            initialValue = 20.dp,
            targetValue = 30.dp,
            Dp.VectorConverter,
            animationSpec = infiniteRepeatable(
                animation = tween(1000, easing = FastOutLinearInEasing),
                repeatMode = RepeatMode.Reverse
            ), label = ""
        )
        Box(
            modifier = Modifier
                .width(40.dp)
                .height(40.dp),
            contentAlignment = Alignment.Center
        ) {
            SimpleCircleShape(
                size = size,
                color = Orange.copy(0.25f)
            )
            SimpleCircleShape(
                size = smallCircle,
                color = LightBeige.copy(alpha = 0.25f)
            )
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.alert_error_24),
                        colorFilter = ColorFilter.tint(color = Orange),
                        contentDescription = "fan",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SimpleCircleShape(
    size: Dp,
    color: Color = Color.White,
    borderWidth: Dp = 0.dp,
    borderColor: Color = Color.LightGray.copy(alpha = 0.0f)
) {
    Column(
        modifier = Modifier
            .wrapContentSize(Alignment.Center)
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .clip(CircleShape)
                .background(
                    color
                )
                .border(borderWidth, borderColor)
        )
    }
}