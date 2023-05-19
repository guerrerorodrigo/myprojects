package com.rodrigoguerrero.myprojects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.rodrigoguerrero.myprojects.projects.ui.models.Project
import com.rodrigoguerrero.myprojects.projects.ui.models.Status
import com.rodrigoguerrero.myprojects.projects.ui.models.Task
import com.rodrigoguerrero.myprojects.projects.ui.screens.MainScreen
import com.rodrigoguerrero.myprojects.ui.theme.MyProjectsTheme

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
                    val project = Project(
                        id = "id",
                        title = "Banking Platform Web & Mobile App",
                        comments = 0,
                        status = Status.InProgress,
                        completedPercentage = 0.18f,
                        dueDate = "June 18, 2023",
                        color = MyProjectsTheme.colors.brightPink,
                    )

                    val task = Task(
                        id = "id",
                        projectName = "Project Name",
                        status = Status.InProgress,
                        time = "10:00 am - 06:00 pm",
                        title = "This is the task to perform."
                    )
                    MainScreen(
                        name = "Vanessa",
                        numberOfNotifications = 0,
                        recentProjects = listOf(project, project, project, project),
                        todayTasks = listOf(task, task, task, task, task, task),
                        onViewAllProjects = { },
                        onViewAllTasks = { }
                    )
                }
            }
        }
    }
}
