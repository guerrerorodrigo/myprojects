package com.rodrigoguerrero.myprojects.projects.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.R
import com.rodrigoguerrero.myprojects.projects.ui.models.Status
import com.rodrigoguerrero.myprojects.projects.ui.models.Task
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskCard(
    modifier: Modifier = Modifier,
    task: Task,
    onClick: (String) -> Unit,
    onMenuClick: () -> Unit
) {
    Card(
        onClick = { onClick(task.id) },
        modifier = modifier,
        shape = MyProjectsTheme.shapes.large,
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.card_elevation)
        ),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MyProjectsTheme.colors.white,
            contentColor = MyProjectsTheme.colors.black
        )
    ) {
        Column(
            modifier = Modifier.padding(all = MyProjectsTheme.padding.m),
            verticalArrangement = Arrangement.spacedBy(MyProjectsTheme.padding.s)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = task.title, style = MyProjectsTheme.typography.heading8)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = null,
                    modifier = Modifier.clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null
                    ) {
                        onMenuClick()
                    }
                )
            }
            Text(text = task.projectName, style = MyProjectsTheme.typography.caption2)
            Divider(modifier = Modifier.fillMaxWidth(), color = MyProjectsTheme.colors.grey1)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(MyProjectsTheme.padding.s),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = task.time, style = MyProjectsTheme.typography.caption2)
                Spacer(modifier = Modifier.weight(1f))
                Tag(
                    contentColor = task.status.color,
                    text = stringResource(id = task.status.statusRes),
                    backgroundColor = task.status.color
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun PreviewTaskCard() {
    val task = Task(
        id = "id",
        projectName = "Project Name",
        status = Status.InProgress,
        time = "10:00 am - 06:00 pm",
        title = "This is the task to perform."
    )
    MyProjectsTheme {
        Box(modifier = Modifier.padding(MyProjectsTheme.padding.m)) {
            TaskCard(task = task, onClick = { }, onMenuClick = { })
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun PreviewTaskCardToDo() {
    val task = Task(
        id = "id",
        projectName = "Project Name",
        status = Status.ToDo,
        time = "10:00 am - 06:00 pm",
        title = "This is the task to perform."
    )
    MyProjectsTheme {
        Box(modifier = Modifier.padding(MyProjectsTheme.padding.m)) {
            TaskCard(task = task, onClick = { }, onMenuClick = { })
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun PreviewTaskCardDone() {
    val task = Task(
        id = "id",
        projectName = "Project Name",
        status = Status.Done,
        time = "10:00 am - 06:00 pm",
        title = "This is the task to perform."
    )
    MyProjectsTheme {
        Box(modifier = Modifier.padding(MyProjectsTheme.padding.m)) {
            TaskCard(task = task, onClick = { }, onMenuClick = { })
        }
    }
}
