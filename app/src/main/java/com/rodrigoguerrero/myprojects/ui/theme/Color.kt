package com.rodrigoguerrero.myprojects.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import javax.annotation.concurrent.Immutable

// Primary
private val Purple = Color(0xFF878DFF)

// Secondary
private val BrightPest = Color(0xFF3FEBF4)
private val Pest = Color(0xFF34C8DE)
private val BrightPink = Color(0xFFFF58A6)
private val Pink = Color(0xFFEC4899)
private val Yellow = Color(0xFFFBAE16)
private val Orange = Color(0xFFF9771D)
private val BrightGreen = Color(0xFF9AF05D)
private val Grey1 = Color(0xFFE2E8F0)
private val Grey2 = Color(0xFFF6F5F7)
private val SoftGrey = Color(0xFFF8FAFC)

// Priority
private val Violet = Color(0xFFBB6CF9)
private val Blue = Color(0xFF57A4FF)
private val Green = Color(0xFF45D2B2)

// Text
private val Black = Color(0xFF31394F)
private val White = Color(0xFFFFFFFF)

// State
private val Info = Color(0xFF64BEF1)
private val Success = Color(0xFF5FD788)
private val Warning = Color(0xFFFCDB66)
private val Error = Color(0xFFF05A5A)

@Immutable
data class MyProjectsColors(
    val purple: Color = Purple,
    val brightPest: Color = BrightPest,
    val pest: Color = Pest,
    val brightPink: Color = BrightPink,
    val pink: Color = Pink,
    val yellow: Color = Yellow,
    val orange: Color = Orange,
    val brightGreen: Color = BrightGreen,
    val grey1: Color = Grey1,
    val grey2: Color = Grey2,
    val softGrey: Color = SoftGrey,
    val violet: Color = Violet,
    val blue: Color = Blue,
    val green: Color = Green,
    val black: Color = Black,
    val white: Color = White,
    val info: Color = Info,
    val success: Color = Success,
    val warning: Color = Warning,
    val error: Color = Error
)

val LocalColors = staticCompositionLocalOf { MyProjectsColors() }
