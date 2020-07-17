package com.kiyosuke.dddsample.ui.todo.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kiyosuke.dddsample.R
import com.kiyosuke.dddsample.databinding.TodoListItemBinding
import com.kiyosuke.model.Todo

class TodoListAdapter : ListAdapter<Todo, TodoListAdapter.ViewHolder>(DIFF_CALLBACK) {

    var onItemClickListener: ((Todo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.todo_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo: Todo? = getItem(position)

        holder.binding.textTitle.text = todo?.title?.value
        holder.binding.textContent.text = todo?.content

        holder.binding.textContent.isVisible = !todo?.content.isNullOrEmpty()

        if (todo != null) {
            holder.binding.root.setOnClickListener { onItemClickListener?.invoke(todo) }
        } else {
            holder.binding.root.setOnClickListener(null)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: TodoListItemBinding = TodoListItemBinding.bind(itemView)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Todo>() {
            override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
                return oldItem == newItem
            }
        }
    }
}