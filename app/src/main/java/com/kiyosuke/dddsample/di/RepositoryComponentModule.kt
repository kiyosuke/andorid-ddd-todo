package com.kiyosuke.dddsample.di

import com.kiyosuke.db.TodoDatabase
import com.kiyosuke.model.TodoRepository
import com.kiyosuke.repository.di.RepositoryComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RepositoryComponentModule {

    @Singleton
    @Provides
    fun provideTodoRepository(component: RepositoryComponent): TodoRepository {
        return component.todoRepository()
    }

    @Singleton
    @Provides
    fun provideRepositoryComponent(
        todoDatabase: TodoDatabase
    ): RepositoryComponent {
        return RepositoryComponent.factory().create(todoDatabase)
    }
}