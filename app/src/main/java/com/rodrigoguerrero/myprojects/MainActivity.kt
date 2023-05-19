package com.rodrigoguerrero.myprojects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rodrigoguerrero.myprojects.projects.ui.components.MainBottomBar
import com.rodrigoguerrero.myprojects.projects.ui.screens.CreateProjectBottomSheet
import com.rodrigoguerrero.myprojects.projects.ui.screens.MainScreen
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme
import kotlinx.collections.immutable.persistentListOf

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        setContent {
            MyProjectsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MyProjectsTheme.colors.white
                ) {
                    val navController = rememberNavController()
                    val bottomSheetState =
                        rememberModalBottomSheetState(skipPartiallyExpanded = true)
                    var showBottomSheet by rememberSaveable { mutableStateOf(false) }

                    Scaffold(
                        bottomBar = {
                            MainBottomBar(
                                onListClick = { },
                                onTaskClick = { },
                                onMessageClick = { },
                                onProfileClick = { },
                                onNewProjectClick = {
                                    showBottomSheet = !showBottomSheet
                                }
                            )
                        }
                    ) { padding ->
                        NavHost(
                            navController = navController,
                            startDestination = "home",
                            modifier = Modifier.padding(padding)
                        ) {
                            composable("home") {
                                MainScreen(
                                    name = "Vanessa",
                                    numberOfNotifications = 0,
                                    recentProjects = persistentListOf(),
                                    todayTasks = persistentListOf(),
                                    onViewAllProjects = { },
                                    onViewAllTasks = { }
                                )
                            }
                        }

                        if (showBottomSheet) {
                            CreateProjectBottomSheet(
                                bottomSheetState = bottomSheetState,
                                onDismissRequest = { showBottomSheet = false },
                                onAddMember = { showBottomSheet = false },
                                onCreateProject = { showBottomSheet = false }
                            )
                        }
                    }

                }
            }
        }
    }
}
