package com.example.architecture_app.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.architecture_app.data.repository.UserRepositoryImpl
import com.example.architecture_app.data.storage.sharedRefs.SharedPrefUserStorage
import com.example.architecture_app.domain.usecase.GetUserNameUseCase
import com.example.architecture_app.domain.usecase.SaveUserNameUseCase


//это фабрика которая создает  ViewModels а также создание юскейсов
class MainViewModelFactory(private val applicationContext: Context) : ViewModelProvider.Factory {

    //LazyThreadSafetyMode.NONE подключаем чтобы не было многопоточности
    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = applicationContext))
    }


    //подключаем юскейсы к активити
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(
            userRepository = userRepository
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }
}