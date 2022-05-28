package ru.itis.socialhelp.features.drawer

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.skydoves.landscapist.glide.GlideImage
import ru.itis.socialhelp.R
import ru.itis.socialhelp.features.common.mvi.AppEvent
import ru.itis.socialhelp.features.common.mvi.AppViewState
import ru.itis.socialhelp.features.drawer.views.DrawerMenuItem
import ru.itis.socialhelp.navigation.Navigation
import ru.itis.socialhelp.ui.theme.AppTheme.appViewModel
import ru.itis.socialhelp.ui.theme.AppTheme.mainNavController
import ru.itis.socialhelp.ui.theme.LocalNavControllerProvider
import ru.itis.socialhelp.ui.theme.LocalViewModelProvider

@Composable
fun DrawerScreen() {
    val navController = mainNavController
    val appViewModel = appViewModel

    val viewState by appViewModel.viewState.collectAsState()

    if (viewState.currentUser != null)
        LoggedDrawer(viewState, navController)
    else
        UnLoggedDrawer(navController)
}

@Composable
private fun LoggedDrawer(
    viewState: AppViewState,
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .weight(.3f)
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        ) {
            GlideImage(
                modifier = Modifier.fillMaxSize(),
                imageModel = viewState.currentUser?.image,
                contentDescription = stringResource(id = R.string.cd_user_image),
                previewPlaceholder = R.drawable.img_default_user_avatar,
                error = ImageBitmap.imageResource(id = R.drawable.img_default_user_avatar),
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color(0xB4000000),
                            ),
                            radius = 700f
                        )
                    )
            )
            Column(
                modifier = Modifier
                    .padding(vertical = 16.dp),
            ) {
                Text(
                    text = viewState.currentUser?.fullName ?: "",
                    modifier = Modifier,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

            }
        }
        Column(
            modifier = Modifier.weight(.7f)
        ) {
            DrawerMenuItem(
                title = stringResource(id = R.string.drawer_my_profile),
                onClick = {
                    navController.navigate("${Navigation.Profile.name}/${viewState.currentUser?.id}")
                }
            )
            DrawerMenuItem(
                title = stringResource(id = R.string.drawer_my_chats),
                onClick = {
                    navController.navigate(Navigation.Chat.name)
                }
            )
            DrawerMenuItem(
                title = stringResource(id = R.string.drawer_my_timetable),
                onClick = {
                    // navigate to settings
                }
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
private fun UnLoggedDrawer(navController: NavController) {
    Column {
        Text(
            text = stringResource(id = R.string.drawer_not_logged_in),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 8.dp)
        )

        DrawerMenuItem(
            title = stringResource(id = R.string.drawer_sign_in),
            onClick = {
                navController.navigate(Navigation.Login.name)
            },
            needWeight = false
        )
        /*DrawerMenuItem(
            title = stringResource(id = R.string.drawer_sign_up),
            onClick = {
                navController.navigate(Navigation.Login.name)
            },
            needWeight = false
        )*/
    }
}
