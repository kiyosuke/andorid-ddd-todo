package com.kiyosuke.application.todo

sealed class EditTodoResult {
    object Success : EditTodoResult()
    object TitleValidationFailed : EditTodoResult()
    object NotFoundTodo : EditTodoResult()
}