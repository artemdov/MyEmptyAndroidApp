package com.example.p0171_dynamiclayout2

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var btnCreate: Button
    private lateinit var btnClear: Button
    private lateinit var rgGravity: RadioGroup
    private lateinit var etName: EditText
    private lateinit var llMain: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnCreate = findViewById(R.id.btnCreate)
        btnClear = findViewById(R.id.btnClear)
        llMain = findViewById(R.id.llMain)
        rgGravity = findViewById(R.id.rgGravity)
        etName = findViewById(R.id.etName)

        btnCreate.setOnClickListener(this)
        btnClear.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnCreate -> {
                val lParams =
                    LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)

                var btnGravity = Gravity.LEFT

                when (rgGravity.checkedRadioButtonId) {
                    R.id.rbLeft -> btnGravity = Gravity.LEFT
                    R.id.rbRight -> btnGravity = Gravity.RIGHT
                    R.id.rbCenter -> btnGravity = Gravity.CENTER
                }

                lParams.gravity = btnGravity

                val button = Button(this)
                button.text = etName.text.toString()
                llMain.addView(button, lParams)

            }

            R.id.btnClear -> {
                llMain.removeAllViews()
                Toast.makeText(this, "Удалено", Toast.LENGTH_SHORT).show()
            }
        }
    }
}