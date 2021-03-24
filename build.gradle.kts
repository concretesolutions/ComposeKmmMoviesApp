buildscript {
    val kotlinVersion by extra { "1.4.31" }
    val composeVersion by extra { "1.0.0-beta02" }
    val sqlDelightVersion by extra { "1.4.4" }
    val kodeinVersion by extra { "7.4.0" }

    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("com.android.tools.build:gradle:7.0.0-alpha10")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
        classpath("com.squareup.sqldelight:gradle-plugin:$sqlDelightVersion")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:10.0.0")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}