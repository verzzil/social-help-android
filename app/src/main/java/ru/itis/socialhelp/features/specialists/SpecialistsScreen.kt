package ru.itis.socialhelp.features.specialists

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import ru.itis.socialhelp.features.specialists.models.SpecialistItem
import ru.itis.socialhelp.features.specialists.mvi.SpecialistsEvent
import ru.itis.socialhelp.features.specialists.mvi.SpecialistsViewState
import ru.itis.socialhelp.features.specialists.views.SpecialistView

@Composable
fun SpecialistsScreen(
    viewModel: SpecialistsViewModel,
    categoryId: Long,
) {
    viewModel.obtainEvent(SpecialistsEvent.SetCategoryId(categoryId))
    val viewState by viewModel.viewState.collectAsState()



    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (viewState.isLoading)
        // todo add shimmers
        else
            items(viewState.specialists) {
                SpecialistView(specialist = it)
            }
    }
}