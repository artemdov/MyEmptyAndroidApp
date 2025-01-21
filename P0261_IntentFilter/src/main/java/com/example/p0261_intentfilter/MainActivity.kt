package com.example.p0261_intentfilter


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), OnClickListener {
    var btnTime: Button? = null
    var btnDate: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnTime = findViewById(R.id.btnTime)
        btnDate = findViewById(R.id.btnDate)

        btnTime?.setOnClickListener(this)
        btnDate?.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        var intent: Intent? = null

        when (v.id) {
            R.id.btnTime -> {
                intent = Intent("ru.startandroid.intent.action.showtime")
                startActivity(intent)
            }

            R.id.btnDate -> {
                intent = Intent("ru.startandroid.intent.action.showdate")
                startActivity(intent)
            }
        }
    }
}