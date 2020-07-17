package com.kiyosuke.dddsample

import com.kiyosuke.dddsample.di.createAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return createAppComponent()
    }
}