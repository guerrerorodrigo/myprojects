package com.rodrigoguerrero.myprojects.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.rodrigoguerrero.myprojects.R
import javax.annotation.concurrent.Immutable

private val Inter = FontFamily(
    Font(resId = R.font.font_inter, style = FontStyle.Normal)
)

@Immutable
data class MyProjectsTypography(
    val heading1: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 26.sp,
        lineHeight = 36.sp,
        fontWeight = FontWeight.Bold,
    ),
    val heading2: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        fontWeight = FontWeight.Medium
    ),
    val heading3: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.Bold
    ),
    val heading4: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.Medium
    ),
    val heading5: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.Bold
    ),
    val heading6: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 15.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Bold
    ),
    val heading7: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 14.sp,
        lineHeight = 22.sp,
        fontWeight = FontWeight.Bold
    ),
    val heading8: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Bold
    ),
    val heading9: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 14.sp,
        lineHeight = 22.sp,
        fontWeight = FontWeight.Medium
    ),
    val heading10: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Medium
    ),
    val titleButton: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Bold
    ),
    val body1: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 13.sp,
        lineHeight = 22.sp,
        fontWeight = FontWeight.Medium
    ),
    val body2: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 13.sp,
        lineHeight = 22.sp,
        fontWeight = FontWeight.Normal
    ),
    val body3: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 12.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Bold
    ),
    val body4: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Bold
    ),
    val body5: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 10.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.SemiBold
    ),
    val body6: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 12.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Medium
    ),
    val body7: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 12.sp,
        lineHeight = 18.sp,
        fontWeight = FontWeight.Medium
    ),
    val body8: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Medium
    ),
    val body9: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 12.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Normal
    ),
    val body10: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 12.sp,
        lineHeight = 12.sp,
        fontWeight = FontWeight.Normal
    ),
    val caption1: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Bold
    ),
    val caption2: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 10.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Normal
    ),
    val caption3: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 8.sp,
        lineHeight = 12.sp,
        fontWeight = FontWeight.Medium
    ),
    val caption4: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 8.sp,
        lineHeight = 12.sp,
        fontWeight = FontWeight.Normal
    ),
    val caption5: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 7.sp,
        lineHeight = 12.sp,
        fontWeight = FontWeight.SemiBold
    ),
    val caption6: TextStyle = TextStyle(
        fontFamily = Inter,
        fontSize = 7.sp,
        lineHeight = 12.sp,
        fontWeight = FontWeight.Normal
    ),
)

val LocalTypography = staticCompositionLocalOf { MyProjectsTypography() }
