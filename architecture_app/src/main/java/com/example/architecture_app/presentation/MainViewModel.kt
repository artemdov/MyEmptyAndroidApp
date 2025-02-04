package com.example.architecture_app.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.architecture_app.domain.models.SaveUserNameParam
import com.example.architecture_app.domain.usecase.GetUserNameUseCase
import com.example.architecture_app.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val saveUserNameUseCase: SaveUserNameUseCase,
    private val getUserNameUseCase: GetUserNameUseCase,
) : ViewModel() {

    private val _resultLiveData = MutableLiveData<String>()

    val resultLiveData: LiveData<String> = _resultLiveData

    init {
        Log.d("AAA1", "VM created")
    }

    override fun onCleared() {
        Log.d("AAA2", "VM cleared")
        super.onCleared()
    }

    fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        val isNameNoEmpty: Boolean = saveUserNameUseCase.execute(params)

        _resultLiveData.value = if (isNameNoEmpty) text else "Данные не сохранены"

    }

    fun load() {
        val userName = getUserNameUseCase.execute()
        _resultLiveData.value = "${userName.firstName} ${userName.lastName}"

    }
}