package com.example.cicerone_app.cicerone

import androidx.appcompat.app.AppCompatActivity
import com.example.cicerone_app.R

class Navigator(
    private val screenProvider: ScreenProvider,
    private val activity: AppCompatActivity,
) {


    fun applyCommands(commands: ArrayList<Command>) {
        commands.forEach { command ->
            when (command) {
                is Command.Backward -> {
                    val fragment = screenProvider.getScreen(command.screen)
                    activity.supportFragmentManager.popBackStack() // Возвращаемся назад
//                    activity.supportFragmentManager.beginTransaction()
//                        .remove(fragment)
//                        .commit()

                }

                is Command.Forward -> {
                    val fragment = screenProvider.getScreen(command.screen)

                    activity.supportFragmentManager.beginTransaction()
//                        .setCustomAnimations(
//                            R.anim.slide_in,  // Анимация появления
//                            R.anim.slide_out, // Анимация исчезновения
//                            R.anim.slide_in,  // Анимация появления при возврате
//                            R.anim.slide_out  // Анимация исчезновения при возврате
//                        )
                        .replace(R.id.fragment_container, fragment, fragment.tag) // Заменяем текущий фрагмент
                        .addToBackStack(null) // Добавляем в BackStack
                        .commit()
                }
            }
        }
    }
}