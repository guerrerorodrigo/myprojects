package com.rodrigoguerrero.myprojects.projects.ui.models

data class Task(
    val id: String,
    val title: String,
    val projectName: String,
    val time: String,
    val status: Status
)
