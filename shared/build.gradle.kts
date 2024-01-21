plugins {
    kotlin(Dependencies.Plugins.kotlinMultiplatform)
    id(Dependencies.Plugins.androidLibrary)
    kotlin(Dependencies.Plugins.serialization) version Versions.Plugins.serialization
}

kotlin {
    android()

    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Dependencies.eventBus)
                implementation(Dependencies.Koin.core)
                implementation(Dependencies.serialization)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(Dependencies.Koin.test)
            }
        }
        val androidMain by getting
        val androidTest by getting
    }
}

android {
    namespace = "com.digitalsamurai.standaggregator"
    compileSdk = 32
    defaultConfig {
        minSdk = 21
    }
}