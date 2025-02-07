package com.example.architecture_app_added_dagger.domain.usecase

import com.example.architecture_app_added_dagger.domain.models.SaveUserNameParam
import com.example.architecture_app_added_dagger.domain.repository.UserRepository
import javax.inject.Inject

class SaveUserNameUseCase @Inject constructor(val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        val result = userRepository.saveName(saveParam = param)

        return result
    }
}