package com.rodrigoguerrero.myprojects.onboarding.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

@Composable
fun OnBoardingInfoSection(
    title: String,
    content: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(MyProjectsTheme.padding.l),
        verticalArrangement = Arrangement.spacedBy(MyProjectsTheme.padding.l)
    ) {
        Text(
            text = title,
            style = MyProjectsTheme.typography.heading1,
            textAlign = TextAlign.Center
        )
        Text(
            text = content,
            style = MyProjectsTheme.typography.body9,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun PreviewOnBoardingInfoSection() {
    MyProjectsTheme {
        OnBoardingInfoSection(
            title = "Project Planning App for Everyone",
            content = "Amet minim mollit non deserunt ullamco est sit aliqua dolor do amet sint. " +
                    "Velit officia consequat  est sit aliqua dolor do amet.",
        )
    }
}
