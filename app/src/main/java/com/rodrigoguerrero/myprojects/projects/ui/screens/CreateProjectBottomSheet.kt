package com.rodrigoguerrero.myprojects.projects.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddBox
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.myprojects.R
import com.rodrigoguerrero.myprojects.projects.ui.components.VisibilitySelection
import com.rodrigoguerrero.myprojects.shared.ui.PrimaryButton
import com.rodrigoguerrero.myprojects.shared.ui.SecondaryButton
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateProjectBottomSheet(
    modifier: Modifier = Modifier,
    bottomSheetState: SheetState,
    onDismissRequest: () -> Unit,
    onAddMember: () -> Unit,
    onCreateProject: () -> Unit
) {
    ModalBottomSheet(
        modifier = modifier,
        onDismissRequest = onDismissRequest,
        sheetState = bottomSheetState,
        shape = RoundedCornerShape(
            topStart = dimensionResource(id = R.dimen.bottom_sheet_radius),
            topEnd = dimensionResource(id = R.dimen.bottom_sheet_radius)
        ),
        containerColor = MyProjectsTheme.colors.white,
        contentColor = MyProjectsTheme.colors.black
    ) {
        var projectName by remember { mutableStateOf("") }
        var isPublicSelected by remember { mutableStateOf(true) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = MyProjectsTheme.padding.m),
            verticalArrangement = Arrangement.spacedBy(MyProjectsTheme.padding.ml)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.create_project),
                    style = MyProjectsTheme.typography.heading5
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = onDismissRequest) {
                    Icon(imageVector = Icons.Outlined.Close, contentDescription = null)
                }
            }

            TextField(
                value = projectName,
                onValueChange = { projectName = it },
                modifier = Modifier.fillMaxWidth(),
                textStyle = MyProjectsTheme.typography.heading10,
                placeholder = {
                    Text(
                        text = stringResource(R.string.project_name),
                        style = MyProjectsTheme.typography.heading10
                    )
                },
                maxLines = 1,
                minLines = 1,
                shape = MyProjectsTheme.shapes.large,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MyProjectsTheme.colors.softGrey,
                    unfocusedContainerColor = MyProjectsTheme.colors.softGrey,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            Text(
                text = stringResource(R.string.visibility),
                style = MyProjectsTheme.typography.heading5
            )

            VisibilitySelection(
                isPublicSelected = isPublicSelected,
                onOptionSelected = { isPublicSelected = !isPublicSelected }
            )

            SecondaryButton(
                text = stringResource(R.string.add_member),
                onClick = onAddMember,
                modifier = Modifier.fillMaxWidth(),
                border = BorderStroke(
                    width = dimensionResource(id = R.dimen.border_width),
                    color = MyProjectsTheme.colors.purple
                ),
                icon = Icons.Outlined.AddBox
            )
            PrimaryButton(
                text = stringResource(R.string.create_project_bottom_sheet),
                onClick = onCreateProject,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun PreviewCreateProjectBottomSheet() {
    MyProjectsTheme {
        CreateProjectBottomSheet(
            bottomSheetState = rememberModalBottomSheetState(),
            onDismissRequest = { },
            onCreateProject = { },
            onAddMember = { }
        )
    }
}
