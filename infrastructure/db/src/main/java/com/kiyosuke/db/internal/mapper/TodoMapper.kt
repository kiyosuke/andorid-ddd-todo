package com.kiyosuke.db.internal.mapper

import com.kiyosuke.db.internal.entity.TodoEntity
import com.kiyosuke.model.Todo
import com.kiyosuke.model.TodoId
import com.kiyosuke.model.TodoTitle

internal fun TodoEntity.toModel(): Todo {
    return Todo(
        id = TodoId(id),
        title = TodoTitle(title),
        content = content,
        isDone = isDone
    )
}

internal fun Todo.toEntity(): TodoEntity {
    return TodoEntity(
        id = id.value,
        title = title.value,
        content = content,
        isDone = isDone
    )
}