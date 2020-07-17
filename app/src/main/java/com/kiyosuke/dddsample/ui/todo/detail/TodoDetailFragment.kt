package com.kiyosuke.dddsample.ui.todo.detail

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.kiyosuke.dddsample.R
import com.kiyosuke.dddsample.databinding.TodoDetailFragmentBinding

class TodoDetailFragment : Fragment(R.layout.todo_detail_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = TodoDetailFragmentBinding.bind(view)

        setupToolbar(binding)
    }

    private fun setupToolbar(binding: TodoDetailFragmentBinding) {
        binding.toolbar.apply {
            setNavigationIcon(R.drawable.ic_arrow_back)
            navigationIcon?.setTint(ContextCompat.getColor(requireContext(), R.color.white))
            setNavigationOnClickListener {
                findNavController().popBackStack()
            }
        }
    }
}