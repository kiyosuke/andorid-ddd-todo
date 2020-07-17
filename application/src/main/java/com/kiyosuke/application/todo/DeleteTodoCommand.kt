package com.kiyosuke.application.todo

import com.kiyosuke.model.TodoId

data class DeleteTodoCommand(val id: TodoId)