package com.example.p0291_simpleactivityresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), OnClickListener {
    var tvName: TextView? = null
    var btnName: Button? = null

//    private val startNameActivity =
//        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
//        { result ->
//            if (result.resultCode == Activity.RESULT_OK) {
//                val data: Intent? = result.data
//                Log.d(data.toString(), "##name")
//                val name = data?.getStringExtra("name")
//                Log.d(name, "##name")
//                tvName?.text = "Your name is $name"
//            }
//        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnName = findViewById(R.id.btnName)
        tvName = findViewById(R.id.tvName)

        btnName?.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val intent = Intent(this, NameActivity::class.java)
        startActivityForResult(intent, 1);
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d(data.toString(), "##data")
        if (data == null) return
        val name = data.getStringExtra("name")
        Log.d(name, "##name")
        tvName?.text = "Your name is $name"

    }
}