package com.kiyosuke.application

interface CoroutineUseCase<in I, out O> {

    suspend operator fun invoke(command: I): O
}