
plugins {
    kotlin(Dependencies.Plugins.kotlinMultiplatform)
    id(Dependencies.Plugins.androidLibrary)
    id(Dependencies.Plugins.compose).version(Versions.compose)
}

android {
    namespace = Namespaces.standInfoAggregatorAndroid
    compileSdk =  Versions.targetSdk
    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}
dependencies {
    implementation(Dependencies.Compose.uiGraphics)
    implementation(Dependencies.Compose.material)
    implementation("androidx.compose.material3:material3:1.1.2")
}

kotlin {
    android()
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = Versions.jvm
        }
    }

    sourceSets {
        val commonMain by getting {
            @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
            dependencies {
                implementation(project(":shared"))
                implementation(Dependencies.eventBus)
                implementation(Dependencies.Koin.core)

                api(compose.animation)
                api(compose.foundation)
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material3)
                api(compose.materialIconsExtended)
                api(compose.ui)
                api(compose.uiTooling)

                api(Dependencies.Moko.resources)
                api(Dependencies.Moko.resourcesCompose)
            }
        }
        val androidMain by getting {
            dependencies {
                api(Dependencies.Compose.runtime)
                api(Dependencies.Compose.ui)
            }
        }
        val desktopMain by getting
    }
}

//multiplatformResources {
//    multiplatformResourcesPackage = Namespaces.standAggregator
//}
