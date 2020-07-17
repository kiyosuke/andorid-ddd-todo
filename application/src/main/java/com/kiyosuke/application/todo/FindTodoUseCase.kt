package com.kiyosuke.application.todo

import com.kiyosuke.application.CoroutineUseCase
import com.kiyosuke.model.Todo

interface FindTodoUseCase : CoroutineUseCase<FindTodoCommand, Todo?>