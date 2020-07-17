package com.kiyosuke.dddsample.ui.todo.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.kiyosuke.dddsample.R
import com.kiyosuke.dddsample.databinding.FragmentTodoListBinding
import com.kiyosuke.model.Todo
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class TodoListFragment : DaggerFragment(R.layout.fragment_todo_list) {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: TodoListViewModel by viewModels { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentTodoListBinding.bind(view)

        binding.addTodoFab.setOnClickListener {
            val directions = TodoListFragmentDirections.actionTodoListFragmentToTodoEditFragment()
            findNavController().navigate(directions)
        }

        val adapter = TodoListAdapter()
        adapter.onItemClickListener = ::onTodoItemClick
        binding.recyclerView.adapter = adapter

        viewModel.allTodo.observe(viewLifecycleOwner) { todo -> adapter.submitList(todo) }
    }

    private fun onTodoItemClick(todo: Todo) {
        val directions = TodoListFragmentDirections
            .actionTodoListFragmentToTodoDetailFragment(todo.id.value)
        findNavController().navigate(directions)
    }
}

@Module
interface TodoListFragmentModule {

    @ContributesAndroidInjector
    fun todoListFragment(): TodoListFragment
}