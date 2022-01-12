
object Versions {
    internal const val koin = "3.1.4"
    internal const val coreKtxVersion = "1.7.0"
    internal const val appCompatVersion = "1.4.0"
    internal const val activityComposeVersion = "1.4.0"
    internal const val materialVersion = "1.4.0"
    internal const val composeVersion = "1.1.0-rc01"
    internal const val junitVersion = "4.13.2"
    internal const val junitExtVersion = "1.1.3"
    internal const val espressoVersion = "3.4.0"
    internal const val modoVersion = "0.6.2"
    internal const val lifecycleVersion = "2.4.0"
}

object Libs {

    object Testing {
        const val junit = "junit:junit:${Versions.junitVersion}"
        const val junitExt = "androidx.test.ext:junit:${Versions.junitExtVersion}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
    }

    object Koin {
        const val android = "io.insert-koin:koin-android:${Versions.koin}"
        const val core = "io.insert-koin:koin-core:${Versions.koin}"
    }

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
        const val lifecycleKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
        const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycleVersion}"
    }

    object Material {
        const val material = "com.google.android.material:material:${Versions.materialVersion}"
    }

    object Modo {
        const val core = "com.github.terrakok:modo:${Versions.modoVersion}"
    }

    object Compose {
        const val activity = "androidx.activity:activity-compose:${Versions.activityComposeVersion}"
        const val runtime = "androidx.compose.runtime:runtime:${Versions.composeVersion}"
        const val ui = "androidx.compose.ui:ui:${Versions.composeVersion}"
        const val foundation = "androidx.compose.foundation:foundation:${Versions.composeVersion}"
        const val foundationLayout =
            "androidx.compose.foundation:foundation-layout:${Versions.composeVersion}"
        const val material = "androidx.compose.material:material:${Versions.composeVersion}"
        const val animation = "androidx.compose.animation:animation:${Versions.composeVersion}"
        const val tooling = "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"
    }

    // Deps for screen module
    val screenLibs = listOf(
        AndroidX.appCompat,
        AndroidX.coreKtx,
        AndroidX.lifecycleKtx,
        Compose.activity,
        Compose.runtime,
        Compose.ui,
        Compose.foundation,
        Compose.foundationLayout,
        Compose.material,
        Compose.animation,
        Compose.tooling,
        Material.material,
        Koin.android
    )
}