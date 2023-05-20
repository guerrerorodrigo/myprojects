package com.rodrigoguerrero.myprojects.navigation

sealed class Destination(
    val route: String
) {
    object Home : Destination("home")
    object ProjectsList : Destination("project-list")
}
