package com.example.p0091_onclickbuttons


import android.app.Activity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView


//Соответственно для реализации обработки событий необходимо выполнить следующие шаги:
//- создаем обработчик
//- заполняем метод onClick
//- присваиваем обработчик кнопке

class MainActivity : Activity() {
    var tvOut: TextView? = null
    var btnOk: Button? = null
    var btnCancel: Button? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // найдем View-элементы
        tvOut = findViewById(R.id.tvOut)
        btnOk = findViewById(R.id.btnOk)
        btnCancel = findViewById(R.id.btnCancel)


        // создаем обработчик нажатия
        val oclBtnOk = OnClickListener { // Меняем текст в TextView (tvOut)
            tvOut?.text = "Нажата кнопка ОК"
        }

        val oclBtnCancel = OnClickListener { // Меняем текст в TextView (tvOut)
            tvOut?.text = "Нажата кнопка CANCEL"
        }

        // присвоим обработчик кнопке Cancel (btnCancel)
        btnCancel?.setOnClickListener(oclBtnCancel)
        // присвоим обработчик кнопке OK (btnOk)
        btnOk?.setOnClickListener(oclBtnOk)
    }
}

