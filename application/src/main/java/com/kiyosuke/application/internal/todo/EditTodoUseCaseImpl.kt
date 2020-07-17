package com.kiyosuke.application.internal.todo

import com.kiyosuke.application.todo.EditTodoCommand
import com.kiyosuke.application.todo.EditTodoResult
import com.kiyosuke.application.todo.EditTodoUseCase
import com.kiyosuke.model.TodoId
import com.kiyosuke.model.TodoRepository
import com.kiyosuke.model.TodoTitle
import javax.inject.Inject

internal class EditTodoUseCaseImpl @Inject constructor(
    private val todoRepository: TodoRepository
) : EditTodoUseCase {

    override suspend fun invoke(command: EditTodoCommand): EditTodoResult {
        val todo = todoRepository.findTodoById(TodoId(command.todoId))
            ?: return EditTodoResult.NotFoundTodo

        // TODO: タイトルのバリデーションを仕様クラスとして抽出する
        if (command.title.isNullOrEmpty()) {
            return EditTodoResult.TitleValidationFailed
        }

        val title = TodoTitle(command.title)
        todo.changeTitle(title)
        todo.changeContent(command.content)

        todoRepository.updateTodo(todo)
        return EditTodoResult.Success
    }
}