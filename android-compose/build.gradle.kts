plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 23
        targetSdk = 31

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.0-rc02"
    }
}

dependencies {
    implementation(Libs.Koin.android)

    implementation(Libs.Compose.runtime)
    implementation(Libs.Compose.ui)
    implementation(Libs.AndroidX.viewModelCompose)

    testImplementation(Libs.Testing.junit)
    androidTestImplementation(Libs.Testing.espresso)
    androidTestImplementation(Libs.Testing.junitExt)

}