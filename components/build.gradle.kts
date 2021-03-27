plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-android")
}
val composeVersion: String by project

android {
    compileSdkVersion(30)
    //buildToolsVersion "30.0.3"

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        //consumerProguardFiles "consumer-rules.pro"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            //proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
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
}

val retrofitVersion = "2.9.0"
val okHttpVersion = "4.9.1"
val coroutinesVersion = "1.4.3"
val koinVersion = "2.2.2"
val roomVersion = "2.2.6"


dependencies {

    implementation ("androidx.core:core-ktx:1.3.2")
    implementation ("androidx.appcompat:appcompat:1.3.0-beta01")
    implementation ("com.google.android.material:material:1.3.0")

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
    implementation("androidx.activity:activity-compose:1.3.0-alpha05")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

    // Unit test
    testImplementation("org.koin:koin-test:$koinVersion")
    testImplementation("junit:junit:4.13.2")
    testImplementation("com.squareup.retrofit2:retrofit-mock:$retrofitVersion")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion")
    testImplementation("io.mockk:mockk:1.10.6")
    testImplementation("androidx.test.ext:junit:1.1.2")
    testImplementation("androidx.test.espresso:espresso-core:3.3.0")
    testImplementation("org.robolectric:robolectric:4.5.1")
    testImplementation("androidx.arch.core:core-testing:2.1.0")
    testImplementation("androidx.room:room-testing:$roomVersion")

    // Instrumented tests
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
}
