package com.example.todolist.db

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class ToDoEntity(
    @PrimaryKey(autoGenerate = true) var id : Int? = null,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "importance") val importance: Int
)