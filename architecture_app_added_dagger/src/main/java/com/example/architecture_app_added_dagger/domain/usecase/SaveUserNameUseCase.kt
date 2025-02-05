package com.example.architecture_app_added_dagger.domain.usecase

import com.example.architecture_app_added_dagger.domain.models.SaveUserNameParam
import com.example.architecture_app_added_dagger.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        val result = userRepository.saveName(saveParam = param)

        return result
    }
}