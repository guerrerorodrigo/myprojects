package com.rodrigoguerrero.myprojects.shared.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = MyProjectsTheme.shapes.large,
        contentPadding = PaddingValues(MyProjectsTheme.padding.m),
        colors = ButtonDefaults.buttonColors(
            containerColor = MyProjectsTheme.colors.purple,
            contentColor = MyProjectsTheme.colors.white
        )
    ) {
        Text(
            text = text,
            style = MyProjectsTheme.typography.titleButton
        )
    }
}

@Preview
@Composable
private fun PreviewPrimaryButton() {
    MyProjectsTheme {
        PrimaryButton(text = "Get Started", onClick = {})
    }
}
