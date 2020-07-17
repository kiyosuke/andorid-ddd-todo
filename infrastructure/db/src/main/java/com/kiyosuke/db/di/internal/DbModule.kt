package com.kiyosuke.db.di.internal

import android.content.Context
import androidx.room.Room
import com.kiyosuke.db.TodoDatabase
import com.kiyosuke.db.internal.CacheDatabase
import com.kiyosuke.db.internal.RoomDatabase
import com.kiyosuke.db.internal.dao.TodoDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DbModule.Providers::class])
internal abstract class DbModule {
    @Binds
    abstract fun todoDatabase(impl: RoomDatabase): TodoDatabase

    @Module
    internal class Providers {
        @Singleton
        @Provides
        fun cacheDatabase(
            context: Context,
            fileName: String?
        ): CacheDatabase {
            return Room.databaseBuilder(context, CacheDatabase::class.java, fileName ?: "todo.db")
                .build()
        }

        @Provides
        fun todoDao(database: CacheDatabase): TodoDao {
            return database.todoDao()
        }
    }
}