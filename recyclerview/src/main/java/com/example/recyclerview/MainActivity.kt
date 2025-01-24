package com.example.recyclerview

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var recView: RecyclerView? = null
    private lateinit var studentAdapter: StudentAdapter
    private lateinit var students: ArrayList<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        students = ArrayList()
        initializeData()
        recView = findViewById(R.id.recView)
        studentAdapter = StudentAdapter(this, students)
        recView?.layoutManager = LinearLayoutManager(this)
        recView?.adapter = studentAdapter
    }

    private fun initializeData() {
        students.add(Student("Ivan Ivanov", 4, 9))
        students.add(Student("Boris Ivanov", 22, 5))
        students.add(Student("Peter Buk", 43, 7))
        students.add(Student("Tom Ivi", 12, 10))
        students.add(Student("Bob Ivanov", 1, 8))
        students.add(Student("Peter Buk", 43, 7))
        students.add(Student("Tom Ivi", 12, 10))
        students.add(Student("Bob Ivanov", 1, 8))
        students.add(Student("Peter Buk", 43, 7))
        students.add(Student("Tom Ivi", 12, 10))
        students.add(Student("Bob Ivanov", 1, 8))
    }
}