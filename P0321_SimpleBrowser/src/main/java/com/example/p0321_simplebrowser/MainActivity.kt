package com.example.p0321_simplebrowser

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View


class MainActivity : Activity() {
    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        var btnWeb
//        btnWeb = findViewById(R.id.btnWeb)
//        btnWeb?.setOnClickListener(this)
//        override fun onClick(v: View) {
//            var intent = Intent()
//
//            when (v.id) {
//                R.id.btnWeb -> {
//                    intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ya.ru"))
//                    startActivity(intent)
//                }
//
// сокращенная запись кода который выше

        (findViewById<View>(R.id.btnWeb)).setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("http://www.ya.ru")
                )
            )
        }
    }
}