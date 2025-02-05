package com.example.architecture_app_added_dagger.di

import android.content.Context
import com.example.architecture_app_added_dagger.domain.usecase.GetUserNameUseCase
import com.example.architecture_app_added_dagger.domain.usecase.SaveUserNameUseCase
import com.example.architecture_app_added_dagger.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideMainViewModelFactory(
        getUserNameUseCase: GetUserNameUseCase,
        saveUserNameUseCase: SaveUserNameUseCase,
    ): MainViewModelFactory {

        return MainViewModelFactory(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        )
    }


}