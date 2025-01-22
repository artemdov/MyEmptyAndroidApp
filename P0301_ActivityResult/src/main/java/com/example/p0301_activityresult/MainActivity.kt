package com.example.p0301_activityresult

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : Activity(), OnClickListener {
    var tvText: TextView? = null
    var btnColor: Button? = null
    var btnAlign: Button? = null

    val REQUEST_CODE_COLOR: Int = 1
    val REQUEST_CODE_ALIGN: Int = 2

    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvText = findViewById<View>(R.id.tvText) as TextView

        btnColor = findViewById<View>(R.id.btnColor) as Button
        btnAlign = findViewById<View>(R.id.btnAlign) as Button

        btnColor!!.setOnClickListener(this)
        btnAlign!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        var intent = Intent()

        when (v.id) {
            R.id.btnColor -> {
                intent = Intent(this, ColorActivity::class.java)
                startActivityForResult(intent, REQUEST_CODE_COLOR)
            }

            R.id.btnAlign -> {
                intent = Intent(this, AlignActivity::class.java)
                startActivityForResult(intent, REQUEST_CODE_ALIGN)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // запишем в лог значения requestCode и resultCode
        Log.d("myLogs", "requestCode = " + requestCode + ", resultCode = " + resultCode);

        if (data == null) return

        if (resultCode == RESULT_OK) {
            Log.d(requestCode.toString(), "###requestCode")
            when (requestCode) {

                REQUEST_CODE_COLOR -> {
                    val color = data.getIntExtra("color", Color.WHITE)
                    tvText?.setTextColor(color)
                }

                REQUEST_CODE_ALIGN -> {
                    val align = data.getIntExtra("alignment", Gravity.CENTER)
                    tvText?.gravity = align
                }
            }

        } else {
            Toast.makeText(this, "Wrong result", Toast.LENGTH_SHORT).show();
        }

    }
}