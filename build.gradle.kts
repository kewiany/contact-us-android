buildscript {
    extra["kotlinStdLib"] = Library.kotlinStdLib
    extra["appCompat"] = Library.AndroidX.appCompat
    extra["core"] = Library.AndroidX.core
    extra["constraintLayout"] = Library.AndroidX.constraintLayout

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
