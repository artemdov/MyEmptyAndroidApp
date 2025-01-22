package com.example.p0281_intentextras

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText


class MainActivity : Activity(), OnClickListener {
    var etFName: EditText? = null
    var etLName: EditText? = null

    var btnSubmit: Button? = null


    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etFName = findViewById<View>(R.id.etFName) as EditText
        etLName = findViewById<View>(R.id.etLName) as EditText

        btnSubmit = findViewById<View>(R.id.btnSubmit) as Button
        btnSubmit!!.setOnClickListener(this)
    }


    override fun onClick(v: View) {
        val intent = Intent(this, ViewActivity::class.java)
        intent.putExtra("fname", etFName!!.text.toString())
        intent.putExtra("lname", etLName!!.text.toString())
        startActivity(intent)
    }
}