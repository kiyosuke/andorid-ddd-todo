package com.kiyosuke.service.internal

import com.kiyosuke.service.TodoService
import dagger.Binds
import dagger.Module

@Module(includes = [DomainServiceModule.Providers::class])
internal abstract class DomainServiceModule {

    @Binds abstract fun todoService(impl: TodoServiceImpl): TodoService

    @Module internal object Providers
}