package com.example.recyclerview

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var recView: RecyclerView? = null
    private var students: ArrayList<Student> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initializeData()
        recView = findViewById(R.id.recView)
        recView?.layoutManager = LinearLayoutManager(this)
        recView?.adapter = StudentAdapter(this, students)
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