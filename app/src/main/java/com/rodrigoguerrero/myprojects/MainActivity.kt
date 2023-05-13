package com.rodrigoguerrero.myprojects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.rodrigoguerrero.myprojects.onboarding.ui.screens.OnBoardingScreen
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
                    OnBoardingScreen(
                        onLogin = { },
                        onSignUp = { },
                        onGetStarted = { }
                    )
                }
            }
        }
    }
}
