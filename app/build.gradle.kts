plugins {
    id(BuildPlugin.androidApplication)
    id(BuildPlugin.kotlinAndroid)
    id(BuildPlugin.kotlinAndroidExtensions)
}

apply {
    from("../android_dependencies.gradle")
    from("../core_dependencies.gradle")
}

android {
    compileSdkVersion(AndroidSdkVersions.compile)
    defaultConfig {
        applicationId = "xyz.kewiany.contactus"
        minSdkVersion(AndroidSdkVersions.min)
        targetSdkVersion(AndroidSdkVersions.target)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":logic"))
}

tasks.withType<Test> {
    useJUnitPlatform()
}
