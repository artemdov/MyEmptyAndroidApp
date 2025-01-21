package com.example.p0181_dynamiclayout3

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), OnSeekBarChangeListener {
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var seekBar: SeekBar
    private lateinit var lParams1: LinearLayout.LayoutParams
    private lateinit var lParams2: LinearLayout.LayoutParams

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        seekBar = findViewById(R.id.sbWeight)

        lParams1 =
            btn1.layoutParams as LinearLayout.LayoutParams
        lParams2 =
            btn2.layoutParams as LinearLayout.LayoutParams

        seekBar.setOnSeekBarChangeListener(this)

    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
        Log.d(progress.toString(), "progress: $progress")

        val rightVal = seekBar.max - progress
        //progress  это как левое значение

        lParams1.weight = progress.toFloat()
        lParams2.weight = rightVal.toFloat()

        btn1.text = progress.toString()
        btn2.text = rightVal.toString()
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        Log.d("SeekBar", "Tracking started")
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        Log.d("SeekBar", "Tracking stopped")
    }
}