package ru.itis.socialhelp.features.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.delay
import ru.itis.socialhelp.R
import ru.itis.socialhelp.navigation.Navigation
import ru.itis.socialhelp.ui.theme.LocalNavControllerProvider

@Composable
fun SplashScreen() {
    val navController = LocalNavControllerProvider.current

    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(key1 = Unit) {
        scale.animateTo(
            targetValue = 0.7f,
            // tween Animation
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                }))
        delay(3000L)
        navController.navigate(Navigation.Main.name)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.scale(scale.value),
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = stringResource(id = R.string.cd_logo)
        )
    }


    LaunchedEffect(key1 = Unit, block = {
        delay(1000)

        navController.popBackStack()
        navController.navigate(Navigation.Main.name)
    })
}