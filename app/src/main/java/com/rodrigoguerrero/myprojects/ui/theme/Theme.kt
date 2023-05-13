package com.rodrigoguerrero.myprojects.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

object MyProjectsTheme {
    val colors: MyProjectsColors
        @Composable
        get() = LocalColors.current

    val typography: MyProjectsTypography
        @Composable
        get() = LocalTypography.current
}

@Composable
fun MyProjectsTheme(
    content: @Composable () -> Unit
) {

    CompositionLocalProvider(
        LocalColors provides MyProjectsColors(),
        LocalTypography provides MyProjectsTypography()
    ) {
        MaterialTheme(
            content = content
        )
    }
}
