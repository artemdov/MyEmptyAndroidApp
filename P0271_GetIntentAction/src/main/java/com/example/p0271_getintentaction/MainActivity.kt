package com.example.p0271_getintentaction

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button


class MainActivity : Activity(), OnClickListener {
    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTime = findViewById<View>(R.id.btnTime) as Button
        val btnDate = findViewById<View>(R.id.btnDate) as Button

        btnTime.setOnClickListener(this)
        btnDate.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent: Intent

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