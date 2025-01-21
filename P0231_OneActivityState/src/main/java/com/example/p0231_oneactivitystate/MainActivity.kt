package com.example.p0231_oneactivitystate

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button


class MainActivity : Activity(), OnClickListener {
    val TAG: String = "###States"

    var btnActTwo: Button? = null


    @SuppressLint("MissingInflatedId")
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnActTwo = findViewById(R.id.btnActTwo)
        btnActTwo?.setOnClickListener(this)

        Log.d(TAG, "MainActivity: onCreate()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "MainActivity: onRestart()")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "MainActivity: onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MainActivity: onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "MainActivity: onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "MainActivity: onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MainActivity: onDestroy()")
    }

    override fun onClick(v: View) {
        var intent: Intent? = null

        when (v.id) {
            R.id.btnActTwo -> {
                intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }
        }
    }
}