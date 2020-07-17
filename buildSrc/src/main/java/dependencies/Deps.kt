package dependencies

object Deps {

    object GradlePlugins {
        val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
    }

    object Versions {
        val kotlin = "1.3.72"
        val coroutines = "1.3.7"
        val dagger = "2.28.1"
        val room = "2.2.4"
        val navigation = "2.2.2"
    }

    object AndroidX {
        val appCompat = "androidx.appcompat:appcompat:1.1.0"
        val coreKtx = "androidx.core:core-ktx:1.3.0"
        val recyclerView = "androidx.recyclerview:recyclerview:1.1.0"
        val constraint = "androidx.constraintlayout:constraintlayout:1.1.3"
        val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata:2.2.0"
        val liveDataCoreKtx = "androidx.lifecycle:lifecycle-livedata-core-ktx:2.2.0"
        val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"
        val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.2.0"

        val material = "com.google.android.material:material:1.1.0"

        object Room {
            val compiler = "androidx.room:room-compiler:${Versions.room}"
            val runtime = "androidx.room:room-runtime:${Versions.room}"
            val ktx = "androidx.room:room-ktx:${Versions.room}"
        }

        object Navigation {
            val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
            val uiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        }
    }

    object Kotlin {
        val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    }

    object Dagger {
        val core = "com.google.dagger:dagger:${Versions.dagger}"
        val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
        val android = "com.google.dagger:dagger-android:${Versions.dagger}"
        val androidCompiler = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
        val androidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    }
}