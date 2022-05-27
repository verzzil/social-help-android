package ru.itis.socialhelp.features.categories

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ru.itis.socialhelp.R
import ru.itis.socialhelp.features.categories.mvi.CategoriesEvent
import ru.itis.socialhelp.features.categories.mvi.CategoriesViewState
import ru.itis.socialhelp.ui.theme.AppTheme.mainNavController

@Composable
fun CategoriesToolbar(
    viewModel: CategoriesViewModel
) {
    val navController = mainNavController

    val viewState by viewModel.viewState.collectAsState()

    if (viewState.isSearching)
        Searching(viewState, viewModel)
    else
        UnSearching(navController, viewModel)
}

@Composable
private fun Searching(
    viewState: CategoriesViewState,
    viewModel: CategoriesViewModel
) {
    val focusRequester = remember { FocusRequester() }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            TextField(
                value = viewState.searchInput,
                onValueChange = {
                    viewModel.obtainEvent(CategoriesEvent.SearchInputChange(it))
                },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            if (viewState.searchInput.isNotEmpty())
                                viewModel.obtainEvent(CategoriesEvent.ClearSearchInput)
                            else
                                viewModel.obtainEvent(CategoriesEvent.ToggleSearchMode)
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_close_24),
                            contentDescription = stringResource(id = R.string.cd_close_search_menu)
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                ),
                placeholder = { Text(text = stringResource(id = R.string.categories_search_placeholder)) },
                modifier = Modifier
                    .fillMaxSize()
                    .focusRequester(focusRequester)
            )
        }
    }

    LaunchedEffect(key1 = viewState.isSearching) {
        if (viewState.isSearching)
            focusRequester.requestFocus()
    }
}

@Composable
private fun UnSearching(navController: NavController, viewModel: CategoriesViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                navController.navigateUp()
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                contentDescription = stringResource(id = R.string.back)
            )
        }

        Text(
            text = stringResource(id = R.string.categories_title),
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            onClick = {
                viewModel.obtainEvent(CategoriesEvent.ToggleSearchMode)
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_search_24),
                contentDescription = stringResource(id = R.string.open_search_menu),
                tint = Color.Black
            )
        }
    }
}