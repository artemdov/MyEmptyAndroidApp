package com.example.architecture_app_added_dagger.di

import com.example.architecture_app_added_dagger.domain.repository.UserRepository
import com.example.architecture_app_added_dagger.domain.usecase.GetUserNameUseCase
import com.example.architecture_app_added_dagger.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

//    @Provides
//    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase {
//        return SaveUserNameUseCase(userRepository = userRepository)
//    }
//
//    @Provides
//    fun getUserNameUseCase(userRepository: UserRepository): GetUserNameUseCase {
//        return GetUserNameUseCase(userRepository = userRepository)
//    }
}
