package com.example.p0102_activitylistener

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView



class MainActivity : Activity(), OnClickListener {

    private lateinit var tvOut: TextView
    private lateinit var btnOk: Button
    private lateinit var btnCancel: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Найдем View-элементы
        tvOut = findViewById(R.id.tvOut)
        btnOk = findViewById(R.id.btnOk)
        btnCancel = findViewById(R.id.btnCancel)

        // Установим Activity в качестве обработчика для кнопок
        btnOk.setOnClickListener(this)
        btnCancel.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnOk -> tvOut.text = "Нажата кнопка ОК"
            R.id.btnCancel -> tvOut.text = "Нажата кнопка Cancel"
        }
    }
}