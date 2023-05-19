package com.rodrigoguerrero.myprojects.projects.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.R
import com.rodrigoguerrero.myprojects.shared.ui.IconRadioButton
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

@Composable
fun VisibilitySelection(
    isPublicSelected: Boolean,
    onOptionSelected: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .selectableGroup()
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconRadioButton(
            icon = Icons.Outlined.Person,
            text = stringResource(R.string.visibility_public),
            isSelected = isPublicSelected,
            onClick = { onOptionSelected(true) }
        )
        IconRadioButton(
            icon = Icons.Outlined.Lock,
            text = stringResource(R.string.visibility_private),
            isSelected = !isPublicSelected,
            onClick = { onOptionSelected(false) }
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun PreviewVisibilitySection() {
    MyProjectsTheme {
        VisibilitySelection(isPublicSelected = true, onOptionSelected = {})
    }
}
