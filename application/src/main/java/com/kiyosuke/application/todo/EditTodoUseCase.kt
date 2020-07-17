package com.kiyosuke.application.todo

import com.kiyosuke.application.CoroutineUseCase

interface EditTodoUseCase : CoroutineUseCase<EditTodoCommand, EditTodoResult>