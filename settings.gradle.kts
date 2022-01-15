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
include(":debug-screen-start")
include(":modo-render-android-compose")
include(":android-compose")
