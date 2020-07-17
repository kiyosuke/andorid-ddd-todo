package com.kiyosuke.application

interface UseCase<in I, out O> {

    operator fun invoke(command: I): O
}