package com.example.p0291_simpleactivityresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class NameActivity : AppCompatActivity(), OnClickListener {
    var etName: TextView? = null
    var btnOk: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_name)

        btnOk = findViewById(R.id.btnOK)
        etName = findViewById(R.id.etName)

        btnOk?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("name", etName?.text.toString())
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}