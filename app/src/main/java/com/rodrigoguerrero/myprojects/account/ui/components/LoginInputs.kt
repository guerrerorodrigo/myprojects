package com.rodrigoguerrero.myprojects.account.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.R
import com.rodrigoguerrero.myprojects.shared.ui.InputTextField
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

@Composable
fun LoginInputs(
    modifier: Modifier = Modifier,
    email: String,
    password: String,
    isPasswordVisible: Boolean,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onIsPasswordVisibleChange: () -> Unit,
    onForgotPassword: () -> Unit
) {
    Column(
        modifier = modifier.padding(
            horizontal = MyProjectsTheme.padding.m,
            vertical = MyProjectsTheme.padding.ml
        ),
        verticalArrangement = Arrangement.spacedBy(MyProjectsTheme.padding.m)
    ) {
        Text(
            text = stringResource(R.string.sign_in_to_your_account),
            style = MyProjectsTheme.typography.body2,
            color = MyProjectsTheme.colors.black
        )
        InputTextField(
            modifier = Modifier.fillMaxWidth(),
            value = email,
            placeholder = stringResource(R.string.type_your_email),
            onValueChange = onEmailChange,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Email,
                    contentDescription = null,
                    tint = MyProjectsTheme.colors.black
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        InputTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            placeholder = stringResource(R.string.type_your_password),
            onValueChange = onPasswordChange,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Lock,
                    contentDescription = null,
                    tint = MyProjectsTheme.colors.black
                )
            },
            trailingIcon = {
                IconButton(onClick = onIsPasswordVisibleChange) {
                    Icon(
                        imageVector = if (isPasswordVisible) {
                            Icons.Outlined.Visibility
                        } else {
                            Icons.Outlined.VisibilityOff
                        },
                        contentDescription = null,
                        tint = MyProjectsTheme.colors.black
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                autoCorrect = false
            ),
            visualTransformation = if (isPasswordVisible) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            }
        )
        Text(
            modifier = Modifier
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null
                ) {
                    onForgotPassword()
                }
                .fillMaxWidth(),
            text = stringResource(R.string.forgot_password),
            style = MyProjectsTheme.typography.heading9,
            color = MyProjectsTheme.colors.purple,
            textAlign = TextAlign.End
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun PreviewLoginInputs() {
    MyProjectsTheme {
        LoginInputs(
            email = "",
            password = "",
            isPasswordVisible = false,
            onEmailChange = { },
            onPasswordChange = { },
            onIsPasswordVisibleChange = { },
            onForgotPassword = { }
        )
    }
}
