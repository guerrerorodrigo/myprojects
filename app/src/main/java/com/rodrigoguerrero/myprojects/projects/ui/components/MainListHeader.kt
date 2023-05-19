package com.rodrigoguerrero.myprojects.projects.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

@Composable
fun MainListHeader(
    modifier: Modifier = Modifier,
    title: String,
    buttonText: String,
    onViewAll: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, style = MyProjectsTheme.typography.heading3)
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = buttonText,
            style = MyProjectsTheme.typography.titleButton,
            color = MyProjectsTheme.colors.black.copy(alpha = 0.6f),
            modifier = Modifier.clickable { onViewAll() }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewMainListHeader() {
    MyProjectsTheme {
        MainListHeader(title = "Recent Projects", buttonText = "View All", onViewAll = { })
    }
}
