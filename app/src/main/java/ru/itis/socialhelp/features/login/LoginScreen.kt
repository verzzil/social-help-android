package ru.itis.socialhelp.features.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import ru.itis.socialhelp.R
import ru.itis.socialhelp.features.login.mvi.LoginEvent
import ru.itis.socialhelp.features.login.mvi.LoginViewState
import ru.itis.socialhelp.ui.theme.AppTheme.appViewModel
import ru.itis.socialhelp.ui.theme.AppTheme.colors
import ru.itis.socialhelp.ui.theme.AppTheme.mainNavController

@Composable
fun LoginScreen(
    viewModel: LoginViewModel
) {
    val appViewModel = appViewModel
    val navController = mainNavController

    val viewState by viewModel.viewState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.small_logo),
            contentDescription = stringResource(id = R.string.cd_logo)
        )

        SignInUpTabLayout(viewState = viewState, viewModel = viewModel)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SignInUpTabLayout(
    viewState: LoginViewState,
    viewModel: LoginViewModel
) {
    val tabItems = listOf(stringResource(id = R.string.drawer_sign_in), stringResource(id = R.string.drawer_sign_up))
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            backgroundColor = Color.Transparent,
            modifier = Modifier
                .padding(5.dp),
        ) {
            tabItems.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(
                            text = title,
                            style = TextStyle(color = Color.Black, fontSize = 16.sp)
                        )
                    },
                )
            }
        }

        HorizontalPager(
            count = tabItems.size,
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
        ) { page ->
            if (tabItems[page] == stringResource(id = R.string.drawer_sign_in)) {
                SignInScreen(viewState = viewState, viewModel = viewModel)
            } else {

            }
        }
    }
}

@Composable
fun SignInScreen(
    viewState: LoginViewState,
    viewModel: LoginViewModel
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = viewState.loginValue,
            onValueChange = {
                viewModel.obtainEvent(LoginEvent.InputLoginField(it))
            },
            label = { Text(text = stringResource(id = R.string.login_enter_login)) },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = colors.mainColor,
                focusedLabelColor = colors.mainColor
            )
        )
        
        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = viewState.passValue,
            onValueChange = {
                viewModel.obtainEvent(LoginEvent.InputPassField(it))
            },
            label = { Text(text = stringResource(id = R.string.login_enter_pass)) },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = colors.mainColor,
                focusedLabelColor = colors.mainColor
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                // todo add request to server when get access and refresh tokens
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colors.mainColor
            )
        ) {
            Text(
                text = stringResource(id = R.string.login_login),
                style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold)
            )
        }
    }
}
