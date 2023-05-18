package com.rodrigoguerrero.myprojects.projects.ui.models

import androidx.annotation.StringRes
import com.rodrigoguerrero.myprojects.R

enum class Status(
    @StringRes val statusRes: Int
) {
    ToDo(R.string.status_to_do),
    InProgress(R.string.status_in_progress),
    Done(R.string.status_done)
}
