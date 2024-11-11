package com.artinc.memodeck.ui.References

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.artinc.memodeck.R
import com.artinc.memodeck.ui.theme.Purple

@Composable
fun BackgroundUI() {
    // Получаем высоту экрана
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    // Настроим анимацию для движения изображения
    val infiniteTransition = rememberInfiniteTransition(label = "")

    // Используем анимацию для смещения изображения
    val offsetY by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = -screenHeight.value, // Анимация до конца экрана
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 60000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = ""
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple)
    ) {
        // Первый экземпляр узора, двигающийся вверх
        Image(
            painter = painterResource(id = R.drawable.pattern), // Узор
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight)
                .offset(y = offsetY.dp) // Двигаем изображение вверх
        )

        // Второй экземпляр узора, расположенный ниже первого
        Image(
            painter = painterResource(id = R.drawable.pattern),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight)
                .offset(y = (offsetY + screenHeight.value).dp) // Начинается сразу после первого
        )
    }
}