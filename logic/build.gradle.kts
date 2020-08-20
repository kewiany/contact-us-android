plugins {
    kotlin("jvm")
}

apply {
    from("../test_dependencies.gradle")
}

dependencies {
    implementation(Library.kotlinStdLib)
}

tasks.withType<Test> {
    useJUnitPlatform()
}

