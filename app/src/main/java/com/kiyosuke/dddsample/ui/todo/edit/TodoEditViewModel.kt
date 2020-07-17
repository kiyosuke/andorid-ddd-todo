package com.kiyosuke.dddsample.ui.todo.edit

import androidx.lifecycle.*
import com.kiyosuke.application.todo.*
import com.kiyosuke.dddsample.R
import com.kiyosuke.dddsample.utils.ext.requireValue
import com.kiyosuke.model.TodoId
import kotlinx.coroutines.launch
import javax.inject.Inject

class TodoEditViewModel @Inject constructor(
    private val addTodoUseCase: AddTodoUseCase,
    private val editTodoUseCase: EditTodoUseCase,
    private val findTodoUseCase: FindTodoUseCase
) : ViewModel() {

    private var todoId = TodoId.NO_ID

    data class State(
        val loading: Boolean = true
    )

    private val _state = MutableLiveData(State())
    val state: LiveData<State> get() = _state.distinctUntilChanged()

    private val _navigateToBack = MutableLiveData<Unit>()
    val navigateToBack: LiveData<Unit> get() = _navigateToBack

    private val _initialTitle = MutableLiveData<String>()
    val initialTitle: LiveData<String> get() = _initialTitle

    private val _initialContent = MutableLiveData<String>()
    val initialContent: LiveData<String> get() = _initialContent

    private val _errorMessage = MutableLiveData<Int>()
    val errorMessage: LiveData<Int> get() = _errorMessage

    fun initialize(todoId: Long) {
        this.todoId = TodoId(todoId)

        viewModelScope.launch {
            val command = FindTodoCommand(this@TodoEditViewModel.todoId.value)
            val todo = findTodoUseCase(command) ?: run {
                _state.value = _state.requireValue().copy(loading = false)
                return@launch
            }
            _initialTitle.value = todo.title.value
            _initialContent.value = todo.content
            _state.value = _state.requireValue().copy(loading = false)
        }
    }

    fun saveTodo(title: String?, content: String?) {
        if (todoId.isNoId) {
            addTodo(title, content)
        } else {
            editTodo(title, content)
        }
    }

    private fun addTodo(title: String?, content: String?) {
        val command = AddTodoCommand(title, content)
        viewModelScope.launch {
            try {
                _state.value = _state.requireValue().copy(loading = true)
                val result = addTodoUseCase(command)
                _state.value = _state.requireValue().copy(loading = false)
                when (result) {
                    AddTodoResult.Success -> _navigateToBack.value = Unit
                    AddTodoResult.TitleValidationFailed -> {
                        _errorMessage.value = R.string.require_title_message
                    }
                }
            } catch (e: Exception) {
                // TODO: error handling
                e.printStackTrace()
            }
        }
    }

    private fun editTodo(title: String?, content: String?) {
        val command = EditTodoCommand(todoId.value, title, content)
        viewModelScope.launch {
            try {
                _state.value = _state.requireValue().copy(loading = true)
                val result = editTodoUseCase(command)
                _state.value = _state.requireValue().copy(loading = false)
                when (result) {
                    EditTodoResult.Success -> _navigateToBack.value = Unit
                    EditTodoResult.TitleValidationFailed -> {
                        _errorMessage.value = R.string.require_title_message
                    }
                    EditTodoResult.NotFoundTodo -> {
                        _errorMessage.value = R.string.not_found_todo_message
                    }
                }
            } catch (e: Exception) {
                // TODO: error handling
                e.printStackTrace()
            }
        }
    }
}