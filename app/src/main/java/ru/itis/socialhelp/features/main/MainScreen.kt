package ru.itis.socialhelp.features.main

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.itis.socialhelp.R
import ru.itis.socialhelp.features.main.views.SpecializationCard
import ru.itis.socialhelp.features.main.views.SpecializationCardShimmer
import ru.itis.socialhelp.features.main.views.ProblemCard
import ru.itis.socialhelp.features.main.views.ProblemCardShimmer
import ru.itis.socialhelp.navigation.Navigation
import ru.itis.socialhelp.ui.theme.AppTheme.appViewModel
import ru.itis.socialhelp.ui.theme.AppTheme.mainNavController
import ru.itis.socialhelp.ui.theme.LocalColorProvider

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(viewModel: MainViewModel) {
    val navController = mainNavController
    val viewState by viewModel.viewState.collectAsState()
    val appViewState by appViewModel.viewState.collectAsState()

    Scaffold(
        topBar = {
            MainToolbar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(LocalColorProvider.current.primaryBackground)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = stringResource(id = R.string.main_problems),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp)
            )
            LazyRow {
                if (viewState.isProblemsLoading)
                    items(5) {
                        ProblemCardShimmer(
                            modifier = Modifier
                                .padding(horizontal = 12.dp)
                        )
                    }
                else
                    items(viewState.problems) { problem ->
                        ProblemCard(
                            problem = problem,
                            modifier = Modifier
                                .padding(horizontal = 12.dp)
                                .clickable(
                                    onClick = {
//                                    TODO("Логика открытия проблемы")
                                    },
                                    indication = rememberRipple(bounded = true),
                                    interactionSource = MutableInteractionSource()
                                )
                        )
                    }
            }

            Row(
                modifier = Modifier
                    .padding(top = 12.dp, start = 12.dp, bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.main_all_doctors),
                    fontWeight = FontWeight.Bold,
                )

                Spacer(modifier = Modifier.weight(1f))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clickable {
                            navController.navigate(Navigation.Categories.name)
                        }
                ) {
                    Text(
                        text = stringResource(id = R.string.main_all_doctors_btn),
                        fontSize = 14.sp
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_chevron_right_24),
                        contentDescription = stringResource(id = R.string.cd_open_all_categories)
                    )
                }
            }

            if (viewState.isDoctorsLoading)
                repeat(3) {
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
                repeat(4) {
                    SpecializationCard(
                        modifier = Modifier
                            .height(140.dp)
                            .padding(
                                horizontal = 12.dp,
                                vertical = 8.dp
                            )
                            .clickable(
                                onClick = {
                                    navController.navigate(
                                        "${Navigation.Specialists.name}/${viewState.categories[it].id}/${viewState.categories[it].title}"
                                    )
                                },
                                indication = rememberRipple(bounded = true),
                                interactionSource = MutableInteractionSource()
                            ),
                        specialist = viewState.categories[it]
                    )
                }
        }
    }
}
