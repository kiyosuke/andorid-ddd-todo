package com.kiyosuke.dddsample.ui.todo.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.kiyosuke.application.todo.FlowAllTodoUseCase
import com.kiyosuke.model.Todo
import javax.inject.Inject

class TodoListViewModel @Inject constructor(
    flowAllTodoUseCase: FlowAllTodoUseCase
) : ViewModel() {

    val allTodo: LiveData<List<Todo>> = flowAllTodoUseCase(Unit)
        .asLiveData(viewModelScope.coroutineContext)

}