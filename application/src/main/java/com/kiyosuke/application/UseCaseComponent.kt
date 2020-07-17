package com.kiyosuke.application

import com.kiyosuke.application.internal.UseCaseModule
import com.kiyosuke.application.todo.*
import com.kiyosuke.model.TodoFactory
import com.kiyosuke.model.TodoRepository
import com.kiyosuke.service.TodoService
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UseCaseModule::class])
interface UseCaseComponent {

    fun addTodoUseCase(): AddTodoUseCase

    fun copyTodoUseCase(): CopyTodoUseCase

    fun deleteTodoUseCase(): DeleteTodoUseCase

    fun doneTodoUseCase(): DoneTodoUseCase

    fun editTodoUseCase(): EditTodoUseCase

    fun flowAllTodoUseCase(): FlowAllTodoUseCase

    fun findTodoUseCase(): FindTodoUseCase

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance todoRepository: TodoRepository,
            @BindsInstance todoService: TodoService,
            @BindsInstance todoFactory: TodoFactory
        ): UseCaseComponent
    }

    companion object {
        fun factory(): Factory {
            return DaggerUseCaseComponent.factory()
        }
    }
}