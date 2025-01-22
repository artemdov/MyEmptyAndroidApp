package com.example.p0301_activityresult

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView


class MainActivity : Activity(), OnClickListener {
    var tvText: TextView? = null
    var btnColor: Button? = null
    var btnAlign: Button? = null

    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvText = findViewById<View>(R.id.tvText) as TextView

        btnColor = findViewById<View>(R.id.btnColor) as Button
        btnAlign = findViewById<View>(R.id.btnAlign) as Button

        btnColor!!.setOnClickListener(this)
        btnAlign!!.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        // TODO Auto-generated method stub
    }
}