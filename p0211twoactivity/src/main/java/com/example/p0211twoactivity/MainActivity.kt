package com.example.p0211twoactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), OnClickListener {
    var btnNavigate: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnNavigate = findViewById(R.id.btnActTwo)
        btnNavigate?.setOnClickListener(this);
    }

    override fun onClick(v: View) {
        val intent: Intent

        when (v.id) {
            R.id.btnActTwo -> {
                intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }
        }
    }
}