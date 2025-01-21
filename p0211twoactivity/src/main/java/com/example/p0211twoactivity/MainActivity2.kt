package com.example.p0211twoactivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity(), OnClickListener {
    var btnNavigate: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        btnNavigate = findViewById(R.id.btnActOne)
        btnNavigate?.setOnClickListener(this);
    }

    override fun onClick(v: View) {
        var intent: Intent? = null

        when (v.id) {
            R.id.btnActOne -> {
                intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}