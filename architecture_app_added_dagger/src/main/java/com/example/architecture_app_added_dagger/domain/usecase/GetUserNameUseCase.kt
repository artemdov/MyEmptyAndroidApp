package com.example.architecture_app_added_dagger.domain.usecase

import com.example.architecture_app_added_dagger.domain.models.UserName
import com.example.architecture_app_added_dagger.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        val result = userRepository.getName()

        return result
    }
}