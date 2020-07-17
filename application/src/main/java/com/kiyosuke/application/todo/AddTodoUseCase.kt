package com.kiyosuke.application.todo

import com.kiyosuke.application.CoroutineUseCase

interface AddTodoUseCase : CoroutineUseCase<AddTodoCommand, AddTodoResult>