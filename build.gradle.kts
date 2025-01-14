// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    extra.apply {
        set("kotlinVersion", "1.8.22")
        set("serializationVersion", "1.5.0")
        set("retrofitVersion", "2.9.0")
        set("exoPlayerVersion", "2.14.2")
        set("commonmarkVersion", "0ebc0749c7")
        set("graphqlVersion", "6.5.3")
        set("ktorVersion", "2.3.1")
        set("hiltVersion", "2.46.1")
        set("okhttpVersion", "4.11.0")
    }

    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }

    dependencies {
        val kotlinVersion: String by rootProject.extra
        val graphqlVersion: String by rootProject.extra
        val hiltVersion: String by rootProject.extra

        classpath("com.android.tools.build:gradle:8.0.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
        classpath("com.expediagroup:graphql-kotlin-gradle-plugin:$graphqlVersion")


        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

tasks.register<Delete>("clean").configure {
    delete(rootProject.buildDir)
}
