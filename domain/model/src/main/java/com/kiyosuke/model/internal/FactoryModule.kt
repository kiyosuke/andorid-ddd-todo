package com.kiyosuke.model.internal

import com.kiyosuke.model.NewTodoFactory
import com.kiyosuke.model.TodoFactory
import dagger.Binds
import dagger.Module

@Module
internal abstract class FactoryModule {

    @Binds
    abstract fun todoFactory(impl: NewTodoFactory): TodoFactory
}