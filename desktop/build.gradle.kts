import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin(Dependencies.Plugins.kotlinMultiplatform)
    id(Dependencies.Plugins.compose).version(Versions.compose)
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


                implementation("com.google.dagger:dagger:2.43")
                implementation("com.google.dagger:dagger-compiler:2.43")

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
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "Ceal_Chronicler"
            macOS {
                bundleID = Namespaces.standInfoAggregator
            }
        }
    }
}