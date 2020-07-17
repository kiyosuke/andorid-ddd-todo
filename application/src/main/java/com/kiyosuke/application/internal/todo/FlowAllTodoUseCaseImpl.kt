package com.kiyosuke.application.internal.todo

import com.kiyosuke.application.todo.FlowAllTodoUseCase
import com.kiyosuke.model.Todo
import com.kiyosuke.model.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class FlowAllTodoUseCaseImpl @Inject constructor(
    private val todoRepository: TodoRepository
) : FlowAllTodoUseCase {
    override fun invoke(command: Unit): Flow<List<Todo>> {
        return todoRepository.flowAllTodo()
    }
}