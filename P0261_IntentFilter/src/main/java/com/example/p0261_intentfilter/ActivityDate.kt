package com.example.p0261_intentfilter

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Date

class ActivityDate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)

        val sdf = SimpleDateFormat("dd.MM.yyyy")
        val date = sdf.format(Date(System.currentTimeMillis()))

        val tvTime: TextView = findViewById(R.id.tvDate)
        tvTime.text = date
    }
}