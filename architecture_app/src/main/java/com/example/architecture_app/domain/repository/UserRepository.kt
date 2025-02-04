package com.example.architecture_app.domain.repository

import com.example.architecture_app.domain.models.SaveUserNameParam
import com.example.architecture_app.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}