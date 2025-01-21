package com.example.p0231_oneactivitystate

import android.app.Activity
import android.os.Bundle
import android.util.Log


class MainActivity2 : Activity() {
    val TAG: String = "##States2"

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Log.d(TAG, "ActivityTwo: onCreate()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "ActivityTwo: onRestart()")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "ActivityTwo: onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "ActivityTwo: onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "ActivityTwo: onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "ActivityTwo: onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "ActivityTwo: onDestroy()")
    }
}