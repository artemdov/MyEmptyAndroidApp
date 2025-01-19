package com.example.p0101_listener

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView


class MainActivity : Activity() {
    var tvOut: TextView? = null
    var btnOk: Button? = null
    var btnCancel: Button? = null

    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // найдем View-элементы
        tvOut = findViewById(R.id.tvOut)
        btnOk = findViewById(R.id.btnOk)
        btnCancel = findViewById(R.id.btnCancel)


        // создание обработчика
        val oclBtn = OnClickListener { v ->
            when (v.id) {
                R.id.btnOk -> tvOut?.text = "Нажата кнопка ОК"
                R.id.btnCancel -> tvOut?.text = "Нажата кнопка Cancel"
            }
        }

        btnCancel?.setOnClickListener(oclBtn)
        btnOk?.setOnClickListener(oclBtn)
    }
}