package ru.itis.socialhelp.features.specialists.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.skydoves.landscapist.glide.GlideImage
import ru.itis.socialhelp.R
import ru.itis.socialhelp.features.main.models.CategoryItem
import ru.itis.socialhelp.features.specialists.models.SpecialistItem

@Composable
fun SpecialistView(
    modifier: Modifier = Modifier,
    specialist: SpecialistItem
) {
    Card(
        modifier = modifier,
        elevation = 4.dp,
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (tFullName, iAvatar, tExperience) = createRefs()

            Text(
                text = specialist.fullName,
                modifier = Modifier
                    .constrainAs(tFullName) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(iAvatar.start)
                    }
            )

            GlideImage(
                imageModel = specialist.image,
                error = ImageBitmap.imageResource(id = R.drawable.img_default_user_avatar),
                modifier = Modifier
                    .constrainAs(iAvatar) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                    .size(60.dp)
                    .clip(RoundedCornerShape(50))
            )

            Text(
                text = "Стаж ${specialist.experience} лет",
                style = TextStyle(color = Color.Gray, fontSize = 14.sp),
                modifier = Modifier
                    .constrainAs(tExperience) {
                        start.linkTo(tFullName.start)
                        top.linkTo(tFullName.bottom)
                        end.linkTo(iAvatar.start)
                    }
            )
        }
    }
}


