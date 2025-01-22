package com.example.p0301_activityresult

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class ColorActivity : AppCompatActivity(), OnClickListener {
    var btnRed: Button? = null
    var btnGreen: Button? = null
    var btnBlue: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.color)

        btnRed = findViewById(R.id.btnRed);
        btnGreen = findViewById(R.id.btnGreen);
        btnBlue = findViewById(R.id.btnBlue);

        btnRed?.setOnClickListener(this);
        btnGreen!!.setOnClickListener(this);
        btnBlue?.setOnClickListener(this);

    }

    override fun onClick(v: View) {
        val intent = Intent()

        when (v.id) {
            R.id.btnRed -> intent.putExtra("color", Color.RED);
            R.id.btnBlue -> intent.putExtra("color", Color.BLUE);
            R.id.btnGreen -> intent.putExtra("color", Color.GREEN);
        }

        setResult(RESULT_OK, intent)
        finish()
    }
}