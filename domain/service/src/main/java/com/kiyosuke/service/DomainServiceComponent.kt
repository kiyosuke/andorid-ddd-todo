package com.kiyosuke.service

import com.kiyosuke.model.TodoFactory
import com.kiyosuke.service.internal.DomainServiceModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DomainServiceModule::class])
interface DomainServiceComponent {

    fun todoService(): TodoService

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance todoFactory: TodoFactory): DomainServiceComponent
    }

    companion object {
        fun factory(): Factory {
            return DaggerDomainServiceComponent.factory()
        }
    }
}