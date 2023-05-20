package com.rodrigoguerrero.myprojects.navigation

import androidx.navigation.NavController

internal fun NavController.navigateAndPopUp(destination: String) {
    navigate(route = destination) {
        graph.startDestinationRoute?.let { route ->
            popUpTo(route)
        }
        launchSingleTop = true
        restoreState = true
    }
}
