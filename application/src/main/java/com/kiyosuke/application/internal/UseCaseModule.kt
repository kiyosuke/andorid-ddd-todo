package com.kiyosuke.application.internal

import com.kiyosuke.application.internal.todo.*
import com.kiyosuke.application.todo.*
import dagger.Binds
import dagger.Module

@Module(includes = [UseCaseModule.Providers::class])
internal abstract class UseCaseModule {

    @Binds
    abstract fun addTodoUseCase(impl: AddTodoUseCaseImpl): AddTodoUseCase

    @Binds
    abstract fun copyTodoUseCase(impl: CopyTodoUseCaseImpl): CopyTodoUseCase

    @Binds
    abstract fun deleteTodoUseCase(impl: DeleteTodoUseCaseImpl): DeleteTodoUseCase

    @Binds
    abstract fun doneTodoUseCase(impl: DoneTodoUseCaseImpl): DoneTodoUseCase

    @Binds
    abstract fun editTodoUseCase(impl: EditTodoUseCaseImpl): EditTodoUseCase

    @Binds
    abstract fun flowAllTodoUseCase(impl: FlowAllTodoUseCaseImpl): FlowAllTodoUseCase

    @Binds
    abstract fun findTodoUseCase(impl: FindTodoUseCaseImpl): FindTodoUseCase

    @Module
    internal object Providers
}