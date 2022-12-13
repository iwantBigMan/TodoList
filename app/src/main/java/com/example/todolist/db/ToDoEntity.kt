package com.example.todolist.db

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey


@Entity // Room(entity), 어떤 구성 요소인지 알려주려면 꼭 어노테이션을 써야한다.
data class ToDoEntity(
    @PrimaryKey(autoGenerate = true) var id : Int? = null,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "importance") val importance: Int
)