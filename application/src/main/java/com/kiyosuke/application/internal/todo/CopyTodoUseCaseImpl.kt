package com.kiyosuke.application.internal.todo

import com.kiyosuke.application.todo.CopyTodoCommand
import com.kiyosuke.application.todo.CopyTodoUseCase
import com.kiyosuke.model.TodoRepository
import com.kiyosuke.service.TodoService
import javax.inject.Inject

internal class CopyTodoUseCaseImpl @Inject constructor(
    private val todoService: TodoService,
    private val todoRepository: TodoRepository
) : CopyTodoUseCase {
    override suspend fun invoke(command: CopyTodoCommand) {
        val origin = todoRepository.findTodoById(command.todoId)
            ?: throw IllegalArgumentException("対象のTODOは存在しません")
        val copiedTodo = todoService.copyTodo(origin)
        todoRepository.save(copiedTodo)
    }
}