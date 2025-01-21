package com.example.p0161_dynamiclayout

import android.os.Bundle
import android.view.ViewGroup.LayoutParams
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val linLayout = LinearLayout(this)
        linLayout.orientation = LinearLayout.VERTICAL

        val linLayoutParam = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        val lpView = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)

        val textView = TextView(this)
        textView.text = "Hello, Text"
        textView.setLayoutParams(lpView);
        linLayout.addView(textView) // Добавляем TextView в LinearLayout

        val button = Button(this)
        button.text = "Button"
        linLayout.addView(button, lpView) // Добавляем button в LinearLayout

        setContentView(linLayout, linLayoutParam)
    }
}