package com.rodrigoguerrero.myprojects.projects.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.R
import com.rodrigoguerrero.myprojects.projects.ui.models.Priority
import com.rodrigoguerrero.myprojects.projects.ui.models.Project
import com.rodrigoguerrero.myprojects.projects.ui.models.Status
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectCard(
    modifier: Modifier = Modifier,
    project: Project,
    onClick: (String) -> Unit
) {
    Card(
        onClick = { onClick(project.id) },
        modifier = modifier,
        shape = MyProjectsTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = project.color,
            contentColor = if (project.hasDefaultBackgroundColor) {
                MyProjectsTheme.colors.black
            } else {
                MyProjectsTheme.colors.white
            }
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.card_elevation)
        )
    ) {
        Column(
            modifier = Modifier.padding(all = MyProjectsTheme.padding.m),
            verticalArrangement = Arrangement.spacedBy(MyProjectsTheme.padding.s)
        ) {
            project.priority?.let { priority ->
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Tag(
                        contentColor = if (project.hasDefaultBackgroundColor) {
                            MyProjectsTheme.colors.black
                        } else {
                            MyProjectsTheme.colors.white
                        },
                        text = stringResource(id = priority.priorityRes),
                        icon = priority.icon
                    )
                }
            }
            Text(text = project.title, style = MyProjectsTheme.typography.heading8)
            Row(
                horizontalArrangement = Arrangement.spacedBy(MyProjectsTheme.padding.xs),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconWithText(icon = Icons.Outlined.CalendarMonth, text = project.dueDate)
                Text(text = stringResource(R.string.bullet))
                IconWithText(icon = Icons.Outlined.Comment, text = "${project.comments}")
            }
            ProgressStatusIndicator(
                progressBackgroundColor = MyProjectsTheme.colors.black,
                progressColor = if (project.hasDefaultBackgroundColor) {
                    MyProjectsTheme.colors.green
                } else {
                    MyProjectsTheme.colors.white
                },
                progress = project.completedPercentage,
                status = project.status.statusRes
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun PreviewTransparentProjectCard() {
    val project = Project(
        id = "id",
        title = "Banking Platform Web & Mobile App",
        comments = 16,
        status = Status.InProgress,
        completedPercentage = 0.78f,
        dueDate = "June 18, 2023",
        priority = Priority.High,
        numberOfAttachments = 0
    )

    MyProjectsTheme {
        Box(modifier = Modifier.padding(MyProjectsTheme.padding.m)) {
            ProjectCard(project = project, onClick = { })
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun PreviewColorProjectCard() {
    val project = Project(
        id = "id",
        title = "Banking Platform Web & Mobile App",
        comments = 16,
        status = Status.InProgress,
        completedPercentage = 0.78f,
        dueDate = "June 18, 2023",
        color = MyProjectsTheme.colors.pest,
        priority = Priority.High,
        numberOfAttachments = 0
    )

    MyProjectsTheme {
        Box(modifier = Modifier.padding(MyProjectsTheme.padding.m)) {
            ProjectCard(project = project, onClick = { })
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun PreviewColorProjectCardNoPriority() {
    val project = Project(
        id = "id",
        title = "Banking Platform Web & Mobile App",
        comments = 0,
        status = Status.InProgress,
        completedPercentage = 0.18f,
        dueDate = "June 18, 2023",
        color = MyProjectsTheme.colors.brightPink,
        numberOfAttachments = 0
    )

    MyProjectsTheme {
        Box(modifier = Modifier.padding(MyProjectsTheme.padding.m)) {
            ProjectCard(project = project, onClick = { })
        }
    }
}
