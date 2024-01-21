pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "standInfoAggregator"
include(":androidApp")
include(":shared")
include(":shared-ui")
include(":desktop")