package com.example.architecture_app.domain.usecase

import com.example.architecture_app.domain.models.SaveUserNameParam
import com.example.architecture_app.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        val result = userRepository.saveName(saveParam = param)

        return result
    }
}