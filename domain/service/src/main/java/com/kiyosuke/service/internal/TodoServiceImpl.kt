package com.kiyosuke.service.internal

import com.kiyosuke.model.Todo
import com.kiyosuke.model.TodoFactory
import com.kiyosuke.service.TodoService
import javax.inject.Inject

internal class TodoServiceImpl @Inject constructor(
    private val todoFactory: TodoFactory
) : TodoService {

    override fun copyTodo(todo: Todo): Todo {
        return todoFactory.create(todo.title.value, todo.content)
    }
}