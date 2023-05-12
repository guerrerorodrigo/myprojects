import com.rodrigoguerrero.convention.AppConfig

plugins {
    id("my.android.application")
    id("my.android.hilt")
}

android {
    namespace = AppConfig.namespace

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
