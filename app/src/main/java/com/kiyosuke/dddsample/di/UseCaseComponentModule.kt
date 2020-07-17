package com.kiyosuke.dddsample.di

import com.kiyosuke.application.UseCaseComponent
import com.kiyosuke.application.todo.*
import com.kiyosuke.model.TodoFactory
import com.kiyosuke.model.TodoRepository
import com.kiyosuke.service.TodoService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object UseCaseComponentModule {

    @Provides
    fun provideAddTodoUseCase(component: UseCaseComponent): AddTodoUseCase {
        return component.addTodoUseCase()
    }

    @Provides
    fun provideCopyTodoUseCase(component: UseCaseComponent): CopyTodoUseCase {
        return component.copyTodoUseCase()
    }

    @Provides
    fun provideDeleteTodoUseCase(component: UseCaseComponent): DeleteTodoUseCase {
        return component.deleteTodoUseCase()
    }

    @Provides
    fun provideDoneTodoUseCase(component: UseCaseComponent): DoneTodoUseCase {
        return component.doneTodoUseCase()
    }

    @Provides
    fun provideEditTodoUseCase(component: UseCaseComponent): EditTodoUseCase {
        return component.editTodoUseCase()
    }

    @Provides
    fun provideFlowAllTodoUseCase(component: UseCaseComponent): FlowAllTodoUseCase {
        return component.flowAllTodoUseCase()
    }

    @Provides
    fun provideFindTodoUseCase(component: UseCaseComponent): FindTodoUseCase {
        return component.findTodoUseCase()
    }

    @Provides
    fun provideUseCaseComponent(
        todoRepository: TodoRepository,
        todoService: TodoService,
        todoFactory: TodoFactory
    ): UseCaseComponent {
        return UseCaseComponent.factory().create(todoRepository, todoService, todoFactory)
    }
}