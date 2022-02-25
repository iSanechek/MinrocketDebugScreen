pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "DebugScreen"
include(":feature-toggle-shared-module")
include(":debug-screen-module")
include(":android-sample")
include(":modo-android-compose")
