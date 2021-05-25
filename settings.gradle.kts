enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
        mavenCentral()
    }
    
}
rootProject.name = "ComposeKmmMoviesApp"


include(":androidApp")
include(":shared")
include(":components")
