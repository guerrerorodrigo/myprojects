import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

internal class HiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("dagger.hilt.android.plugin")
                apply("org.jetbrains.kotlin.kapt")
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                add("implementation", libs.findLibrary("com.google.dagger.hilt.android").get())
                add("kapt", libs.findLibrary("com.google.dagger.hilt.android.compiler").get())
                add(
                    "kaptAndroidTest",
                    libs.findLibrary("com.google.dagger.hilt.android.compiler").get()
                )
            }
        }
    }
}
