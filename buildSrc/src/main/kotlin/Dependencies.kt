object Versions{
    const val standInfoAggregator = "1.0.0"
    object Plugins{
        const val android = "7.2.2"
        const val kotlin = "1.7.10"
        const val serialization = "1.8.0"
    }
    const val minSdk = 30
    const val targetSdk = 33
    const val compose = "1.2.2"
    const val androidCompose = "1.3.1"
    const val activityCompose = "1.5.1"
    const val jvm = "11"
    const val icerockResources = "0.20.1"
    const val eventBus = "3.3.1"
    const val serialization = "1.4.1"
    object Koin{
        const val core = "3.3.2"
        const val android = "3.3.2"
        const val androidCompose = "3.4.1"
        const val ktor = "3.3.0"
    }
}

object Namespaces{
    const val standInfoAggregator = "com.digitalsamurai.standaggregator"
    const val standInfoAggregatorAndroid = "$standInfoAggregator.android"
}

object Dependencies{
    const val activityCompose = "androidx.activity:activity-compose:"
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.Plugins.android}"
    const val kotlinGradlePlugin= "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Plugins.kotlin}"
    const val eventBus = "org.greenrobot:eventbus:${Versions.eventBus}"
    const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}"
    object Koin {
        const val core = "io.insert-koin:koin-core:${Versions.Koin.core}"
        const val test = "io.insert-koin:koin-test:${Versions.Koin.core}"
        const val jUnit5 = "io.insert-koin:koin-test-junit5:${Versions.Koin.core}"
        const val android = "io.insert-koin:koin-android:${Versions.Koin.android}"
        const val androidCompat = "io.insert-koin:koin-android-compat:${Versions.Koin.android}"
        const val androidWorkManager = "io.insert-koin:koin-androidx-workmanager:${Versions.Koin.android}"
        const val androidNavigation = "io.insert-koin:koin-androidx-navigation:${Versions.Koin.android}"
        const val androidCompose = "io.insert-koin:koin-androidx-compose:${Versions.Koin.androidCompose}"
        const val ktor = "io.insert-koin:koin-ktor:${Versions.Koin.ktor}"
        const val loggerSlf4j = "io.insert-koin:koin-logger-slf4j:${Versions.Koin.ktor}"
    }
    object Compose{
        const val ui = "androidx.compose.ui:ui:${Versions.androidCompose}"
        const val uiGraphics = "androidx.compose.ui:ui-graphics:${Versions.androidCompose}"
        const val uiUtil = "androidx.compose.ui:ui-util:${Versions.androidCompose}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.androidCompose}"
        const val preview = "androidx.compose.ui:ui-tooling-preview:${Versions.androidCompose}"
        const val foundation = "androidx.compose.foundation:foundation:${Versions.androidCompose}"
        const val material = "androidx.compose.material:material:${Versions.androidCompose}"
        const val material_desktop = "androidx.compose.material:material-desktop:${Versions.androidCompose}"
        const val material_icons = "androidx.compose.material:material-icons-extended:${Versions.androidCompose}"
        const val runtime = "androidx.compose.runtime:runtime:${Versions.androidCompose}"
        const val compiler = "androidx.compose.compiler:compiler:${Versions.androidCompose}"
        const val runtime_livedata = "androidx.compose.runtime:runtime-livedata:${Versions.androidCompose}"
        const val foundationLayout = "androidx.compose.foundation:foundation-layout:${Versions.androidCompose}"
    }
    object Plugins{
        const val kotlinMultiplatform = "multiplatform"
        const val kotlinAndroid = "android"
        const val androidLibrary = "com.android.library"
        const val androidApplication = "com.android.application"
        const val compose = "org.jetbrains.compose"
        const val icerockMultiplatformResources = "dev.icerock.mobile.multiplatform-resources"
        const val serialization = "plugin.serialization"
    }
    object Moko{
        const val resources = "dev.icerock.moko:resources:${Versions.icerockResources}"
        const val resourcesCompose = "dev.icerock.moko:resources-compose:${Versions.icerockResources}"
    }
}