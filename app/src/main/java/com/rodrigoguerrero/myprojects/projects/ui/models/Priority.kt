package com.rodrigoguerrero.myprojects.projects.ui.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.ui.graphics.vector.ImageVector
import com.rodrigoguerrero.myprojects.R

enum class Priority(
    @StringRes val priorityRes: Int,
    val icon: ImageVector? = null
) {
    Low(R.string.priority_low),
    Normal(R.string.priority_normal),
    High(R.string.priority_high, Icons.Filled.Flag)
}
