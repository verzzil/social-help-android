package ru.itis.socialhelp.features.drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
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
import ru.itis.socialhelp.features.drawer.views.DrawerMenuItem
import ru.itis.socialhelp.navigation.Navigation
import ru.itis.socialhelp.ui.theme.LocalNavControllerProvider
import ru.itis.socialhelp.ui.theme.LocalViewModelProvider

@Composable
fun DrawerScreen() {
    val navController = LocalNavControllerProvider.current
    val appViewModel = LocalViewModelProvider.current

    val viewState by appViewModel.viewState.collectAsState()

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
                    navController.navigate(Navigation.Profile.name)
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
            DrawerMenuItem(
                title = stringResource(id = R.string.drawer_settings),
                onClick = {
                    // navigate to settings
                }
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}