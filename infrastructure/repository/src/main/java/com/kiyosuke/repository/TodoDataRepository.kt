package com.kiyosuke.repository

import com.kiyosuke.db.TodoDatabase
import com.kiyosuke.model.Todo
import com.kiyosuke.model.TodoId
import com.kiyosuke.model.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class TodoDataRepository @Inject constructor(
    private val database: TodoDatabase
) : TodoRepository {

    override suspend fun allTodo(): List<Todo> {
        return database.allTodo()
    }

    override fun flowAllTodo(): Flow<List<Todo>> {
        return database.flowAllTodo()
    }

    override suspend fun findTodoById(todoId: TodoId): Todo? {
        return database.findTodoById(todoId)
    }

    override suspend fun save(todo: Todo) {
        database.save(todo)
    }

    override suspend fun updateTodo(todo: Todo) {
        database.update(todo)
    }

    override suspend fun deleteTodo(todoId: TodoId) {
        database.delete(todoId)
    }
}