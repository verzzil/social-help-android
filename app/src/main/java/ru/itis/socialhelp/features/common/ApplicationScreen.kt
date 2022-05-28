package ru.itis.socialhelp.features.common

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ru.itis.socialhelp.features.categories.CategoriesScreen
import ru.itis.socialhelp.features.categories.CategoriesViewModel
import ru.itis.socialhelp.features.chat.ChatScreen
import ru.itis.socialhelp.features.chat.ChatToolbar
import ru.itis.socialhelp.features.chat.ChatViewModel
import ru.itis.socialhelp.features.common.mvi.AppEvent
import ru.itis.socialhelp.features.common.mvi.AppViewState
import ru.itis.socialhelp.features.drawer.DrawerScreen
import ru.itis.socialhelp.features.login.LoginScreen
import ru.itis.socialhelp.features.login.LoginViewModel
import ru.itis.socialhelp.features.main.MainScreen
import ru.itis.socialhelp.features.main.MainToolbar
import ru.itis.socialhelp.features.main.MainViewModel
import ru.itis.socialhelp.features.profile.ProfileScreen
import ru.itis.socialhelp.features.profile.ProfileToolbar
import ru.itis.socialhelp.features.profile.ProfileViewModel
import ru.itis.socialhelp.features.specialists.SpecialistsScreen
import ru.itis.socialhelp.features.specialists.SpecialistsViewModel
import ru.itis.socialhelp.features.splash.SplashScreen
import ru.itis.socialhelp.features.timetable.TimeTableScreen
import ru.itis.socialhelp.features.timetable.TimeTableViewModel
import ru.itis.socialhelp.navigation.Navigation
import ru.itis.socialhelp.ui.theme.AppTheme.appViewModel
import ru.itis.socialhelp.ui.theme.AppTheme.mainNavController
import ru.itis.socialhelp.ui.theme.LocalNavControllerProvider
import ru.itis.socialhelp.ui.theme.LocalViewModelProvider
import kotlin.math.roundToInt

val startDestination = Navigation.Splash.name

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ApplicationScreen() {
    val navController = mainNavController
    val scaffoldState = rememberScaffoldState()

    val viewState by appViewModel.viewState.collectAsState()

    manageDrawerState(viewState, scaffoldState, appViewModel)

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        scaffoldState = scaffoldState,
        drawerContent = {
            DrawerScreen()
        },
        content = {
            ContentHost(navController)
        }
    )
}

@Composable
private fun manageDrawerState(
    viewState: AppViewState,
    scaffoldState: ScaffoldState,
    appViewModel: AppViewModel
) {
    LaunchedEffect(
        key1 = viewState.needOpenDrawer,
        key2 = viewState.needCloseDrawer,
        key3 = scaffoldState.drawerState.isOpen
    ) {
        with(scaffoldState.drawerState) {
            when {
                viewState.needOpenDrawer && isClosed -> {
                    open()
                    appViewModel.obtainEvent(AppEvent.ReadyDrawerOpen)
                }
                viewState.needCloseDrawer && isOpen -> {
                    close()
                    appViewModel.obtainEvent(AppEvent.ReadyDrawerClose)
                }
            }
        }
    }
}

@Composable
private fun ContentHost(navController: NavController) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = startDestination,
    ) {
        composable(Navigation.Splash.name) {
            SplashScreen()
        }
        composable(Navigation.Main.name) {
            val mainViewModel = hiltViewModel<MainViewModel>()
            MainScreen(viewModel = mainViewModel)
        }
        composable(Navigation.Chat.name) {
            val chatViewModel = hiltViewModel<ChatViewModel>()
            ChatScreen(viewModel = chatViewModel)
        }
        composable(
            "${Navigation.Profile.name}/{profileId}",
            arguments = listOf(navArgument("profileId") { type = NavType.LongType })
        ) {
            val profileViewMode = hiltViewModel<ProfileViewModel>()
            ProfileScreen(
                viewModel = profileViewMode,
                profileId = it.arguments?.getLong("profileId") ?: 0
            )
        }
        composable(Navigation.Login.name) {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(viewModel = loginViewModel)
        }
        composable(Navigation.Categories.name) {
            val categoriesViewModel = hiltViewModel<CategoriesViewModel>()
            CategoriesScreen(viewModel = categoriesViewModel)
        }
        composable(
            "${Navigation.Specialists.name}/{categoryId}/{title}",
            arguments = listOf(navArgument("categoryId") { type = NavType.LongType })
        ) {
            val specialistsViewModel = hiltViewModel<SpecialistsViewModel>()
            SpecialistsScreen(
                viewModel = specialistsViewModel,
                it.arguments?.getLong("categoryId") ?: 0,
                it.arguments?.getString("title") ?: ""
            )
        }
        composable(Navigation.TimeTable.name) {
            val timeTableViewModel = hiltViewModel<TimeTableViewModel>()
            TimeTableScreen(viewModel = timeTableViewModel)
        }
    }
}
