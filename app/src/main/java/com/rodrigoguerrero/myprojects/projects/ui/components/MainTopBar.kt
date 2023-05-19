package com.rodrigoguerrero.myprojects.projects.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.R
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    modifier: Modifier = Modifier,
    name: String,
    numberOfNotifications: Int
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(MyProjectsTheme.padding.m),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(MyProjectsTheme.padding.m)
    ) {
        Box(
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.top_bar_image_size))
                .clip(CircleShape)
                .background(color = MyProjectsTheme.colors.grey1)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(MyProjectsTheme.padding.xxs)
        ) {
            Text(
                text = stringResource(R.string.hello_user, name),
                style = MyProjectsTheme.typography.heading8
            )
            Text(
                text = stringResource(R.string.let_s_complete_your_today_tasks),
                style = MyProjectsTheme.typography.caption2
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Box {
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = null,
            )
            if (numberOfNotifications > 0) {
                Badge(
                    containerColor = MyProjectsTheme.colors.error,
                    contentColor = MyProjectsTheme.colors.white,
                    modifier = Modifier
                        .padding(
                            start = dimensionResource(id = R.dimen.top_bar_badge_padding),
                            top = MyProjectsTheme.padding.xs,
                        )
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun PreviewMainTopBarWithNotifications() {
    MyProjectsTheme {
        MainTopBar(
            name = "Vanessa",
            numberOfNotifications = 2
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun PreviewMainTopBar() {
    MyProjectsTheme {
        MainTopBar(
            name = "Vanessa",
            numberOfNotifications = 0
        )
    }
}
