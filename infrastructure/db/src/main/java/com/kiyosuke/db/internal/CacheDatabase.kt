package com.kiyosuke.db.internal

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kiyosuke.db.internal.dao.TodoDao
import com.kiyosuke.db.internal.entity.TodoEntity

@Database(
    entities = [
        TodoEntity::class
    ],
    version = 1
)
internal abstract class CacheDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao
}