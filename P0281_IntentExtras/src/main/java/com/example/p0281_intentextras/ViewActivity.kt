package com.example.p0281_intentextras

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var tvView: TextView
        val fname: String
        val lname: String
        val intent: Intent = intent

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view)


        tvView = findViewById(R.id.tvView)
        fname = intent.getStringExtra("fname").toString()
        lname = intent.getStringExtra("lname").toString()


        tvView.text = "Your name is: $fname $lname"
    }
}