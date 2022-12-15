package com.example.todolist

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ItemTodoBinding
import com.example.todolist.db.ToDoEntity

class TodoRecyclerViewAdapter(private val todoList: ArrayList<ToDoEntity>)
    : RecyclerView.Adapter<TodoRecyclerViewAdapter.MyViewHolder>() {


    inner class  MyViewHolder(binding: ItemTodoBinding) :
            RecyclerView.ViewHolder(binding.root) {
                val tv_importance = binding.tvImportance
        val tv_title = binding.tvTitle

        // 뷰 바인딩에서 기본적으로 제공하는 root변수는 레이아웃의
        // 루트 레이아웃을 의미한다.
        val root = binding.root
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}