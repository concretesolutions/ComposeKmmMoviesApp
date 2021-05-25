import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
}
val composeVersion: String by project
val kodeinVersion: String by project

val localProperties = Properties()
try {
    localProperties.load(FileInputStream("local.properties"))
} catch (ex: java.io.IOException) {
    localProperties["apiKey"] = "\"Insert your key in local.properties;\""
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "br.com.concrete.composemovies"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "MoviesDbApiKey", localProperties["apiKey"].toString())

        javaCompileOptions {
            annotationProcessorOptions {
                argument("room.incremental", "true")
            }
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }

    buildFeatures {
        compose = true
    }

    testOptions.unitTests.apply {
        isIncludeAndroidResources = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }
    packagingOptions {
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/LICENSE")
        exclude("META-INF/LICENSE.txt")
        exclude("META-INF/license.txt")
        exclude("META-INF/NOTICE")
        exclude("META-INF/NOTICE.txt")
        exclude("META-INF/notice.txt")
        exclude("META-INF/ASL2.0")
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
        exclude("META-INF/*.kotlin_module")
    }
}

dependencies {
    //Modulo Components
    implementation(project(":components"))

    // Shared
    implementation(project(":shared"))

    // Android X & Material
    implementation(libs.ktx.core)
    implementation(libs.material)
    implementation(libs.lifecycleruntime)
    implementation(libs.lifecyclelivedata)

    // Compose
    implementation(libs.bundles.compose)
    implementation(libs.navigation.compose)
    implementation(libs.accompanist)

    implementation(libs.compose.viewmodel)

    // Networking
    implementation(libs.bundles.retrofit)

    // DI
    implementation(libs.bundles.koinandroid)

    // Threading
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)

    // DB
    implementation(libs.room.core)
    kapt(libs.room.compiler)
    implementation(libs.room.ktx)

    // Unit test
    testImplementation(libs.koin.test)
    testImplementation(libs.junit)
    testImplementation(libs.retrofit.mock)
    testImplementation(libs.coroutines.test)
    testImplementation(libs.mockk)
    testImplementation(libs.androidx.junit)
    testImplementation(libs.espresso.core)
    testImplementation(libs.robolectric)
    testImplementation(libs.androidx.coretesting)
    testImplementation(libs.room.test)

    // Instrumented tests
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.compose.junit4)

    //Kodein
    implementation("org.kodein.di:kodein-di-framework-android-x:$kodeinVersion")
}
