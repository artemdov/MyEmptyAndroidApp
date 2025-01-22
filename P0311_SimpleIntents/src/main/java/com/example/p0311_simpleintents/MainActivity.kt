package com.example.p0311_simpleintents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), OnClickListener {
    var btnWeb: Button? = null
    var btnMap: Button? = null
    var btnCall: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnMap = findViewById(R.id.btnMap)
        btnWeb = findViewById(R.id.btnWeb)
        btnCall = findViewById(R.id.btnCall)

        btnMap?.setOnClickListener(this)
        btnWeb?.setOnClickListener(this)
        btnCall?.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        var intent = Intent()
        //варианты использования Intent как можно засетать данные в обьект Intent
        when (v.id) {
            R.id.btnWeb -> {
                intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com"))
                startActivity(intent)
            }

            R.id.btnMap -> {
                intent.setAction(Intent.ACTION_VIEW)
                intent.setData(Uri.parse("geo:55.754283,37.62002"))
                startActivity(intent)
            }

            R.id.btnCall -> {
                intent = Intent(Intent.ACTION_DIAL)
                intent.setData(Uri.parse("tel:+375"))
                startActivity(intent)
            }
        }
    }
}