buildscript {
    val kotlinVersion by extra { "1.4.31" }
    val composeVersion by extra { "1.0.0-beta02" }
    val sqlDelightVersion by extra { "1.4.4" }
    val kodeinVersion by extra { "7.4.0" }

    repositories {
        gradlePluginPortal()
        google()
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("com.android.tools.build:gradle:7.0.0-alpha10")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
        classpath("com.squareup.sqldelight:gradle-plugin:$sqlDelightVersion")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        mavenCentral()
    }
}