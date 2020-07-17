package com.kiyosuke.application.todo

import com.kiyosuke.application.UseCase
import com.kiyosuke.model.Todo
import kotlinx.coroutines.flow.Flow

interface FlowAllTodoUseCase : UseCase<Unit, Flow<List<Todo>>>