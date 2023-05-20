package com.rodrigoguerrero.myprojects.projects.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.outlined.FilterAlt
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.projects.ui.components.MyProjectsTopBar
import com.rodrigoguerrero.myprojects.projects.ui.components.ProjectDetailCard
import com.rodrigoguerrero.myprojects.projects.ui.models.Priority
import com.rodrigoguerrero.myprojects.projects.ui.models.Project
import com.rodrigoguerrero.myprojects.projects.ui.models.Status
import com.rodrigoguerrero.myprojects.shared.ui.ButtonWithIcons
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun ProjectsList(
    modifier: Modifier = Modifier,
    projects: PersistentList<Project>,
    onMore: () -> Unit,
    onSearch: () -> Unit
) {

    Scaffold(
        modifier = modifier,
        topBar = {
            MyProjectsTopBar(onMore = onMore, onSearch = onSearch)
        }
    ) { padding ->

        if (projects.isEmpty()) {
            EmptyScreen()
        } else {
            LazyColumn(
                modifier = Modifier.padding(
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding(),
                    start = MyProjectsTheme.padding.m,
                    end = MyProjectsTheme.padding.m
                ),
                contentPadding = PaddingValues(vertical = MyProjectsTheme.padding.m),
                verticalArrangement = Arrangement.spacedBy(MyProjectsTheme.padding.m)
            ) {
                item {
                    ListOptions()
                }

                items(projects) { project ->
                    ProjectDetailCard(
                        project = project,
                        onClick = {},
                    )
                }
            }
        }
    }
}

@Composable
private fun ListOptions() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = MyProjectsTheme.padding.m),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ButtonWithIcons(
            text = "Board",
            leadingIcon = Icons.Outlined.GridView,
            trailingIcon = Icons.Filled.ArrowDropDown,
            onClick = { }
        )
        Spacer(modifier = Modifier.weight(1f))
        ButtonWithIcons(
            text = "Filter",
            leadingIcon = Icons.Outlined.FilterAlt,
            onClick = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewProjectsList() {
    val project = Project(
        id = "id",
        title = "Banking Platform Web & Mobile App",
        comments = 16,
        status = Status.InProgress,
        completedPercentage = 0.78f,
        dueDate = "June 18, 2023",
        priority = Priority.High,
        numberOfAttachments = 3
    )
    MyProjectsTheme {
        ProjectsList(
            onMore = { },
            onSearch = { },
            projects = persistentListOf(project)
        )
    }
}
