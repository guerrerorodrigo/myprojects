package com.rodrigoguerrero.myprojects.onboarding.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.R
import com.rodrigoguerrero.myprojects.onboarding.ui.components.OnBoardingInfo
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    onLogin: () -> Unit,
    onSignUp: () -> Unit,
    onGetStarted: () -> Unit,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = MyProjectsTheme.padding.m),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val imageRes = when (pagerState.currentPage) {
            0 -> R.drawable.onboarding1
            1 -> R.drawable.onboarding2
            else -> R.drawable.onboarding3
        }

        Spacer(modifier = Modifier.weight(1f))

        Image(painter = painterResource(id = imageRes), contentDescription = null)

        Spacer(modifier = Modifier.weight(1f))

        OnBoardingInfo(
            onLogin = onLogin,
            onSignUp = onSignUp,
            onGetStarted = onGetStarted,
            pagerState = pagerState
        )
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
private fun PreviewOnBoardingScreen() {
    MyProjectsTheme {
        Surface(color = MyProjectsTheme.colors.white) {
            OnBoardingScreen(
                onGetStarted = { },
                onLogin = { },
                onSignUp = { }
            )
        }
    }
}
