package com.artinc.memodeck.ui.References

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artinc.memodeck.ui.theme.Orange
import com.artinc.memodeck.ui.theme.Purple

@Preview
@Composable
fun CardUI() {
    var flipped by remember { mutableStateOf(true) }
    val newRotationY by animateFloatAsState(if (flipped) 0f else 180f)

    // Создаем бесконечную анимацию
    val infiniteTransition = rememberInfiniteTransition()

    // Анимируем вертикальное смещение
    val translateY by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = -15f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Card(
        modifier = Modifier
            .size(width = 300.dp, height = 210.dp)
            .graphicsLayer {
                rotationY = newRotationY
                cameraDistance = 12 * density
            }
            .offset(y = translateY.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        border = BorderStroke(4.dp, Color.White),
        onClick = {
            flipped = !flipped
        }
    ) {
        Box(
            modifier = Modifier
                .background(Orange)
                .fillMaxSize()
                .padding(10.dp)
        ) {
            if (newRotationY <= 90f) {
                Text(
                    text = "Question?",
                    fontSize = 25.sp,
                    color = Purple,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                Text(
                    text = "Answer",
                    fontSize = 25.sp,
                    color = Purple,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .graphicsLayer { rotationY = 180f }
                )
            }
        }
    }
}
