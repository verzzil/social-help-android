package ru.itis.socialhelp.features.categories

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
import ru.itis.socialhelp.features.main.views.SpecializationCard
import ru.itis.socialhelp.features.main.views.SpecializationCardShimmer
import ru.itis.socialhelp.navigation.Navigation
import ru.itis.socialhelp.ui.theme.AppTheme.mainNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CategoriesScreen(
    viewModel: CategoriesViewModel
) {
    val navController = mainNavController
    val viewState by viewModel.viewState.collectAsState()

    Scaffold(
        topBar = {
            CategoriesToolbar(
                viewModel = viewModel
            )
        }
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            if (viewState.isLoading)
                items(3) {
                    SpecializationCardShimmer(
                        modifier = Modifier
                            .height(140.dp)
                            .padding(
                                horizontal = 12.dp,
                                vertical = 8.dp
                            )
                    )
                }
            else
                items(viewState.categories) { category ->
                    SpecializationCard(
                        specialist = category,
                        modifier = Modifier
                            .height(140.dp)
                            .padding(
                                horizontal = 12.dp,
                                vertical = 8.dp
                            )
                            .clickable(
                                onClick = {
                                    navController.navigate(
                                        "${Navigation.Specialists.name}/${category.id}/${category.title}"
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