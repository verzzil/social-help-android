package ru.itis.socialhelp.features.profile

import android.util.Log
import android.widget.CalendarView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.launch
import ru.itis.socialhelp.R
import ru.itis.socialhelp.features.profile.mvi.ProfileEvent
import ru.itis.socialhelp.ui.theme.AppTheme.appViewModel
import ru.itis.socialhelp.ui.theme.AppTheme.colors
import ru.itis.socialhelp.ui.theme.AppTheme.mainNavController
import java.sql.Time
import java.sql.Timestamp
import java.util.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel,
    profileId: Long
) {
    viewModel.obtainEvent(ProfileEvent.LoadProfile(profileId))

    val navController = mainNavController
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current

    val year = remember { mutableStateOf(0) }
    val mouth = remember { mutableStateOf(0) }
    val day = remember { mutableStateOf(0) }
    val hour = remember { mutableStateOf(0) }
    val minutes = remember { mutableStateOf(0) }
    val hourMinutesStr = remember { mutableStateOf("") }
    val descr = remember { mutableStateOf("") }

    val appViewState by appViewModel.viewState.collectAsState()
    val viewState by viewModel.viewState.collectAsState()

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                AndroidView(factory = { CalendarView(it) }, update = {
                    it.setOnDateChangeListener { calendarView, yearc, mounthc, dayc ->
                        year.value = yearc
                        mouth.value = mounthc
                        day.value = dayc
                    }
                })

                Text(
                    text = if (day.value != 0) "${day.value}.${mouth.value + 1}.${year.value}" else ""
                )

                TextField(
                    value = hourMinutesStr.value,
                    onValueChange = {
                        hourMinutesStr.value = it
                    },
                    label = { Text(text = "Введите время") },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = colors.mainColor,
                        focusedLabelColor = colors.mainColor
                    )
                )

                TextField(
                    value = descr.value,
                    onValueChange = {
                        descr.value = it
                    },
                    label = { Text(text = "Введите описание проблемы") },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = colors.mainColor,
                        focusedLabelColor = colors.mainColor
                    )
                )

                Button(
                    onClick = {
                        val sep = hourMinutesStr.value.split(":").map { it.toInt() }
                        hour.value = sep[0]
                        minutes.value = sep[1]

                        val resultDate = Date(year.value - 1900,mouth.value + 1,day.value, hour.value, minutes.value).time
                        val resultDescr = descr.value

                        viewModel.obtainEvent(
                            ProfileEvent.CreateTimeTable(
                                resultDate,
                                resultDescr,
                                appViewState.currentUser?.accessToken ?: "",
                                viewState.user.id
                            )
                        )

                        coroutineScope.launch {
                            sheetState.hide()
                            focusManager.clearFocus()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colors.mainColor
                    )
                ) {
                    Text(
                        text = "Запланировать",
                        style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold)
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            Column(
                modifier = Modifier
                    .weight(.45f)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .background(colors.profileBackgroundColor),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(.1f),
                            ) {
                                IconButton(
                                    onClick = {
                                        navController.popBackStack()
                                    }
                                ) {
                                    Icon(
                                        modifier = Modifier.size(30.dp),
                                        painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                                        contentDescription = stringResource(id = R.string.back),
                                        tint = Color.White
                                    )
                                }

                                Spacer(modifier = Modifier.weight(1f))

                                if (viewState.user.isSpecialist)
                                    Text(
                                        text = stringResource(id = R.string.profile_specialist),
                                        modifier = Modifier
                                            .background(colors.specialistTitleColor)
                                            .padding(vertical = 8.dp, horizontal = 12.dp)
                                            .clip(RoundedCornerShape(4.dp)),
                                        color = Color.White,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                            }

                            Spacer(modifier = Modifier.weight(.1f))

                            GlideImage(
                                modifier = Modifier
                                    .weight(.4f)
                                    .aspectRatio(1f)
                                    .clip(RoundedCornerShape(50)),
                                imageModel = viewState.user.image,
                                error = ImageBitmap.imageResource(id = R.drawable.img_default_user_avatar),
                                previewPlaceholder = R.drawable.img_default_user_avatar,
                            )

                            Text(
                                text = viewState.user.fullName,
                                modifier = Modifier
                                    .weight(.3f)
                                    .padding(top = 12.dp),
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        }

                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(25.dp)
                        )
                    }

                    FloatingActionButton(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(end = 40.dp)
                            .size(60.dp),
                        backgroundColor = Color.White,
                        onClick = {
                            when {
                                viewState.user.id != appViewState.currentUser?.id -> {}
                                // todo navigate to chat
                                else -> {}
                                // todo navigate to edit settings
                            }
                        },
                    ) {
                        Icon(
                            painter = when {
                                viewState.user.id != appViewState.currentUser?.id ->
                                    painterResource(id = R.drawable.ic_baseline_message_24)
                                else ->
                                    painterResource(id = R.drawable.ic_baseline_edit_note_24)
                            },
                            contentDescription = stringResource(id = R.string.cd_send_message),
                            tint = colors.profileBackgroundColor
                        )
                    }

                    FloatingActionButton(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(start = 40.dp)
                            .size(60.dp),
                        backgroundColor = Color.White,
                        onClick = {
                            coroutineScope.launch {
                                sheetState.show()
                            }
                        },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_edit_calendar_24),
                            contentDescription = stringResource(id = R.string.cd_send_message),
                            tint = colors.profileBackgroundColor
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.weight(.55f))
        }
    }
}