package com.example.architecture_app_added_dagger.domain.repository

import com.example.architecture_app_added_dagger.domain.models.SaveUserNameParam
import com.example.architecture_app_added_dagger.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}