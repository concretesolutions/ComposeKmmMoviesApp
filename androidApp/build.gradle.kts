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

        buildConfigField("String", "MoviesDbApiKey", localProperties["apiKey"].toString() )

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
        freeCompilerArgs = listOf("-Xallow-result-return-type")
    }

    buildFeatures {
        compose = true
    }

    testOptions.unitTests.apply {
        isIncludeAndroidResources = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
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

val retrofitVersion = "2.9.0"
val okHttpVersion = "4.9.1"
val coroutinesVersion = "1.4.3"
val koinVersion = "2.2.2"
val roomVersion = "2.2.6"

dependencies {

    //Modulo Components
    implementation(project(":components"))

    // Shared
    implementation(project(":shared"))

    // Android X & Material
    implementation("androidx.core:core-ktx:1.3.2")
    implementation ("androidx.appcompat:appcompat:1.3.0-beta01")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")

    // Compose
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    implementation("androidx.compose.runtime:runtime-livedata:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.material:material-icons-core:$composeVersion")
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")
    implementation("androidx.navigation:navigation-compose:1.0.0-alpha09")
    implementation("dev.chrisbanes.accompanist:accompanist-coil:0.6.2")

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha03")

    // Compose integrations
    implementation("androidx.activity:activity-compose:1.3.0-alpha04")

    // Networking
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.okhttp3:okhttp:$okHttpVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$okHttpVersion")

    // DI
    implementation("org.koin:koin-core:$koinVersion")
    implementation("org.koin:koin-androidx-viewmodel:$koinVersion")

    // Threading
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    // DB
    implementation("androidx.room:room-runtime:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")

    // Unit test
    testImplementation("org.koin:koin-test:$koinVersion")
    testImplementation("junit:junit:4.13.2")
    testImplementation("com.squareup.retrofit2:retrofit-mock:$retrofitVersion")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")
    testImplementation("io.mockk:mockk:1.11.0")
    testImplementation("androidx.test.ext:junit:1.1.2")
    testImplementation("androidx.test.espresso:espresso-core:3.3.0")
    testImplementation("org.robolectric:robolectric:4.5.1")
    testImplementation("androidx.arch.core:core-testing:2.1.0")
    testImplementation("androidx.room:room-testing:$roomVersion")

    // Instrumented tests
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")

    //Kodein
    implementation("org.kodein.di:kodein-di-framework-android-x:$kodeinVersion")
}
