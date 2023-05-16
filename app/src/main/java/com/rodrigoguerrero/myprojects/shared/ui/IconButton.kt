package com.rodrigoguerrero.myprojects.shared.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.R
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme
import androidx.compose.material3.IconButton as ComposeIconButton

@Composable
fun IconButton(
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    ComposeIconButton(
        onClick = onClick,
        modifier = modifier
            .clip(MyProjectsTheme.shapes.large)
            .background(color = MyProjectsTheme.colors.white)
            .border(
                width = dimensionResource(id = R.dimen.border_width),
                color = MyProjectsTheme.colors.black,
                shape = MyProjectsTheme.shapes.large
            )
            .padding(horizontal = MyProjectsTheme.padding.m)
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.icon_size))
        )
    }
}

@Preview
@Composable
private fun PreviewIconButton() {
    MyProjectsTheme {
        IconButton(icon = R.drawable.ic_facebook, onClick = { })
    }
}
