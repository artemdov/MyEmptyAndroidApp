package com.example.recyclerviewhard

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recView: RecyclerView
    private lateinit var personAdapter: PersonAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Инициализируем RecyclerView
        recView = findViewById(R.id.recyclerView)
        recView.layoutManager = LinearLayoutManager(this)

        // Создаем адаптер БЕЗ данных
        personAdapter = PersonAdapter(this, emptyList())
        recView.adapter = personAdapter

        // Получаем данные из PersonService
        val personService = PersonService()
        val persons = personService.getPersons() // Получаем список людей

        // Передаем данные в адаптер
        personAdapter.updateData(persons) // Вызов updateData для обновления данных

    }
}