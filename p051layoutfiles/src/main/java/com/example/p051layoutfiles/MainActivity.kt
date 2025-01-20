package com.example.p051layoutfiles

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.myscreen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.textView1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textView1 = findViewById<TextView>(R.id.textView1)

        textView1.text = "Neew text"

        val button = findViewById<Button>(R.id.button4)

        button.text = "New button"

        button.isEnabled = false
    }
}