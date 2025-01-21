package com.example.p0191_simplecalculator

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), OnClickListener {
    var etNum1: EditText? = null
    var etNum2: EditText? = null

    var btnAdd: Button? = null
    var btnSub: Button? = null
    var btnMult: Button? = null
    var btnDiv: Button? = null

    var tvResult: TextView? = null

    var oper: String = ""

    val MENU_RESET_ID: Int = 1
    val MENU_QUIT_ID: Int = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMult = findViewById(R.id.btnMult);
        btnDiv = findViewById(R.id.btnDiv);

        tvResult = findViewById(R.id.tvResult);

        // прописываем обработчик
        btnAdd?.setOnClickListener(this);
        btnSub?.setOnClickListener(this);
        btnMult?.setOnClickListener(this);
        btnDiv?.setOnClickListener(this);

    }

    override fun onClick(v: View) {
        var num1 = 0f
        var num2 = 0f
        var result = 0f

        // Проверяем поля на пустоту
        if (TextUtils.isEmpty(etNum1?.getText().toString())
            || TextUtils.isEmpty(etNum2?.getText().toString())
        ) {
            return;
        }


        // читаем EditText и заполняем переменные числами
        num1 = etNum1?.getText().toString().toFloatOrNull() ?: 0f
        num2 = etNum2?.getText().toString().toFloatOrNull() ?: 0f

        when (v.id) {
            R.id.btnAdd -> {
                oper = "+"
                result = num1 + num2
            }

            R.id.btnSub -> {
                oper = "-"
                result = num1 - num2
            }

            R.id.btnMult -> {
                oper = "*"
                result = num1 * num2
            }

            R.id.btnDiv -> {
                oper = "/"
                result = num1 / num2
            }
        }

        // формируем строку вывода
        tvResult?.text = "$num1 $oper $num2 = $result"

    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {

        return super.onPrepareOptionsMenu(menu)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(Menu.NONE, MENU_RESET_ID, Menu.NONE, "Reset")
        menu.add(Menu.NONE, MENU_QUIT_ID, Menu.NONE, "Quit")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            MENU_RESET_ID -> {
                etNum1?.setText("")
                etNum2?.setText("")
                tvResult?.text = ""
                return true
            }
            MENU_QUIT_ID -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}