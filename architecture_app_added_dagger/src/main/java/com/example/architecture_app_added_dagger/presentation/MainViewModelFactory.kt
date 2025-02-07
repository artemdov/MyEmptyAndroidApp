package com.example.architecture_app_added_dagger.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.architecture_app_added_dagger.domain.usecase.GetUserNameUseCase
import com.example.architecture_app_added_dagger.domain.usecase.SaveUserNameUseCase
import javax.inject.Inject


class MainViewModelFactory @Inject constructor(
     val getUserNameUseCase: GetUserNameUseCase,
     val saveUserNameUseCase: SaveUserNameUseCase,
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }
}