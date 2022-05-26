package ru.itis.socialhelp.features.common

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun brush(): Brush {
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = .6f),
        Color.LightGray.copy(alpha = .2f),
        Color.LightGray.copy(alpha = .6f),
    )

    val transition = rememberInfiniteTransition()
    val translateAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 800,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    return Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnim.value, y = translateAnim.value)
    )
}

@Composable
fun Shimmer(modifier: Modifier = Modifier, shape: Shape = RectangleShape, elevation: Dp = 4.dp) {
    Surface(
        modifier = modifier,
        shape = shape,
        elevation = elevation,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = brush()
                )
        )
    }
}
