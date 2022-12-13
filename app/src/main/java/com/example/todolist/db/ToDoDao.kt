package com.example.todolist.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

// DAO 접근객체 생성

@Dao
interface ToDoDao {
    @Query("SELECT * FROM ToDoEntity")
    fun getAll(): List<ToDoEntity>

    @Insert
    fun insertTodo(todo: ToDoEntity)

    @Delete
    fun deleteTodo(todo: ToDoEntity)
}