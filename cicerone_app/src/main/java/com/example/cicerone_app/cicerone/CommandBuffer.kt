package com.example.cicerone_app.cicerone

import androidx.appcompat.app.AppCompatActivity

class CommandBuffer(
    screenProvider: ScreenProvider,
    activity: AppCompatActivity,
) {

    private val navigator = Navigator(screenProvider, activity)

    private val commands: ArrayList<Command> = ArrayList()

    fun execute(command: Command) {
        commands.add(command)
        navigator.applyCommands(commands)
    }
}