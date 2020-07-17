package com.kiyosuke.db.internal

import com.kiyosuke.db.TodoDatabase
import com.kiyosuke.db.internal.dao.TodoDao
import com.kiyosuke.db.internal.entity.TodoEntity
import com.kiyosuke.db.internal.mapper.toEntity
import com.kiyosuke.db.internal.mapper.toModel
import com.kiyosuke.model.Todo
import com.kiyosuke.model.TodoId
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class RoomDatabase @Inject constructor(
    private val database: CacheDatabase,
    private val todoDao: TodoDao
) : TodoDatabase {

    override suspend fun allTodo(): List<Todo> {
        return todoDao.allTodo().map { it.toModel() }
    }

    override fun flowAllTodo(): Flow<List<Todo>> {
        return todoDao.flowAllTodo().map { entities -> entities.map(TodoEntity::toModel) }
    }

    override suspend fun findTodoById(todoId: TodoId): Todo? {
        return todoDao.findTodo(todoId.value)?.toModel()
    }

    override suspend fun save(todo: Todo) {
        val entity = todo.toEntity()
        todoDao.insert(entity)
    }

    override suspend fun update(todo: Todo) {
        todoDao.updateTodo(todo.toEntity())
    }

    override suspend fun delete(todoId: TodoId) {
        todoDao.delete(todoId.value)
    }
}