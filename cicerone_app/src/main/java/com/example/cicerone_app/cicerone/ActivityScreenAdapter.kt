package com.example.cicerone_app.cicerone

import android.app.Activity

class ActivityScreenAdapter(val screen: () -> Activity) {

    fun create(): Activity = screen()
}