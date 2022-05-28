package ru.itis.socialhelp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ru.itis.socialhelp.features.common.AppViewModel

@Composable
fun SocialHelpTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val navController = rememberNavController()
    val systemUiController = rememberSystemUiController()

    CompositionLocalProvider(
        LocalColorProvider provides lightPalette,
        LocalNavControllerProvider provides navController,
        LocalViewModelProvider provides hiltViewModel<AppViewModel>(),
        LocalSystemUiController provides systemUiController,
        content = content
    )
}

object AppTheme {

    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalColorProvider.current

    val appViewModel: AppViewModel
        @Composable
        @ReadOnlyComposable
        get() = LocalViewModelProvider.current

    val mainNavController: NavController
        @Composable
        @ReadOnlyComposable
        get() = LocalNavControllerProvider.current

    val systemUiController: SystemUiController
        @Composable
        @ReadOnlyComposable
        get() = LocalSystemUiController.current
}

val LocalColorProvider = staticCompositionLocalOf<Colors> {
    error("No default colors provides")
}

val LocalNavControllerProvider = staticCompositionLocalOf<NavController> {
    error("No default navController provides")
}

val LocalViewModelProvider = staticCompositionLocalOf<AppViewModel> {
    error("No AppViewModel provides")
}

val LocalSystemUiController = staticCompositionLocalOf<SystemUiController> {
    error("No SystemUiController provides")
}
