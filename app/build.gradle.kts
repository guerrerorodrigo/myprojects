import com.rodrigoguerrero.convention.AppConfig

plugins {
    id("my.android.application")
    id("my.android.hilt")
    id("my.android.application.compose")
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

dependencies {
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.io.coil.ktx.compose)
    implementation(libs.org.jetbrains.kotlinx.collections.immutable)
}
