package com.kiyosuke.application.internal.todo

import com.kiyosuke.application.todo.DeleteTodoCommand
import com.kiyosuke.application.todo.DeleteTodoUseCase
import com.kiyosuke.model.TodoRepository
import javax.inject.Inject

internal class DeleteTodoUseCaseImpl @Inject constructor(
    private val todoRepository: TodoRepository
) : DeleteTodoUseCase {

    override suspend fun invoke(command: DeleteTodoCommand) {
        todoRepository.deleteTodo(command.id)
    }
}