package com.example.p0261_intentfilter

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date


class ActivityDateEx : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)

        val sdf = SimpleDateFormat("EEE, MMM d, yyyy")
        val date: String = sdf.format(Date(System.currentTimeMillis()))

        val tvDate = findViewById<View>(R.id.tvDate) as TextView
        tvDate.text = date
    }
}