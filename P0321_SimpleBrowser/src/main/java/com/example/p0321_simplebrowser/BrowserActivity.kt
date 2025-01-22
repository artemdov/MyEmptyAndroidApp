package com.example.p0321_simplebrowser


import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BrowserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.browser)

        val webView = findViewById<WebView>(R.id.webView)
        webView.webViewClient = WebViewClient()

        val data: Uri? = intent.data
        Log.d("##data", "$data")
        if (data != null) {
            Log.d("##BrowserActivity", "Received URL: $data")
            webView.loadUrl(data.toString())
        } else {
            Log.e("##BrowserActivity", "No URL received!")
            // Покажите какое-то сообщение пользователю
        }
    }

}