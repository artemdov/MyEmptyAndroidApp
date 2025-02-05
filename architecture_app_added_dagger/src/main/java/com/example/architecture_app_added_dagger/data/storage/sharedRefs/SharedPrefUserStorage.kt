package com.example.architecture_app_added_dagger.data.storage.sharedRefs

import android.content.Context
import com.example.architecture_app_added_dagger.data.storage.UserStorage
import com.example.architecture_app_added_dagger.data.storage.models.User

//эта папка storage и файлы хранят сейчас логику, вынесенную из UserRepositoryImpl

//енамы лучше выносить вне, сейчас это так для наглядности
private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_NAME = "defaultName"



class SharedPrefUserStorage(context: Context) : UserStorage {
    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, user.lastName).apply()

        return user.firstName.isNotEmpty() || user.lastName.isNotEmpty()

    }

    override fun get(): User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "") ?: ""
        val lastName =
            sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_NAME) ?: DEFAULT_NAME
        val result = User(firstName = firstName, lastName = lastName)

        return result
    }

}