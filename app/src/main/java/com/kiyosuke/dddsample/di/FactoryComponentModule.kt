package com.kiyosuke.dddsample.di

import com.kiyosuke.model.FactoryComponent
import com.kiyosuke.model.TodoFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object FactoryComponentModule {

    @Singleton
    @Provides
    fun todoFactory(component: FactoryComponent): TodoFactory {
        return component.todoFactory()
    }

    @Singleton
    @Provides
    fun provideFactoryComponent(): FactoryComponent {
        return FactoryComponent.factory().create()
    }
}