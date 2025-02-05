package com.example.architecture_app_added_dagger.data.storage

import com.example.architecture_app_added_dagger.data.storage.models.User


interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}