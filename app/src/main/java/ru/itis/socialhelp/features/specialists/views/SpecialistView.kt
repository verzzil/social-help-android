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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.skydoves.landscapist.glide.GlideImage
import ru.itis.socialhelp.R
import ru.itis.socialhelp.features.specialists.models.SpecialistItem
import ru.itis.socialhelp.ui.theme.AppTheme.mainNavController

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
                        width = Dimension.fillToConstraints
                        top.linkTo(parent.top)
                        start.linkTo(parent.start, margin = 8.dp)
                        end.linkTo(iAvatar.start)
                    },
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
            )

            GlideImage(
                imageModel = specialist.image,
                error = ImageBitmap.imageResource(id = R.drawable.img_default_user_avatar),
                modifier = Modifier
                    .constrainAs(iAvatar) {
                        end.linkTo(parent.end, margin = 16.dp)
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
                        width = Dimension.fillToConstraints
                        start.linkTo(tFullName.start)
                        top.linkTo(tFullName.bottom)
                        end.linkTo(iAvatar.start)
                    }
            )

            createVerticalChain(tFullName, tExperience, chainStyle = ChainStyle.Packed)
        }
    }
}


