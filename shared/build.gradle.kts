import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

//apply(plugin = "org.jlleitschuh.gradle.ktlint")

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("com.squareup.sqldelight")
    jacoco
}

jacoco {
    toolVersion = "0.8.7-SNAPSHOT"
}

val jacocoTestReport by tasks.creating(JacocoReport::class.java) {
    val coverageSourceDirs = arrayOf(
        "src/commonMain",
        "src/androidMain"
    )

    println("buildDIr : ${buildDir}")
    println("src : ${project.projectDir}/src/commonMain/")

    val classFiles = File("${buildDir}/tmp/kotlin-classes/debug/")
        .walkBottomUp()
        .toSet()

    classDirectories.setFrom(classFiles)
    sourceDirectories.setFrom(files(coverageSourceDirs))

    executionData
        .setFrom(files("${buildDir}/jacoco/testDebugUnitTest.exec"))

    reports {
        xml.isEnabled = true
        csv.isEnabled = false
        html.isEnabled = true
        html.destination = file("${buildDir}/jacocoHtml")
    }
}

val jacocoTestCoverageVerification by tasks.creating(JacocoCoverageVerification::class.java) {
    dependsOn(jacocoTestReport)
    violationRules {
        rule {
            limit {
                minimum = "0.8".toBigDecimal()
            }
        }
    }
}

val testCoverage by tasks.registering {
    group = "verification"
    description = "Runs the unit tests with coverage."

    dependsOn("testDebugUnitTest", jacocoTestReport, jacocoTestCoverageVerification)
    tasks["jacocoTestReport"].mustRunAfter("testDebugUnitTest")
    tasks["jacocoTestCoverageVerification"].mustRunAfter("jacocoTestReport")
}

android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(30)
    }
    configurations {
        create("androidTestApi")
        create("androidTestDebugApi")
        create("androidTestReleaseApi")
        create("testApi")
        create("testDebugApi")
        create("testReleaseApi")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            useIR = true
            freeCompilerArgs = listOf("-Xallow-result-return-type")
        }
    }

    buildTypes {
        getByName("debug") {
            isTestCoverageEnabled = true
        }
//        debug {
//            buildConfigField("String", "API_URL", "https://api.themoviedb.org/3/")
//        }
    }


}

kotlin {
    android()
    ios {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }

    val ktorVersion = "1.4.0"
    val serializationVersion = "1.0.0-RC"
    val sqlDelightVersion = "1.4.4"
    val coroutinesVersion = "1.4.3"
    val kodeinVersion = "7.4.0"

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$serializationVersion")
                implementation("io.ktor:ktor-client-serialization:$ktorVersion")
                implementation("com.squareup.sqldelight:runtime:$sqlDelightVersion")
                implementation("org.kodein.di:kodein-di:$kodeinVersion")
                implementation("io.ktor:ktor-client-logging:$ktorVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation("io.ktor:ktor-client-mock:$ktorVersion")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("com.google.android.material:material:1.2.1")
                implementation("io.ktor:ktor-client-android:$ktorVersion")
                implementation("com.squareup.sqldelight:android-driver:$sqlDelightVersion")
                implementation("org.kodein.di:kodein-di-framework-android-x:$kodeinVersion")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13")
                implementation("io.mockk:mockk:1.10.6")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-ios:$ktorVersion")
                implementation("com.squareup.sqldelight:native-driver:$sqlDelightVersion")
            }
        }
        val iosTest by getting
    }

    val onPhone = System.getenv("SDK_NAME")?.startsWith("iphoneos") ?: false
    if (onPhone) {
        iosArm64("ios")
    } else {
        iosX64("ios")
    }
}

val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework =
        kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}

tasks.getByName("build").dependsOn(packForXcode)

sqldelight {
    database("AppDatabase") {
        packageName = "br.com.concrete.composekmmmoviesapp.cache"
    }
}
