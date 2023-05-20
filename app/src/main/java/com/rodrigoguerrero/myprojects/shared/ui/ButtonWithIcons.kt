package com.rodrigoguerrero.myprojects.shared.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.R
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

@Composable
fun ButtonWithIcons(
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    text: String,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier.clickable { onClick() },
        shape = MyProjectsTheme.shapes.large,
        color = MyProjectsTheme.colors.softGrey,
        border = BorderStroke(
            width = dimensionResource(id = R.dimen.border_width),
            color = MyProjectsTheme.colors.black.copy(0.1f)
        ),
        contentColor = MyProjectsTheme.colors.black.copy(alpha = 0.8f)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MyProjectsTheme.padding.s),
            modifier = Modifier.padding(all = MyProjectsTheme.padding.sm)
        ) {

            leadingIcon?.let { icon ->
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.button_with_icons_icon_size))
                )
            }

            Text(
                text = text,
                style = MyProjectsTheme.typography.heading10,
            )

            trailingIcon?.let { icon ->
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.button_with_icons_icon_size))
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewButtonWithIcons() {
    MyProjectsTheme {
        ButtonWithIcons(
            leadingIcon = Icons.Outlined.GridView,
            trailingIcon = Icons.Filled.ArrowDropDown,
            text = "Board",
            onClick = { }
        )
    }
}
