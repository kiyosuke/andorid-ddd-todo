package com.kiyosuke.application.todo

import com.kiyosuke.application.CoroutineUseCase

interface DoneTodoUseCase : CoroutineUseCase<DoneTodoCommand, Unit>