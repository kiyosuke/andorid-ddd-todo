package com.kiyosuke.db.internal.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "t_todo")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val title: String,
    val content: String?,
    @ColumnInfo(name = "is_done") val isDone: Boolean
)