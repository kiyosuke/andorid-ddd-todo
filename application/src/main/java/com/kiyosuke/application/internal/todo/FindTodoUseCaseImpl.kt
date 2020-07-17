package com.kiyosuke.application.internal.todo

import com.kiyosuke.application.todo.FindTodoCommand
import com.kiyosuke.application.todo.FindTodoUseCase
import com.kiyosuke.model.Todo
import com.kiyosuke.model.TodoId
import com.kiyosuke.model.TodoRepository
import javax.inject.Inject

internal class FindTodoUseCaseImpl @Inject constructor(
    private val todoRepository: TodoRepository
) : FindTodoUseCase {

    override suspend fun invoke(command: FindTodoCommand): Todo? {
        val todoId = TodoId(command.todoId)
        return todoRepository.findTodoById(todoId)
    }
}