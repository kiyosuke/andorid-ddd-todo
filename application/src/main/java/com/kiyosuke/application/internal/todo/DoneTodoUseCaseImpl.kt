package com.kiyosuke.application.internal.todo

import com.kiyosuke.application.todo.DoneTodoCommand
import com.kiyosuke.application.todo.DoneTodoUseCase
import com.kiyosuke.model.TodoId
import com.kiyosuke.model.TodoRepository
import javax.inject.Inject

internal class DoneTodoUseCaseImpl @Inject constructor(
    private val todoRepository: TodoRepository
) : DoneTodoUseCase {

    override suspend fun invoke(command: DoneTodoCommand) {
        val todo = todoRepository.findTodoById(TodoId(command.todoId))
        requireNotNull(todo) { "対象のTODOは存在しません" }
        todo.done()
        todoRepository.updateTodo(todo)
    }
}