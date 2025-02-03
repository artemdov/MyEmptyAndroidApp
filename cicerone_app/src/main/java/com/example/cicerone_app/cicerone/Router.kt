package com.example.cicerone_app.cicerone

import androidx.appcompat.app.AppCompatActivity

class Router(
    screenProvider: ScreenProvider,
    activity: AppCompatActivity,
) {
    private val commandBuffer = CommandBuffer(screenProvider, activity)

    fun navigateTo(screen: Screen) {
        commandBuffer.execute(Command.Forward(screen))
    }

    fun back(screen: Screen) {
        commandBuffer.execute(Command.Backward(screen))
    }
}