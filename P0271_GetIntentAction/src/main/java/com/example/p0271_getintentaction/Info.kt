package com.example.p0271_getintentaction

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date

class Info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val intent: Intent? = null
        val action = intent?.action
        var format: String = ""
        var textInfo: String = ""

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.info)

        // в зависимости от action заполняем переменные
        if (action.equals("ru.startandroid.intent.action.showtime")) {
            format = "HH:mm:ss";
            textInfo = "Time: ";
        } else if (action.equals("ru.startandroid.intent.action.showdate")) {
            format = "dd.MM.yyyy";
            textInfo = "Date: ";
        }

        val sdf = SimpleDateFormat(format)
        val time = sdf.format(Date(System.currentTimeMillis()))

        val tvDate = findViewById<TextView>(R.id.tvInfo)
        tvDate.text = "$textInfo $time"
    }
}