package com.example.todolist.db

import android.content.Context
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ToDoEntity::class], version = 1) // 조건 1
abstract class AppDatabase : RoomDatabase() { // 조건 2
    abstract fun getTodoDao() : ToDoDao // 조건 3

    companion object{
        val databaseName = "db_todo" // 데이터베이스 이름
        var appDatabase: AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase? {
            if (appDatabase == null){
                appDatabase = Room.databaseBuilder(context,
                AppDatabase::class.java,
                databaseName).build()
            }
            return appDatabase
        }

    }


}