package com.rodrigoguerrero.myprojects.projects.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material.icons.outlined.NoteAlt
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.R
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

@Composable
fun MainBottomBar(
    modifier: Modifier = Modifier,
    onListClick: () -> Unit,
    onTaskClick: () -> Unit,
    onMessageClick: () -> Unit,
    onProfileClick: () -> Unit,
    onNewProjectClick: () -> Unit
) {
    BottomAppBar(
        modifier = modifier.clip(
            shape = RoundedCornerShape(
                topStart = dimensionResource(id = R.dimen.bottom_bar_radius),
                topEnd = dimensionResource(id = R.dimen.bottom_bar_radius)
            )
        ),
        actions = {
            IconButton(onClick = onListClick) {
                Icon(imageVector = Icons.Outlined.GridView, contentDescription = null)
            }
            IconButton(onClick = onTaskClick) {
                Icon(imageVector = Icons.Outlined.NoteAlt, contentDescription = null)
            }
            IconButton(onClick = onMessageClick) {
                Icon(imageVector = Icons.Outlined.Chat, contentDescription = null)
            }
            IconButton(onClick = onProfileClick) {
                Icon(imageVector = Icons.Outlined.Person, contentDescription = null)
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onNewProjectClick,
                containerColor = MyProjectsTheme.colors.purple,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(),
            ) {
                Icon(
                    imageVector = Icons.Outlined.Add,
                    contentDescription = null,
                    tint = MyProjectsTheme.colors.white
                )
            }
        }
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun PreviewMainBottomBar() {
    MyProjectsTheme {
        Surface(modifier = Modifier.padding(MyProjectsTheme.padding.l)) {
            MainBottomBar(
                onNewProjectClick = {},
                onListClick = {},
                onMessageClick = {},
                onProfileClick = {},
                onTaskClick = {}
            )
        }
    }
}
