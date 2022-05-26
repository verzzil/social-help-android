package ru.itis.socialhelp.features.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.skydoves.landscapist.glide.GlideImage
import ru.itis.socialhelp.R
import ru.itis.socialhelp.ui.theme.LocalViewModelProvider

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel
) {
    val appViewModel = LocalViewModelProvider.current

    val appViewState by appViewModel.viewState.collectAsState()
    val viewState by viewModel.viewState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .weight(.3f)
        ) {
            val (iAvatar, ) = createRefs()

            GlideImage(
                modifier = Modifier
                    .constrainAs(iAvatar) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .size(200.dp),
                imageModel = viewState.user.image,
                error = ImageBitmap.imageResource(id = R.drawable.img_default_user_avatar),
                previewPlaceholder = R.drawable.img_default_user_avatar,
            )
        }

    }
}