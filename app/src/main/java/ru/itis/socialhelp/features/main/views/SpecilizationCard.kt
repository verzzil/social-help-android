package ru.itis.socialhelp.features.main.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.skydoves.landscapist.glide.GlideImage
import ru.itis.socialhelp.R
import ru.itis.socialhelp.features.common.Shimmer
import ru.itis.socialhelp.features.common.brush
import ru.itis.socialhelp.features.main.models.SpecializationItem
import ru.itis.socialhelp.features.main.models.testSpecialization
import ru.itis.socialhelp.ui.theme.SocialHelpTheme

@Composable
fun SpecializationCard(
    modifier: Modifier = Modifier,
    specialization: SpecializationItem,
) {
    Card(
        modifier = modifier
            .width(120.dp)
            .aspectRatio(26 / 33f)
            .background(Color.White),
        elevation = 4.dp,
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        ) {
            val (img, tTitle) = createRefs()

            GlideImage(
                imageModel = specialization.image,
                previewPlaceholder = R.drawable.lor,
                error = ImageBitmap.imageResource(id = R.drawable.lor),
                modifier = Modifier
                    .size(36.dp)
                    .constrainAs(img) {
                        linkTo(
                            top = parent.top,
                            start = parent.start,
                            end = parent.end,
                            bottom = parent.bottom,
                            verticalBias = .3f
                        )
                    },
            )

            Text(
                text = specialization.problem,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .constrainAs(tTitle) {
                        linkTo(
                            top = parent.top,
                            start = parent.start,
                            end = parent.end,
                            bottom = parent.bottom,
                            verticalBias = .8f
                        )
                    },
            )
        }

    }
}

@Composable
fun SpecializationCardShimmer(modifier: Modifier = Modifier) {
    Shimmer(
        modifier = modifier
            .width(120.dp)
            .aspectRatio(26 / 33f),
        shape = MaterialTheme.shapes.medium,
        elevation = 4.dp
    )
}

@Preview
@Composable
private fun SpecializationItemPreview() {
    SocialHelpTheme {
        SpecializationCard(
            specialization = testSpecialization,
        )
    }
}

@Preview
@Composable
private fun SpecializationItemShimmerPreview() {
    SocialHelpTheme {
        SpecializationCardShimmer()
    }
}