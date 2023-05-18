package com.rodrigoguerrero.myprojects.projects.ui.models

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.rodrigoguerrero.myprojects.R
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsColors

enum class Status(
    @StringRes val statusRes: Int,
    val color: Color
) {
    ToDo(statusRes = R.string.status_to_do, color = MyProjectsColors().blue),
    InProgress(statusRes = R.string.status_in_progress, color = MyProjectsColors().green),
    Done(statusRes = R.string.status_done, color = MyProjectsColors().purple)
}
