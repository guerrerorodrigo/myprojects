package com.rodrigoguerrero.myprojects.projects.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreHoriz
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.R
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyProjectsTopBar(
    modifier: Modifier = Modifier,
    onMore: () -> Unit,
    onSearch: () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(R.string.my_projects),
                style = MyProjectsTheme.typography.heading5
            )
        },
        actions = {
            IconButton(onClick = onSearch) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = null,
                    tint = MyProjectsTheme.colors.black.copy(alpha = 0.5f)
                )
            }
            IconButton(onClick = onMore) {
                Icon(
                    imageVector = Icons.Outlined.MoreHoriz,
                    contentDescription = null,
                    tint = MyProjectsTheme.colors.black.copy(alpha = 0.5f)
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewMyProjectsTopBar() {
    MyProjectsTheme {
        MyProjectsTopBar(onMore = {}, onSearch = {})
    }
}
