plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    kotlin("kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(project(":annotations"))
    implementation(libs.javapoet)
    implementation("com.google.dagger:dagger:2.50")
    //A google Library to auto generate the file where we mark our processor
    compileOnly(libs.auto.service)
    kapt(libs.auto.service)
    //Gradle incremental
    compileOnly(libs.incap.core)
    kapt(libs.incap.processor)
}