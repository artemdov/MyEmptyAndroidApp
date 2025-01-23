package com.example.p0401_layoutinflaternew


import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    val LOG_TAG: String = "myLogs"

    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ltInflater = layoutInflater

        val linLayout = findViewById<LinearLayout>(R.id.linLayout)
        val view1: View = ltInflater.inflate(R.layout.text, linLayout, true)
        val lp1: ViewGroup.LayoutParams? = view1.layoutParams


        Log.d(LOG_TAG, "Class of view1: " + view1.javaClass.toString())
        Log.d(LOG_TAG, "Class of layoutParams of view1: " + lp1?.javaClass.toString())
//        Log.d(LOG_TAG, "Text of view1: " + (view1 as TextView).text)


        val relLayout = findViewById<RelativeLayout>(R.id.relLayout)
        val view2: View = ltInflater.inflate(R.layout.text, relLayout, true)
        val lp2: ViewGroup.LayoutParams? = view2.layoutParams
        Log.d(LOG_TAG, "Class of view2: " + view2.javaClass.toString())
        Log.d(LOG_TAG, "Class of layoutParams of view2: " + lp2?.javaClass.toString())
//        Log.d(LOG_TAG, "Text of view2: " + (view2 as TextView).text)
    }
}