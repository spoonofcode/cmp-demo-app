rootProject.name = "CMPDemoApp"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.10.0"
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

include(":composeApp")

include(":core:data")
include(":core:designsystem")
include(":core:firebase:data")
include(":core:firebase:data-test")
include(":core:firebase:domain")
include(":core:network")
include(":core:nfc")
include(":core:presentation")
include(":core:presentation-test")
include(":core:recaptcha")
include(":core:session:data")
include(":core:session:data-test")
include(":core:session:domain")
include(":core:storage:data")
include(":core:test")

include(":feature:appnavigation")

include(":feature:home:data")
include(":feature:home:data-test")
include(":feature:home:domain")
include(":feature:home:presentation")

include(":feature:profile:data")
include(":feature:profile:data-test")
include(":feature:profile:domain")
include(":feature:profile:presentation")

include(":feature:task:data")
include(":feature:task:data-test")
include(":feature:task:domain")
include(":feature:task:presentation")
