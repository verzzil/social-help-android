package ru.itis.socialhelp.features.main.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import ru.itis.socialhelp.R
import ru.itis.socialhelp.features.main.models.SpecializationItem
import ru.itis.socialhelp.features.main.models.testSpecialist
import ru.itis.socialhelp.features.common.Shimmer
import ru.itis.socialhelp.ui.theme.SocialHelpTheme

@Composable
fun SpecializationCard(
    modifier: Modifier = Modifier,
    specialist: SpecializationItem
) {
    Card(
        modifier = modifier,
        elevation = 4.dp,
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (iBack, tName) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.specialization_back),
                contentDescription = "",
                modifier = Modifier
                    .constrainAs(iBack) {
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                        linkTo(parent.start, parent.top, parent.end, parent.bottom)
                    }
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Text(
                text = specialist.title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(tName) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    }
            )
        }
    }
}

@Composable
fun SpecializationCardShimmer(modifier: Modifier = Modifier) {
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
        SpecializationCard(
            specialist = testSpecialist,
            modifier = Modifier
                .height(140.dp)
                .background(Color.White)
        )
    }
}