package com.example.architecture_app.data.repository

import android.content.Context
import android.util.Log
import com.example.architecture_app.domain.models.SaveUserNameParam
import com.example.architecture_app.domain.models.UserName
import com.example.architecture_app.domain.repository.UserRepository

//здесь не должно быть логики и происходит сохранение и получение данных

//енамы лучше выносить вне, сейчас это так для наглядности
private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val KEY_DEFAULT_NAME = "defaultName"

class UserRepositoryImpl(context: Context) : UserRepository {
    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, saveParam.name).apply()
        Log.d(
            "##Nmae",
            sharedPreferences.edit().putString(KEY_FIRST_NAME, saveParam.name).apply().toString()
        )

        return saveParam.name.isNotEmpty()
    }

    override fun getName(): UserName {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "")?: ""
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, KEY_DEFAULT_NAME)?: KEY_DEFAULT_NAME
        val result = UserName(firstName = firstName, lastName = lastName)

        return result
    }
}