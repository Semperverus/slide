plugins {
    id("java-library")
    kotlin("jvm")
    kotlin("plugin.serialization")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(project(mapOf("path" to ":data")))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation("io.github.oshai:kotlin-logging-jvm:4.0.0")
    implementation("com.github.Haptic-Apps:JRAW:9c8a410a06")

    val okhttpVersion: String by rootProject.extra
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")

    val retrofitVersion: String by rootProject.extra
    implementation("com.squareup.retrofit2:retrofit:${retrofitVersion}")
    implementation("com.nightlynexus.logging-retrofit:logging:0.12.0")

    val serializationVersion: String by rootProject.extra
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${serializationVersion}")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.3.2")

    implementation("org.jetbrains:markdown:0.2.2")
}
