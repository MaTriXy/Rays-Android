buildscript {
    extra.apply {
        set("composeVersion", "1.6.0")
        set("md3Version", "1.2.0")
        set("accompanistVersion", "0.34.0")
        set("mlkitRecognitionVersion", "16.0.0")
        set("roomVersion", "2.6.1")
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.3.1" apply false
    id("com.android.library") version "8.3.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.20" apply false
    id("com.google.dagger.hilt.android") version "2.50" apply false
    id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.20"
}
