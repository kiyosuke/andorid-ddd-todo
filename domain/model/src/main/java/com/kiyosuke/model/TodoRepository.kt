package com.kiyosuke.model

import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    suspend fun allTodo(): List<Todo>

    fun flowAllTodo(): Flow<List<Todo>>

    suspend fun findTodoById(todoId: TodoId): Todo?

    suspend fun save(todo: Todo)

    suspend fun updateTodo(todo: Todo)

    suspend fun deleteTodo(todoId: TodoId)
}