import org.gradle.api.internal.artifacts.dependencies.DefaultExternalModuleDependency
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin(Dependencies.Plugins.kotlinMultiplatform)
    id(Dependencies.Plugins.compose).version(Versions.compose)
    kotlin("kapt")

}


kapt {
    generateStubs = true
}

group = Namespaces.standInfoAggregatorAndroid
version = Versions.cealChronicler

kotlin {
    jvm {
        withJava()
        compilations.all {
            kotlinOptions.jvmTarget = Versions.jvm
        }
    }
    sourceSets {
        val jvmMain by getting {
            kotlin.srcDirs("src/jvmMain/kotlin")
            resources.srcDirs("src/jvmMain/resources")
            dependencies {
                implementation(compose.desktop.currentOs)
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                api(compose.ui)
                api(compose.materialIconsExtended)

                configurations.get("kapt").dependencies.add(DefaultExternalModuleDependency("com.google.dagger", "dagger-compiler", "2.44.2"))
                implementation("com.google.dagger:dagger:2.44.2")


                implementation(project(":shared"))
                implementation(project(":shared-ui"))

                implementation("org.usb4java:usb4java:1.3.0")
                implementation("org.hid4java:hid4java:0.7.0")


            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "com.digitalsamurai.standaggregator.desktop.MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb, TargetFormat.Exe)
            packageName = "StandInfo"
            macOS {
                bundleID = Namespaces.standInfoAggregator
            }

            buildTypes.release {
                proguard {
                    configurationFiles.from("compose-desktop.pro")
                }
            }
        }
    }
}