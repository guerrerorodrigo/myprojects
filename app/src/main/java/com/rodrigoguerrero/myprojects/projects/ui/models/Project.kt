package com.rodrigoguerrero.myprojects.projects.ui.models

import androidx.compose.ui.graphics.Color

data class Project(
    val id: String,
    val title: String,
    val dueDate: String,
    val comments: Int,
    val numberOfAttachments: Int,
    val status: Status,
    val completedPercentage: Float,
    val color: Color = Color.Transparent,
    val priority: Priority? = null,
) {
    val hasDefaultBackgroundColor: Boolean
        get() {
            return color == Color.Transparent
        }
}
