package com.rodrigoguerrero.myprojects.shared.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.R
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

@Composable
fun PagerProgressIndicator(
    numberOfPages: Int,
    currentPage: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(numberOfPages) { iteration ->
            val color = if (currentPage == iteration ) {
                MyProjectsTheme.colors.white
            } else {
                MyProjectsTheme.colors.white.copy(alpha = 0.25f)
            }
            Box(
                modifier = Modifier
                    .padding(MyProjectsTheme.padding.s)
                    .clip(CircleShape)
                    .background(color)
                    .size(dimensionResource(id = R.dimen.circle_indicator_size))
            )
        }
    }
}

@Preview
@Composable
private fun PreviewPagerProgressIndicator() {
    MyProjectsTheme {
        PagerProgressIndicator(numberOfPages = 3, currentPage = 2)
    }
}
