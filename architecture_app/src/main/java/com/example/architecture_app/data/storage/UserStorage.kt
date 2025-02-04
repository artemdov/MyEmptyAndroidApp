package com.example.architecture_app.data.storage

import com.example.architecture_app.data.storage.models.User


interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}