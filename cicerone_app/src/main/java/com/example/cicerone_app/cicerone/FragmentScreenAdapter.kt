package com.example.cicerone_app.cicerone

import androidx.fragment.app.Fragment

class FragmentScreenAdapter(val screen: () -> Fragment) {

    fun create() = screen()
}