package com.kiyosuke.repository.di.internal

import com.kiyosuke.model.TodoRepository
import com.kiyosuke.repository.TodoDataRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [RepositoryModule.Providers::class])
internal abstract class RepositoryModule {
    @Binds abstract fun todoRepository(impl: TodoDataRepository): TodoRepository

    @Module internal object Providers
}