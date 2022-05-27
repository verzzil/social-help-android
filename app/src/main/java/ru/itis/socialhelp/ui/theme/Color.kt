package ru.itis.socialhelp.ui.theme

import androidx.compose.ui.graphics.Color

data class Colors(
    val mainColor: Color,
    val primaryBackground: Color,
    val secondaryBackground: Color,
    val headerTextColor: Color,
    val primaryTextColor: Color,
    val primaryTextInvertColor: Color,
    val hintTextColor: Color,
    val primaryTintColor: Color,
    val secondaryTintColor: Color,
    val accentColor: Color,
    val notificationColor: Color,
    val actionTextColor: Color,

    // Messages
    val mineMessageBackground: Color,
    val mineMessageTextColor: Color,
    val friendMessageBackground: Color,
    val friendMessageTextColor: Color,
    val messageInputColor: Color,
    val inputMessageDividerColor: Color,
    val disabledMessageSendIconColor: Color,
    val messageSendIconColor: Color,
)

val lightPalette = Colors(
    mainColor = Color(0xff98E38D),
    primaryBackground = Color.White,
    secondaryBackground = Color(0x10D0CCC7),
    headerTextColor = Color(0xFF311F09),
    primaryTextColor = Color(0xFF59442B),
    primaryTextInvertColor = Color(0xFFFFFFFF),
    primaryTintColor = Color(0xFFFF8A00),
    secondaryTintColor = Color(0xFF3FA72F),
    hintTextColor = Color(0xFFA0978C),
    accentColor = Color(0xFF8AEAFF),
    notificationColor = Color(0xFFFF3838),
    actionTextColor = Color(0xFF0094FF),
    mineMessageBackground = Color(0xFFCCE4FE),
    mineMessageTextColor = Color(0xFF000000),
    friendMessageBackground = Color(0xFFECEDF1),
    friendMessageTextColor = Color(0xFF000000),
    messageInputColor = Color(0xFFffffff),
    inputMessageDividerColor = Color(0xFFE1E1E1),
    messageSendIconColor = Color(0xFF007BFE),
    disabledMessageSendIconColor = Color(0x10D0CCC7)
)