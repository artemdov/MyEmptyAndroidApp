package com.example.cicerone_app

import com.example.cicerone_app.cicerone.FragmentScreenAdapter
import com.example.cicerone_app.cicerone.Screen
import com.example.cicerone_app.screens.BlancFragmentScreen
import com.example.cicerone_app.screens.SecondFragmentScreen

internal val SCREEN_PROVIDERS: Map<Class<out Screen>, FragmentScreenAdapter> = mapOf(
    BlancFragmentScreen::class.java to FragmentScreenAdapter { BlankFragment() },
    SecondFragmentScreen::class.java to FragmentScreenAdapter { SecondBlankFragment() }
)