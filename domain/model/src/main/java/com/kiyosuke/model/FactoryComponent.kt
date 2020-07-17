package com.kiyosuke.model

import com.kiyosuke.model.internal.FactoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [FactoryModule::class])
interface FactoryComponent {

    fun todoFactory(): TodoFactory

    @Component.Factory
    interface Factory {
        fun create(): FactoryComponent
    }

    companion object {
        fun factory(): Factory {
            return DaggerFactoryComponent.factory()
        }
    }
}