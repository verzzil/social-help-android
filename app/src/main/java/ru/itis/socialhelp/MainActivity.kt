package ru.itis.socialhelp

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import ru.itis.socialhelp.features.common.AppViewModel
import ru.itis.socialhelp.features.common.ApplicationScreen
import ru.itis.socialhelp.ui.theme.AppTheme
import ru.itis.socialhelp.ui.theme.AppTheme.colors
import ru.itis.socialhelp.ui.theme.AppTheme.systemUiController
import ru.itis.socialhelp.ui.theme.LocalColorProvider
import ru.itis.socialhelp.ui.theme.LocalSystemUiController
import ru.itis.socialhelp.ui.theme.SocialHelpTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SocialHelpTheme {

                val systemUiController = systemUiController
                val colors = colors

                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = colors.primaryBackground,
                        darkIcons = true
                    )
                }

                ApplicationScreen()
            }
        }
    }
}