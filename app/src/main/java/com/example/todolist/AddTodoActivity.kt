package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todolist.databinding.ActivityAddTodoBinding
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.db.AppDatabase
import com.example.todolist.db.ToDoDao
import com.example.todolist.db.ToDoEntity

class AddTodoActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddTodoBinding
    lateinit var db : AppDatabase
    lateinit var toDoDao: ToDoDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getInstance(this)!!
        toDoDao = db.getTodoDao()

        binding.btnCompletion.setOnClickListener {
            insertTodo()
        }
    }
    /**
     *  @desc 일정 추가 함수
     */
    private fun insertTodo(){
        val todoTitle = binding.editTitle.text.toString() // 일정 제목
        var todoImportance = binding.radioGroup.checkedRadioButtonId // 일정의 중요도

        // 어떤 버튼이 눌렸는지 확인하고 값을 지정
        todoImportance = when(todoImportance){
            R.id.btn_high -> {
                1
            }
            R.id.btn_middle -> {
                2
            }
            R.id.btn_low -> {
                3
            }
            else -> {
                -1
            }
        }

        // 중요도가 선택되지 않거나, 제목이 작성되지 않았는지 체크
        if (todoImportance == -1 || todoTitle.isBlank()) {
            Toast.makeText(this, "모든 항목을 채워주세요.",
            Toast.LENGTH_SHORT).show()
        }else{
            Thread{
                toDoDao.insertTodo(ToDoEntity(null, todoTitle, todoImportance))
                runOnUiThread { // 아래 작업은 UI 스레드에서 실행해야 한다.
                    Toast.makeText(
                        this, "추가되었습니다.",
                        Toast.LENGTH_SHORT).show()
                    finish() // AddTodoActivity 종료, 다시 MainActivity로 돌아감
                }
            }.start()
        }
    }
}