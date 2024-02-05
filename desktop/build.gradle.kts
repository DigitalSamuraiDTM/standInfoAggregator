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
version = Versions.standInfoAggregator

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

                implementation(project(":shared"))
                implementation(project(":shared-ui"))

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