package com.rodrigoguerrero.myprojects.onboarding.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.R
import com.rodrigoguerrero.myprojects.shared.ui.PagerProgressIndicator
import com.rodrigoguerrero.myprojects.shared.ui.SecondaryButton
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

internal const val onBoardingPages = 3

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingInfo(
    onLogin: () -> Unit,
    onSignUp: () -> Unit,
    onGetStarted: () -> Unit,
    modifier: Modifier = Modifier,
    pagerState: PagerState = rememberPagerState(pageCount = { onBoardingPages })
) {

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(
            topStart = MyProjectsTheme.padding.m,
            topEnd = MyProjectsTheme.padding.m
        ),
        color = MyProjectsTheme.colors.purple,
        contentColor = MyProjectsTheme.colors.white
    ) {

        Column(
            modifier = Modifier.padding(bottom = MyProjectsTheme.padding.l),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(MyProjectsTheme.padding.l)
        ) {
            HorizontalPager(state = pagerState) { page ->

                val (titleRes, descriptionRes) = when (page) {
                    0 -> R.string.onboarding_title_1 to R.string.onboarding_description_1
                    1 -> R.string.onboarding_title_2 to R.string.onboarding_description_2
                    else -> R.string.onboarding_title_3 to R.string.onboarding_description_3
                }

                OnBoardingInfoSection(
                    title = stringResource(id = titleRes),
                    content = stringResource(id = descriptionRes),
                )
            }
            PagerProgressIndicator(
                numberOfPages = onBoardingPages,
                currentPage = pagerState.currentPage,
            )
            if (pagerState.currentPage == onBoardingPages - 1) {
                SecondaryButton(
                    text = stringResource(R.string.sign_up),
                    onClick = onSignUp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = MyProjectsTheme.padding.l)
                )
                SecondaryButton(
                    text = stringResource(R.string.log_in),
                    onClick = onLogin,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = MyProjectsTheme.padding.l)

                )
            } else {
                SecondaryButton(
                    text = stringResource(R.string.get_started),
                    onClick = onGetStarted
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
private fun PreviewOnBoardingInfo() {
    MyProjectsTheme {
        OnBoardingInfo(
            onLogin = { },
            onSignUp = { },
            onGetStarted = { }
        )
    }
}
