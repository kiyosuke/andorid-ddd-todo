package com.kiyosuke.application.todo

data class EditTodoCommand(
    val todoId: Long,
    val title: String?,
    val content: String?
)