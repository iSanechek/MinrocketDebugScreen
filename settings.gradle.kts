pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "DebugScreen"
include(":debug-shared-module")
include(":debug-screen-module")
include(":debug-screen-sample-android")
include(":modo-render-android-compose")
include(":android-compose")
