package com.rodrigoguerrero.myprojects.projects.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material3.Icon
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
fun IconWithText(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    text: String
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(MyProjectsTheme.padding.xs),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(dimensionResource(id = R.dimen.project_card_icon_size))
        )
        Text(text = text, style = MyProjectsTheme.typography.caption6)
    }
}

@Preview
@Composable
private fun PreviewIconWithText() {
    MyProjectsTheme {
        IconWithText(icon = Icons.Outlined.CalendarMonth, text = "June 21, 2013")
    }
}
