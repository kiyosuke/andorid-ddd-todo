package com.kiyosuke.dddsample.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kiyosuke.dddsample.ui.todo.edit.TodoEditViewModel
import com.kiyosuke.dddsample.ui.todo.list.TodoListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(TodoListViewModel::class)
    abstract fun bindTodoListViewModel(viewModel: TodoListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TodoEditViewModel::class)
    abstract fun bindTodoEditViewModel(viewModel: TodoEditViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}