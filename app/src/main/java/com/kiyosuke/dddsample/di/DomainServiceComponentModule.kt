package com.kiyosuke.dddsample.di

import com.kiyosuke.model.TodoFactory
import com.kiyosuke.service.DomainServiceComponent
import com.kiyosuke.service.TodoService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DomainServiceComponentModule {

    @Singleton
    @Provides
    fun provideTodoService(component: DomainServiceComponent): TodoService {
        return component.todoService()
    }

    @Singleton
    @Provides
    fun provideDomainServiceComponent(
        todoFactory: TodoFactory
    ): DomainServiceComponent {
        return DomainServiceComponent.factory().create(todoFactory)
    }
}