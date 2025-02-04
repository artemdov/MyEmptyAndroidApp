package com.example.architecture_app.data.repository

import com.example.architecture_app.domain.models.SaveUserNameParam
import com.example.architecture_app.domain.models.UserName
import com.example.architecture_app.domain.repository.UserRepository

class UserRepositoryImpl: UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        return saveParam.name.isNotEmpty()
    }

    override fun  getName(): UserName {
        val result = UserName(firstName = "Bobe", lastName = "Dick")

        return  result
    }
}