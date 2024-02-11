import org.gradle.api.internal.artifacts.dependencies.DefaultExternalModuleDependency


plugins {
    kotlin(Dependencies.Plugins.kotlinMultiplatform)
    kotlin("kapt")
}
kotlin {
    jvm {

        withJava()
        compilations.all {
            kotlinOptions.freeCompilerArgs = listOf("-Xexplicit-api=strict")
            kotlinOptions.jvmTarget = Versions.jvm
        }
    }

    sourceSets {
        val jvmMain by getting {

            dependencies {

                configurations.get("kapt").dependencies.add(DefaultExternalModuleDependency("com.google.dagger", "dagger-compiler", "2.44.2"))
                implementation("com.google.dagger:dagger:2.44.2")

                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

                implementation("org.usb4java:usb4java:1.3.0")
                implementation("org.hid4java:hid4java:0.7.0")

            }
        }
    }
}

dependencies {
    "implementation"("com.google.dagger:dagger:2.44.2")
}


