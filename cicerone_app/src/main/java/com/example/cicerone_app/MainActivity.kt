package com.example.cicerone_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.cicerone_app.cicerone.Router
import com.example.cicerone_app.cicerone.ScreenProvider
import com.example.cicerone_app.screens.BlancFragmentScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val router = Router(ScreenProvider(SCREEN_PROVIDERS), this)

        router.navigateTo(BlancFragmentScreen)
    }
}