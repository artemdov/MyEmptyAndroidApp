package com.example.p0331_sharedpreferences


import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), OnClickListener {
    var etText: EditText? = null
    var btnSave: Button? = null
    var btnLoad: Button? = null
    var sPref: SharedPreferences? = null
    val SAVED_TEXT: String = "saved_text"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnSave = findViewById(R.id.btnSave)
        btnLoad = findViewById(R.id.btnLoad)
        etText = findViewById(R.id.etText)

        btnSave?.setOnClickListener(this)
        btnLoad?.setOnClickListener(this)
    }


    override fun onClick(v: View) {
        fun saveText() {
            sPref = getPreferences(MODE_PRIVATE)
            val ed = sPref?.edit()
            ed?.putString(SAVED_TEXT, etText?.text.toString())
            ed?.commit()
            Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
        }

        fun loadText() {
            sPref = getPreferences(MODE_PRIVATE)
            val savedText = sPref?.getString(SAVED_TEXT, "")
            etText?.setText(savedText);
            Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
        }

        when (v.id) {
            R.id.btnSave -> saveText()
            R.id.btnLoad -> loadText()
        }
    }
}