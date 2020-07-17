package com.kiyosuke.application.todo

import com.kiyosuke.application.CoroutineUseCase

interface CopyTodoUseCase : CoroutineUseCase<CopyTodoCommand, Unit>