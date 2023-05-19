package com.rodrigoguerrero.myprojects.shared.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.R
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

@Composable
fun SecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    border: BorderStroke? = null,
    icon: ImageVector? = null
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = MyProjectsTheme.shapes.large,
        contentPadding = PaddingValues(MyProjectsTheme.padding.m),
        colors = ButtonDefaults.buttonColors(
            containerColor = MyProjectsTheme.colors.white,
            contentColor = MyProjectsTheme.colors.purple
        ),
        border = border
    ) {

        icon?.let {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.button_icon_size))
                    .padding(end = MyProjectsTheme.padding.s)
            )
        }
        Text(
            text = text,
            style = MyProjectsTheme.typography.titleButton
        )
    }
}

@Preview
@Composable
private fun PreviewSecondaryButton() {
    MyProjectsTheme {
        SecondaryButton(text = "Get Started", onClick = {})
    }
}

@Preview
@Composable
private fun PreviewSecondaryButtonWithBorderAndIcon() {
    MyProjectsTheme {
        SecondaryButton(
            text = "Get Started",
            onClick = {},
            icon = Icons.Outlined.AddBox,
            border = BorderStroke(
                width = dimensionResource(id = R.dimen.border_width),
                color = MyProjectsTheme.colors.purple
            )
        )
    }
}
