package com.kiyosuke.service

import com.kiyosuke.model.Todo

interface TodoService {

    fun copyTodo(todo: Todo): Todo
}