package com.rodrigoguerrero.myprojects.projects.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.R
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

@Composable
fun ProgressStatusIndicator(
    modifier: Modifier = Modifier,
    progressBackgroundColor: Color,
    progressColor: Color,
    progress: Float,
    @StringRes status: Int
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(MyProjectsTheme.padding.s)
    ) {
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .clip(MyProjectsTheme.shapes.large),
            trackColor = progressBackgroundColor.copy(alpha = 0.16f),
            color = progressColor,
            strokeCap = StrokeCap.Round,
            progress = progress
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = status),
                style = MyProjectsTheme.typography.caption6
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(
                    id = R.string.project_percentage,
                    (progress * 100).toInt()
                ),
                style = MyProjectsTheme.typography.caption6
            )
        }
    }
}

@Preview
@Composable
private fun PreviewProgressStatusIndicator() {
    MyProjectsTheme {
        ProgressStatusIndicator(
            progressBackgroundColor = MyProjectsTheme.colors.black,
            progress = 0.78f,
            status = R.string.status_in_progress,
            progressColor = MyProjectsTheme.colors.green
        )
    }
}
