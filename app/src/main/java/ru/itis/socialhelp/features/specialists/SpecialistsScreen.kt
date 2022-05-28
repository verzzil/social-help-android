package ru.itis.socialhelp.features.specialists

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.itis.socialhelp.features.specialists.models.SpecialistItem
import ru.itis.socialhelp.features.specialists.mvi.SpecialistsEvent
import ru.itis.socialhelp.features.specialists.mvi.SpecialistsViewState
import ru.itis.socialhelp.features.specialists.views.SpecialistView
import ru.itis.socialhelp.navigation.Navigation
import ru.itis.socialhelp.ui.theme.AppTheme.mainNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SpecialistsScreen(
    viewModel: SpecialistsViewModel,
    categoryId: Long,
    title: String
) {
    viewModel.obtainEvent(SpecialistsEvent.SetCategoryId(categoryId))
    val navController = mainNavController

    val viewState by viewModel.viewState.collectAsState()

    Scaffold(
        topBar = {
            SpecialistsToolbar(title = title)
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            if (viewState.isLoading)
            // todo add shimmers
            else
                items(viewState.specialists) {
                    SpecialistView(
                        specialist = it,
                        modifier = Modifier
                            .height(140.dp)
                            .padding(
                                horizontal = 12.dp,
                                vertical = 8.dp
                            )
                            .clickable(
                                onClick = {
                                    navController.navigate(
                                        "${Navigation.Profile.name}/${it.id}"
                                    )
                                },
                                indication = rememberRipple(bounded = true),
                                interactionSource = MutableInteractionSource()
                            ),
                    )
                }
        }
    }
}