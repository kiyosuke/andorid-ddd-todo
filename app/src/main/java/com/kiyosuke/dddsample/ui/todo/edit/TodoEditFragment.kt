package com.kiyosuke.dddsample.ui.todo.edit

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kiyosuke.dddsample.R
import com.kiyosuke.dddsample.databinding.TodoEditFragmentBinding
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class TodoEditFragment : DaggerFragment(R.layout.todo_edit_fragment) {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: TodoEditViewModel by viewModels { viewModelFactory }
    private val args: TodoEditFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = TodoEditFragmentBinding.bind(view)
        setupToolbar(binding)

        viewModel.state.observe(viewLifecycleOwner) { state ->
            binding.progressBar.isVisible = state.loading
        }

        viewModel.initialTitle.observe(viewLifecycleOwner) { title ->
            binding.editTitle.setText(title)
        }

        viewModel.initialContent.observe(viewLifecycleOwner) { content ->
            binding.editContent.setText(content)
        }

        viewModel.navigateToBack.observe(viewLifecycleOwner) {
            findNavController().popBackStack()
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) { message ->
            Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
        }

        viewModel.initialize(args.todoId)
    }

    private fun setupToolbar(binding: TodoEditFragmentBinding) {
        binding.toolbar.apply {
            setNavigationIcon(R.drawable.ic_arrow_back)
            navigationIcon?.setTint(ContextCompat.getColor(requireContext(), R.color.white))
            setNavigationOnClickListener {
                findNavController().popBackStack()
            }
            inflateMenu(R.menu.edit_todo_menu)
            setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.menu_save -> {
                        val title = binding.editTitle.text?.toString()
                        val content = binding.editContent.text?.toString()
                        viewModel.saveTodo(title, content)
                        true
                    }
                    else -> false
                }
            }
        }
    }
}

@Module
interface TodoEditFragmentModule {

    @ContributesAndroidInjector
    fun todoEditFragment(): TodoEditFragment
}