package ru.itis.socialhelp.features.main.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import ru.itis.socialhelp.features.main.models.CategoryItem
import ru.itis.socialhelp.features.main.models.testSpecialist
import com.skydoves.landscapist.glide.GlideImage
import ru.itis.socialhelp.R
import ru.itis.socialhelp.features.common.Shimmer
import ru.itis.socialhelp.ui.theme.SocialHelpTheme

@Composable
fun CategoryCard(
    modifier: Modifier = Modifier,
    specialist: CategoryItem
) {
    Card(
        modifier = modifier,
        elevation = 4.dp,
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (iAvatar, tName, tDesc) = createRefs()

            GlideImage(
                imageModel = specialist.image,
                previewPlaceholder = R.drawable.img_default_user_avatar,
                contentDescription = stringResource(id = R.string.cd_category_item),
                error = ImageBitmap.imageResource(id = R.drawable.img_default_user_avatar),
                modifier = Modifier
                    .constrainAs(iAvatar) {
                        start.linkTo(parent.start, margin = 12.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                    .clip(RoundedCornerShape(50))
                    .size(80.dp)
            )

            Text(
                text = specialist.title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(tName) {
                        top.linkTo(iAvatar.top)
                        start.linkTo(iAvatar.end, margin = 8.dp)
                    }
            )

            Text(
                text = specialist.description,
                modifier = Modifier
                    .constrainAs(tDesc) {
                        start.linkTo(tName.start)
                        top.linkTo(tName.bottom)
                        bottom.linkTo(iAvatar.bottom)
                    }
            )
        }
    }
}

@Composable
fun CategoryCardShimmer(modifier: Modifier = Modifier) {
    Shimmer(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        elevation = 4.dp
    )
}

@Preview
@Composable
private fun DoctorCardPreview() {
    SocialHelpTheme {
        CategoryCard(
            specialist = testSpecialist,
            modifier = Modifier
                .height(140.dp)
                .background(Color.White)
        )
    }
}