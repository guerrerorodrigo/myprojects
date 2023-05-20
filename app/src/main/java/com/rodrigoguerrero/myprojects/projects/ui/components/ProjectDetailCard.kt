package com.rodrigoguerrero.myprojects.projects.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AttachFile
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.material.icons.outlined.MoreHoriz
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rodrigoguerrero.myprojects.R
import com.rodrigoguerrero.myprojects.projects.ui.models.Priority
import com.rodrigoguerrero.myprojects.projects.ui.models.Project
import com.rodrigoguerrero.myprojects.projects.ui.models.Status
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectDetailCard(
    modifier: Modifier = Modifier,
    project: Project,
    onClick: (String) -> Unit
) {
    Card(
        onClick = { onClick(project.id) },
        modifier = modifier,
        shape = MyProjectsTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = if (project.hasDefaultBackgroundColor) {
                MyProjectsTheme.colors.white
            } else {
                project.color
            },
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
            Header(project)

            ProjectDetails(project)

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(177.dp),
                shape = MyProjectsTheme.shapes.medium,
                color = MyProjectsTheme.colors.grey1
            ) {
                // TODO: replace with image.
            }
            ProgressStatusIndicator(
                progressBackgroundColor = MyProjectsTheme.colors.black,
                progressColor = if (project.hasDefaultBackgroundColor) {
                    MyProjectsTheme.colors.green
                } else {
                    MyProjectsTheme.colors.white
                },
                progress = project.completedPercentage,
                status = project.status.statusRes,
                modifier = Modifier.padding(top = MyProjectsTheme.padding.s)
            )
        }
    }
}

@Composable
private fun ProjectDetails(project: Project) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(MyProjectsTheme.padding.s)
    ) {
        IconWithText(
            icon = Icons.Outlined.CalendarMonth,
            text = project.dueDate,
            textColor = MyProjectsTheme.colors.black,
            modifier = Modifier
                .background(
                    color = MyProjectsTheme.colors.grey2,
                    shape = MyProjectsTheme.shapes.medium
                )
                .padding(
                    vertical = MyProjectsTheme.padding.xs,
                    horizontal = MyProjectsTheme.padding.s
                )
        )

        IconWithText(
            icon = Icons.Outlined.Comment,
            text = "${project.comments}",
            textColor = MyProjectsTheme.colors.black,
            modifier = Modifier
                .background(
                    color = MyProjectsTheme.colors.grey2,
                    shape = MyProjectsTheme.shapes.medium
                )
                .padding(
                    vertical = MyProjectsTheme.padding.xs,
                    horizontal = MyProjectsTheme.padding.s
                )
        )

        IconWithText(
            icon = Icons.Outlined.AttachFile,
            text = "${project.numberOfAttachments}",
            textColor = MyProjectsTheme.colors.black,
            modifier = Modifier
                .background(
                    color = MyProjectsTheme.colors.grey2,
                    shape = MyProjectsTheme.shapes.medium
                )
                .padding(
                    vertical = MyProjectsTheme.padding.xs,
                    horizontal = MyProjectsTheme.padding.s
                )
        )
    }
}

@Composable
private fun Header(project: Project) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = project.title, style = MyProjectsTheme.typography.heading8)
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Outlined.MoreHoriz, contentDescription = null)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun PreviewProjectDetailCard() {
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
        Box(modifier = Modifier.padding(MyProjectsTheme.padding.m)) {
            ProjectDetailCard(project = project, onClick = { })
        }
    }
}
