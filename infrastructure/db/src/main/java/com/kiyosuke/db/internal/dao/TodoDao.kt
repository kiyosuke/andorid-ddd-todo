package com.kiyosuke.db.internal.dao

import androidx.room.*
import com.kiyosuke.db.internal.entity.TodoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: TodoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entities: List<TodoEntity>)

    @Query("SELECT * FROM t_todo")
    suspend fun allTodo(): List<TodoEntity>

    @Query("SELECT * FROM t_todo")
    fun flowAllTodo(): Flow<List<TodoEntity>>

    @Query("SELECT * FROM t_todo WHERE id = :todoId")
    suspend fun findTodo(todoId: Long): TodoEntity?

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTodo(todo: TodoEntity)

    @Query("DELETE FROM t_todo WHERE id = :todoId")
    suspend fun delete(todoId: Long)

    @Query("DELETE FROM t_todo")
    suspend fun deleteAll()
}