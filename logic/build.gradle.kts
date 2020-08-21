plugins {
    kotlin("jvm")
}

apply {
    from("../core_dependencies.gradle")
    from("../test_dependencies.gradle")
}

repositories {
    jcenter()
}

dependencies {
    implementation(project(":core"))
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks {
    compileKotlin {
        kotlinOptions.freeCompilerArgs += "-Xuse-experimental=kotlin.ExperimentalUnsignedTypes"
        kotlinOptions.freeCompilerArgs += "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi"
    }
}