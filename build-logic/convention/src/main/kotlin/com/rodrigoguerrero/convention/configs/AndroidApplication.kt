package com.rodrigoguerrero.convention.configs

import com.android.build.api.dsl.ApplicationExtension
import com.rodrigoguerrero.convention.AppConfig

internal fun configureAndroidApplication(
    applicationExtension: ApplicationExtension
) {
    applicationExtension.apply {
        defaultConfig {
            applicationId = AppConfig.applicationId
            versionName = AppConfig.version

            minSdk = AppConfig.minSdk
            targetSdk = AppConfig.targetSdk
            versionName = AppConfig.version
            versionCode = AppConfig.versionCode

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }
}
