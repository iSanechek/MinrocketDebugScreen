plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.mintrocket.debug_screen_sample_android"
        minSdk = 23
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":debug-screen-module"))

    implementation("androidx.core:core-ktx:1.7.0")


    implementation("androidx.compose.runtime:runtime:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.ui:ui:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.foundation:foundation:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.foundation:foundation-layout:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.material:material:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.material:material-icons-extended:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.animation:animation:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.ui:ui-tooling:1.1.0-rc01")


    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation("androidx.activity:activity-compose:1.4.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${rootProject.extra["compose_version"]}")
    debugImplementation("androidx.compose.ui:ui-tooling:${rootProject.extra["compose_version"]}")
}