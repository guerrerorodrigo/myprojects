package com.rodrigoguerrero.myprojects.projects.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.R
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

@Composable
fun EmptyScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(all = MyProjectsTheme.padding.xl),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.empty),
            contentDescription = null,
            modifier = Modifier.padding(bottom = MyProjectsTheme.padding.l)
        )
        Text(
            text = stringResource(R.string.empty_title),
            style = MyProjectsTheme.typography.heading5,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = MyProjectsTheme.padding.m)
        )
        Text(
            text = stringResource(R.string.empty_description),
            style = MyProjectsTheme.typography.body9,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun PreviewEmptyScreen() {
    MyProjectsTheme {
        EmptyScreen()
    }
}
