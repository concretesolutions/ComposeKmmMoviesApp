plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-android")
}

android {
    compileSdk = 30

    defaultConfig {
        minSdk = 21
        targetSdk = 30

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
}

val retrofitVersion = "2.9.0"
val okHttpVersion = "4.9.1"
val coroutinesVersion = "1.4.3"
val koinVersion = "2.2.2"
val roomVersion = "2.2.6"


dependencies {
    implementation(libs.ktx.core)
    implementation(libs.appcompat)
    implementation(libs.material)

    // Compose
    implementation(libs.bundles.compose)
    implementation(libs.navigation.compose)
    implementation(libs.accompanist)

    // Unit test
    testImplementation(libs.koin.test)
    testImplementation(libs.androidx.coretesting)
    testImplementation(libs.coroutines.test)
    testImplementation(libs.mockk)
    testImplementation(libs.androidx.junit)
    testImplementation(libs.espresso.core)
    testImplementation(libs.robolectric)
    testImplementation(libs.junit)

    // Instrumented tests
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.compose.junit4)
}
