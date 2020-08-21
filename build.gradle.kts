buildscript {
    extra["kotlinStdLib"] = Library.kotlinStdLib
    extra["appCompat"] = Library.AndroidX.appCompat
    extra["core"] = Library.AndroidX.core
    extra["constraintLayout"] = Library.AndroidX.constraintLayout
    extra["coroutinesCore"] = Library.coroutinesCore
    extra["coroutinesRX2"] = Library.coroutinesRX2

    extra["kotestFramework"] = TestLibrary.Kotest.framework
    extra["kotestAssertions"] = TestLibrary.Kotest.assertions
    extra["kotestProperty"] = TestLibrary.Kotest.property
    extra["coroutinesTest"] = TestLibrary.coroutines
    extra["junit"] = TestLibrary.junit

    repositories {
        google()
        jcenter()
        maven(url = "https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath(BuildPlugin.androidGradlePlugin)
        classpath(BuildPlugin.kotlinGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven(url = "https://jitpack.io")
    }
}

tasks.register("clean").configure {
    delete("build")
}
