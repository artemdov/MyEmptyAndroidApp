package com.example.p0301_activityresult


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button


class AlignActivity : Activity(), OnClickListener {
    var btnLeft: Button? = null
    var btnCenter: Button? = null
    var btnRight: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.align)

        btnLeft = findViewById<View>(R.id.btnLeft) as Button
        btnCenter = findViewById<View>(R.id.btnCenter) as Button
        btnRight = findViewById<View>(R.id.btnRight) as Button

        btnLeft?.setOnClickListener(this)
        btnCenter?.setOnClickListener(this)
        btnRight?.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent = Intent()
        when (v.id) {
            R.id.btnLeft -> intent.putExtra("alignment", Gravity.LEFT)
            R.id.btnCenter -> intent.putExtra("alignment", Gravity.CENTER)
            R.id.btnRight -> intent.putExtra("alignment", Gravity.RIGHT)
        }
        setResult(RESULT_OK, intent)
        finish()
    }
}