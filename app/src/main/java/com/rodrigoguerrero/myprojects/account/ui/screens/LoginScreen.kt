package com.rodrigoguerrero.myprojects.account.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.R
import com.rodrigoguerrero.myprojects.account.ui.components.LoginInputs
import com.rodrigoguerrero.myprojects.account.ui.components.SocialNetworkButtons
import com.rodrigoguerrero.myprojects.account.ui.components.TextWithDividers
import com.rodrigoguerrero.myprojects.shared.ui.PrimaryButton
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onForgotPassword: () -> Unit,
    onSignIn: () -> Unit,
    onFacebook: () -> Unit,
    onGoogle: () -> Unit,
    onApple: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.padding(horizontal = MyProjectsTheme.padding.m),
                title = {
                    Text(
                        text = stringResource(R.string.sign_in),
                        style = MyProjectsTheme.typography.heading5,
                    )
                },
                navigationIcon = {
                    Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = null)
                }
            )
        }
    ) { padding ->
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var isPasswordVisible by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = rememberScrollState())
                .padding(padding)
        ) {
            Divider(
                color = MyProjectsTheme.colors.black,
                modifier = Modifier.fillMaxWidth(),
            )
            LoginInputs(
                email = email,
                password = password,
                isPasswordVisible = isPasswordVisible,
                onEmailChange = { email = it },
                onPasswordChange = { password = it },
                onIsPasswordVisibleChange = { isPasswordVisible = !isPasswordVisible },
                onForgotPassword = onForgotPassword
            )
            Spacer(modifier = Modifier.height(MyProjectsTheme.padding.l))
            PrimaryButton(
                text = stringResource(R.string.sign_in_button),
                onClick = onSignIn,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MyProjectsTheme.padding.m)
            )
            Spacer(
                modifier = Modifier
                    .height(dimensionResource(id = R.dimen.social_network_options_top_padding))
            )
            TextWithDividers(
                text = stringResource(R.string.or_continue_with),
                modifier = Modifier.fillMaxWidth()
            )
            SocialNetworkButtons(
                onFacebook = onFacebook,
                onGoogle = onGoogle,
                onApple = onApple
            )
            Spacer(modifier = Modifier.height(MyProjectsTheme.padding.xl))
            Text(
                text = buildAnnotatedString {
                    append(stringResource(R.string.dont_have_an_account))
                    append(" ")
                    withStyle(
                        style = SpanStyle(
                            color = MyProjectsTheme.colors.purple,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(stringResource(R.string.sign_up_login_screen))
                    }
                },
                style = MyProjectsTheme.typography.body6,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = MyProjectsTheme.padding.m),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
private fun PreviewLoginScreen() {
    MyProjectsTheme {
        LoginScreen(
            onForgotPassword = { },
            onSignIn = { },
            onApple = { },
            onFacebook = { },
            onGoogle = { }
        )
    }
}
