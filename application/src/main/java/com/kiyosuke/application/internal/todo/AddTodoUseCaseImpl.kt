package com.kiyosuke.application.internal.todo

import com.kiyosuke.application.todo.AddTodoCommand
import com.kiyosuke.application.todo.AddTodoResult
import com.kiyosuke.application.todo.AddTodoUseCase
import com.kiyosuke.model.TodoFactory
import com.kiyosuke.model.TodoRepository
import javax.inject.Inject

internal class AddTodoUseCaseImpl @Inject constructor(
    private val todoFactory: TodoFactory,
    private val todoRepository: TodoRepository
) : AddTodoUseCase {

    override suspend fun invoke(command: AddTodoCommand): AddTodoResult {
        val (title, content) = command
        // TODO: バリデーション内容がUseCaseやFactoryに分散してしまっているため仕様クラスとして抽出する
        if (title.isNullOrEmpty()) {
            return AddTodoResult.TitleValidationFailed
        }
        val todo = todoFactory.create(title, content)
        todoRepository.save(todo)
        return AddTodoResult.Success
    }
}