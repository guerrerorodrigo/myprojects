plugins {
    `kotlin-dsl`
}

group = "com.rodrigoguerrero.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.com.android.tools.build.gradle)
    compileOnly(libs.org.jetbrains.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "my.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidAppCompose") {
            id = "my.android.application.compose"
            implementationClass = "ComposeConventionPlugin"
        }
        register("androidHilt") {
            id = "my.android.hilt"
            implementationClass = "HiltConventionPlugin"
        }
        register("unitTest") {
            id = "my.unit.test"
            implementationClass = "TestConventionPlugin"
        }
    }
}
