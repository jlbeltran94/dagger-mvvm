package codemakers.daggermvvm.ui.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import codemakers.daggermvvm.R
import codemakers.daggermvvm.data.model.Todo
import codemakers.daggermvvm.databinding.TemplateTodoBinding
import codemakers.daggermvvm.util.inflate
import io.reactivex.subjects.PublishSubject

/**
 * Created by jlbeltran94 on 13/10/17.
 */
class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoHolder>() {

    val todoSelected = PublishSubject.create<Todo>()
    val todoDeleted = PublishSubject.create<Todo>()

    var todos: List<Todo> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: TodoHolder, position: Int) {
        holder.binding.todo = todos[position]
        holder.binding.clickTodo = todoSelected
        holder.binding.clickDelete = todoDeleted
    }

    override fun getItemCount(): Int = todos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder = TodoHolder(parent.inflate(R.layout.template_todo))

    class TodoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: TemplateTodoBinding = DataBindingUtil.bind(itemView)
    }
}