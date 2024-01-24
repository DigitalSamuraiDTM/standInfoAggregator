plugins {
    kotlin(Dependencies.Plugins.kotlinMultiplatform)
    id(Dependencies.Plugins.androidLibrary)
    kotlin(Dependencies.Plugins.serialization) version Versions.Plugins.serialization
}

kotlin {
    android()

    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = Versions.jvm
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
//                implementation(Dependencies.eventBus)
//                implementation(Dependencies.Koin.core)
//                implementation(Dependencies.serialization)
            }
        }
        val androidMain by getting
    }
}

android {
    namespace = "com.digitalsamurai.standaggregator"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}