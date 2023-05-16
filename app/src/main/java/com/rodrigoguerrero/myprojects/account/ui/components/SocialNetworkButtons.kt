package com.rodrigoguerrero.myprojects.account.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.R
import com.rodrigoguerrero.myprojects.shared.ui.IconButton
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

@Composable
fun SocialNetworkButtons(
    onFacebook: () -> Unit,
    onGoogle: () -> Unit,
    onApple: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = MyProjectsTheme.padding.xl),
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
            icon = R.drawable.ic_facebook,
            onClick = onFacebook,
            modifier = Modifier.padding(end = MyProjectsTheme.padding.m)
        )
        IconButton(
            icon = R.drawable.ic_google,
            onClick = onGoogle,
            modifier = Modifier.padding(end = MyProjectsTheme.padding.m)
        )
        IconButton(
            icon = R.drawable.ic_apple,
            onClick = onApple
        )
    }
}

@Preview
@Composable
private fun PreviewSocialNetworkButtons() {
    MyProjectsTheme {
        SocialNetworkButtons(
            onFacebook = { },
            onGoogle = { },
            onApple = { }
        )
    }
}
