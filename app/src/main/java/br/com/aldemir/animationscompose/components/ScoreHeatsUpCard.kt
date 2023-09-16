package br.com.aldemir.animationscompose.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.aldemir.animationscompose.R
import br.com.aldemir.animationscompose.ui.theme.Gray
import br.com.aldemir.animationscompose.ui.theme.LightBeige
import br.com.aldemir.animationscompose.ui.theme.Orange

@Composable
fun ScoreHeatsUpCard() {
    val infiniteTransition = rememberInfiniteTransition()

    val heartSize1 by infiniteTransition.animateFloat(
        initialValue = -50.0f,
        targetValue = 2.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, delayMillis = 800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    val heartSize2 by infiniteTransition.animateFloat(
        initialValue = 0.0f,
        targetValue = 50f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, delayMillis = 800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .padding(horizontal = 4.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = LightBeige,
            ),
        ) {
            Row(
                modifier = Modifier
                    .padding(start = 12.dp, end = 8.dp)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.75f),
                ) {
                    Row(
                        modifier = Modifier
                            .offset(0.dp, heartSize1.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        PulsatingCircles()
                        Text(
                            modifier = Modifier.padding(start = 4.dp),
                            text = "Atenção ao seu indicador",
                            textAlign = TextAlign.Center,
                            fontSize = 12.sp,
                            color = Orange
                        )
                    }
                    Row(
                        modifier = Modifier.offset(0.dp, heartSize2.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        PulsatingCircles()
                        Text(
                            modifier = Modifier.padding(start = 4.dp),
                            text = "Foque em pedidos coletados e aumente as chances de subir de score",
                            textAlign = TextAlign.Start,
                            fontSize = 12.sp,
                            color = Orange,
                            maxLines = 3,
                            lineHeight = 15.sp
                        )
                    }
                }
                Image(
                    painter = painterResource(R.drawable.arrow_right_24),
                    colorFilter = ColorFilter.tint(color = Gray),
                    contentDescription = "fan",
                    modifier = Modifier
                        .fillMaxWidth(0.25f)
                )
            }
        }

    }

}