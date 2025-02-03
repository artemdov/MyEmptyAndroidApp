package com.example.cicerone_app.cicerone

import androidx.fragment.app.Fragment

class ScreenProvider(screenAdapters: Map<Class<out Screen>,  FragmentScreenAdapter>) {
    private val screens: MutableMap<Class<out Screen>,  FragmentScreenAdapter> = mutableMapOf()

    init {
        screenAdapters.forEach{
            (screen, adapter) -> screens[screen] = adapter
        }
    }

    fun addAdapter(screen: Screen, adapter: FragmentScreenAdapter) {
        screens[screen.screenKey()] = adapter
    }

    fun getScreen(screen: Screen): Fragment {
       return requireNotNull(screens[screen.screenKey()]?.create()) {"screen nor found"}
    }
}
