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

    val padding: MyProjectsPadding
        @Composable
        get() = LocalPadding.current

    val shapes: MyProjectShapes
        @Composable
        get() = LocalShapes.current
}

@Composable
fun MyProjectsTheme(
    content: @Composable () -> Unit
) {

    CompositionLocalProvider(
        LocalColors provides MyProjectsColors(),
        LocalTypography provides MyProjectsTypography(),
        LocalPadding provides MyProjectsPadding(),
        LocalShapes provides MyProjectShapes()
    ) {
        MaterialTheme(
            content = content
        )
    }
}
