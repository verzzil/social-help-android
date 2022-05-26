package ru.itis.socialhelp

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import ru.itis.socialhelp.features.common.AppViewModel
import ru.itis.socialhelp.features.common.ApplicationScreen
import ru.itis.socialhelp.ui.theme.AppTheme
import ru.itis.socialhelp.ui.theme.LocalColorProvider
import ru.itis.socialhelp.ui.theme.SocialHelpTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SocialHelpTheme {

                val systemUiController = rememberSystemUiController()

                // Set status bar color
                val primaryBackground = LocalColorProvider.current.primaryBackground
                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = primaryBackground,
                        darkIcons = true
                    )
                }

                ApplicationScreen()
            }
        }
    }
}