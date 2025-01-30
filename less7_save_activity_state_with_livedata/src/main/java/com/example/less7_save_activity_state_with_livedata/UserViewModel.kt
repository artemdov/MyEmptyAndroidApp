package com.example.less7_save_activity_state_with_livedata

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class UserViewModel : ViewModel() {

    var userList: MutableLiveData<List<User>> = MutableLiveData()

    //инициализируем список и заполняем его данными пользователей

    init {
        userList.value = UserData.getUsers()
        Log.d("##1Load",userList.value.toString())
    }

    fun getListUsers() = userList

    fun updateListUsers() {
        val currentList = userList.value ?: emptyList()
        val newUsers = UserData.getAnotherUsers()
        val updatedList = currentList + newUsers
        userList.value = updatedList
    }

}