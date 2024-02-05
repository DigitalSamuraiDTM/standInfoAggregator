import org.gradle.api.internal.artifacts.dependencies.DefaultExternalModuleDependency

plugins {
    kotlin(Dependencies.Plugins.kotlinMultiplatform)
    id(Dependencies.Plugins.androidLibrary)
    kotlin(Dependencies.Plugins.serialization) version Versions.Plugins.serialization
    kotlin("kapt")
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
                configurations.get("kapt").dependencies.add(DefaultExternalModuleDependency("com.google.dagger", "dagger-compiler", "2.44.2"))
                implementation("com.google.dagger:dagger:2.44.2")
            }
        }
        val androidMain by getting {
            dependencies {
                configurations.get("kapt").dependencies.add(DefaultExternalModuleDependency("com.google.dagger", "dagger-compiler", "2.44.2"))
                implementation("com.google.dagger:dagger:2.44.2")
            }
        }

        val desktopMain by getting {
            kapt {
                generateStubs = true
            }
            dependencies {
                configurations.get("kapt").dependencies.add(DefaultExternalModuleDependency("com.google.dagger", "dagger-compiler", "2.44.2"))
                implementation("com.google.dagger:dagger:2.44.2")
                // https://mvnrepository.com/artifact/org.jetbrains.kotlinx/kotlinx-coroutines-core
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

                implementation("org.usb4java:usb4java:1.3.0")
                implementation("org.hid4java:hid4java:0.7.0")

            }
        }
    }
}

android {
    namespace = "com.digitalsamurai.standaggregator"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}