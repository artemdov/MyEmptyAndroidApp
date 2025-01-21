package com.example.p0261_intentfilter


import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Date


class ActivityTime : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        val sdf = SimpleDateFormat("HH:mm:ss")
        val time = sdf.format(Date(System.currentTimeMillis()))

        val tvTime: TextView = findViewById(R.id.tvTime)
        tvTime.text = time
    }
}
