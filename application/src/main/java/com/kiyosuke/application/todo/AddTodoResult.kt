package com.kiyosuke.application.todo

sealed class AddTodoResult {
    object Success : AddTodoResult()
    object TitleValidationFailed : AddTodoResult()
}