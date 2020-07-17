package com.kiyosuke.db

import com.kiyosuke.model.Todo
import com.kiyosuke.model.TodoId
import kotlinx.coroutines.flow.Flow

interface TodoDatabase {

    suspend fun allTodo(): List<Todo>

    fun flowAllTodo(): Flow<List<Todo>>

    suspend fun findTodoById(todoId: TodoId): Todo?

    suspend fun save(todo: Todo)

    suspend fun update(todo: Todo)

    suspend fun delete(todoId: TodoId)
}