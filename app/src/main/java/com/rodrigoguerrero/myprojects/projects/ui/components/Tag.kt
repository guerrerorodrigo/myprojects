package com.rodrigoguerrero.myprojects.projects.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.R
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

@Composable
fun Tag(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Black,
    icon: ImageVector? = null,
    contentColor: Color,
    text: String,
) {
    Surface(
        modifier = modifier,
        shape = MyProjectsTheme.shapes.small,
        color = backgroundColor.copy(alpha = 0.16f),
        contentColor = contentColor
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(MyProjectsTheme.padding.xs),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(all = MyProjectsTheme.padding.xs)
        ) {
            icon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    modifier = Modifier.size(dimensionResource(id = R.dimen.tag_icon_size))
                )
            }
            Text(text = text, style = MyProjectsTheme.typography.caption3)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF34C8DE)
@Composable
private fun PreviewTagOnColorBackground() {
    MyProjectsTheme {
        Tag(
            contentColor = MyProjectsTheme.colors.white,
            text = "High",
            icon = Icons.Filled.Flag,
            modifier = Modifier.padding(MyProjectsTheme.padding.m)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun PreviewTagOnWhiteBackground() {
    MyProjectsTheme {
        Tag(
            contentColor = MyProjectsTheme.colors.black,
            text = "High",
            icon = Icons.Filled.Flag,
            modifier = Modifier.padding(MyProjectsTheme.padding.m)
        )
    }
}
