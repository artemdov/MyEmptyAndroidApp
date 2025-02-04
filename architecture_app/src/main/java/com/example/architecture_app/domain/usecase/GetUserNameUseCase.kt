package com.example.architecture_app.domain.usecase

import com.example.architecture_app.domain.models.UserName
import com.example.architecture_app.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        val result = userRepository.getName()

        return result
    }
}