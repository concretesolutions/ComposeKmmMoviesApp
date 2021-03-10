buildscript {
    val kotlinVersion by extra { "1.4.30" }
    val composeVersion by extra { "1.0.0-beta01" }

    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("com.android.tools.build:gradle:7.0.0-alpha09")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()


    }
}