package com.rodrigoguerrero.myprojects.shared.ui

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Transparent,
            disabledBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            unfocusedContainerColor = MyProjectsTheme.colors.softGrey,
            focusedContainerColor = MyProjectsTheme.colors.softGrey,
        ),
        shape = MyProjectsTheme.shapes.large,
        placeholder = {
            Text(
                text = placeholder,
                style = MyProjectsTheme.typography.body2
            )
        },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation
    )
}

@Preview
@Composable
private fun PreviewInputTextField() {
    MyProjectsTheme {
        InputTextField(
            value = "",
            placeholder = "Placeholder",
            leadingIcon = {
                Icon(imageVector = Icons.Outlined.Email, contentDescription = null)
            },
            onValueChange = {})
    }
}

@Preview
@Composable
private fun PreviewInputTextFieldTrailingIcon() {
    MyProjectsTheme {
        InputTextField(
            value = "",
            placeholder = "Placeholder",
            trailingIcon = {
                Icon(imageVector = Icons.Outlined.Email, contentDescription = null)
            },
            onValueChange = {}
        )
    }
}