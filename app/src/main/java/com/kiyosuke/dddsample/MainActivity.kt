package com.kiyosuke.dddsample

import android.os.Bundle
import dagger.Module
import dagger.android.ContributesAndroidInjector

class MainActivity : DaggerAppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}

@Module
interface MainActivityModule {

    @Module(includes = [MainActivityModule::class])
    interface MainActivityBuilder {
        @ContributesAndroidInjector
        fun mainActivity(): MainActivity
    }
}