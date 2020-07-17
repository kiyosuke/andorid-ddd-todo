package com.kiyosuke.application.todo

import com.kiyosuke.application.CoroutineUseCase

interface DeleteTodoUseCase : CoroutineUseCase<DeleteTodoCommand, Unit>