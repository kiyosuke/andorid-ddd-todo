package com.kiyosuke.model

import javax.inject.Inject

class NewTodoFactory @Inject constructor() : TodoFactory {

    override fun create(title: String, content: String?): Todo {
        return Todo(TodoId.NO_ID, TodoTitle(title), content, false)
    }
}