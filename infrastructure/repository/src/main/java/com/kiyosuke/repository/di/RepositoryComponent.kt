package com.kiyosuke.repository.di

import com.kiyosuke.db.TodoDatabase
import com.kiyosuke.model.TodoRepository
import com.kiyosuke.repository.di.internal.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RepositoryModule::class]
)
interface RepositoryComponent {
    fun todoRepository(): TodoRepository

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance todoDatabase: TodoDatabase
        ): RepositoryComponent
    }

    companion object {
        fun factory(): Factory = DaggerRepositoryComponent.factory()
    }
}