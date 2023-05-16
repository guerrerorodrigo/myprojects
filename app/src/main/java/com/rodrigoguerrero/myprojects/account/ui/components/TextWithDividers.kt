package com.rodrigoguerrero.myprojects.account.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

@Composable
fun TextWithDividers(
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .padding(horizontal = MyProjectsTheme.padding.m)
                .weight(1f)
                .background(MyProjectsTheme.colors.black)
        )
        Text(
            text = text,
            style = MyProjectsTheme.typography.body2,
            color = MyProjectsTheme.colors.black
        )
        Divider(
            modifier = Modifier
                .padding(horizontal = MyProjectsTheme.padding.m)
                .weight(1f)
                .background(MyProjectsTheme.colors.black)
        )
    }
}

@Preview
@Composable
private fun PreviewTextWithDividers() {
    MyProjectsTheme {
        TextWithDividers(text = "text")
    }
}
