package com.kiyosuke.dddsample.di

import android.app.Application
import com.kiyosuke.db.TodoDatabase
import com.kiyosuke.db.di.DbComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DbComponentModule {

    @Singleton
    @Provides
    fun provideTodoDatabase(component: DbComponent): TodoDatabase {
        return component.todoDatabase()
    }

    @Singleton
    @Provides
    fun provideDbComponent(application: Application): DbComponent {
        return DbComponent.factory().create(application, "todo.db")
    }
}