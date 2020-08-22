object BuildPlugin {
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val androidGradlePlugin = "com.android.tools.build:gradle:4.0.1"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object Library {
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    object AndroidX {
        const val core = "androidx.core:core-ktx:1.1.0"
        const val appCompat = "androidx.appcompat:appcompat:1.1.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
    }

    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinx_coroutines}"
    const val coroutinesRX2 =
        "org.jetbrains.kotlinx:kotlinx-coroutines-rx3:${Versions.kotlinx_coroutines}"
    const val rxRelay = "com.jakewharton.rxrelay3:rxrelay:3.0.0"
    const val rxKotlin = "io.reactivex.rxjava3:rxkotlin:3.0.0"
}

object TestLibrary {

    object Kotest {
        const val framework = "io.kotest:kotest-runner-junit5-jvm:${Versions.kotest}.RC2"
        const val assertions = "io.kotest:kotest-assertions-core-jvm:${Versions.kotest}"
        const val property = "io.kotest:kotest-property-jvm:${Versions.kotest}"
    }

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinx_coroutines}"
    const val junit = "junit:junit:4.12"
}
