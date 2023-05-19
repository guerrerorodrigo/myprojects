package com.rodrigoguerrero.myprojects.projects.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.R
import com.rodrigoguerrero.myprojects.projects.ui.components.MainBottomBar
import com.rodrigoguerrero.myprojects.projects.ui.components.MainListHeader
import com.rodrigoguerrero.myprojects.projects.ui.components.MainTopBar
import com.rodrigoguerrero.myprojects.projects.ui.components.ProjectCard
import com.rodrigoguerrero.myprojects.projects.ui.components.TaskCard
import com.rodrigoguerrero.myprojects.projects.ui.models.Project
import com.rodrigoguerrero.myprojects.projects.ui.models.Status
import com.rodrigoguerrero.myprojects.projects.ui.models.Task
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    name: String,
    numberOfNotifications: Int,
    recentProjects: List<Project>,
    todayTasks: List<Task>,
    onViewAllProjects: () -> Unit,
    onViewAllTasks: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = { MainTopBar(name = name, numberOfNotifications = numberOfNotifications) },
        bottomBar = {
            MainBottomBar(
                onListClick = { },
                onTaskClick = { },
                onMessageClick = { },
                onProfileClick = { },
                onNewProjectClick = { }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding(),
                    start = MyProjectsTheme.padding.m,
                    end = MyProjectsTheme.padding.m
                )
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MyProjectsTheme.padding.m),
            contentPadding = PaddingValues(vertical = MyProjectsTheme.padding.m)
        ) {
            item {
                MainListHeader(
                    title = stringResource(id = R.string.recent_projects),
                    buttonText = stringResource(id = R.string.view_all),
                    onViewAll = onViewAllProjects
                )
            }

            items(recentProjects) { project ->
                ProjectCard(project = project, onClick = { })
            }
            item {
                MainListHeader(
                    title = stringResource(R.string.today_tasks),
                    buttonText = stringResource(id = R.string.view_all),
                    onViewAll = onViewAllTasks
                )
            }

            items(todayTasks) { task ->
                TaskCard(task = task, onClick = {}, onMenuClick = {})
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun PreviewMainScreen() {
    val project = Project(
        id = "id",
        title = "Banking Platform Web & Mobile App",
        comments = 0,
        status = Status.InProgress,
        completedPercentage = 0.18f,
        dueDate = "June 18, 2023",
        color = MyProjectsTheme.colors.brightPink,
    )

    val task = Task(
        id = "id",
        projectName = "Project Name",
        status = Status.InProgress,
        time = "10:00 am - 06:00 pm",
        title = "This is the task to perform."
    )
    MyProjectsTheme {
        MainScreen(
            name = "Vanessa",
            numberOfNotifications = 3,
            recentProjects = listOf(project, project, project, project),
            todayTasks = listOf(task, task, task, task, task),
            onViewAllProjects = { },
            onViewAllTasks = { }
        )
    }
}
