package com.example.architecture_app_added_dagger.data.repository

import com.example.architecture_app_added_dagger.data.storage.sharedRefs.SharedPrefUserStorage
import com.example.architecture_app_added_dagger.data.storage.models.User
import com.example.architecture_app_added_dagger.domain.models.SaveUserNameParam
import com.example.architecture_app_added_dagger.domain.models.UserName
import com.example.architecture_app_added_dagger.domain.repository.UserRepository

//здесь не должно быть логики и происходит сохранение и получение данных
//только данные храняться в слое storage так как здесь в слое repository
//также можно делать запросы на сервер и тд
//для примера ниже закоменченный код с запросами
//то есть получается repository является как связующее звено которое соединяет все вместе

class UserRepositoryImpl(private val userStorage: SharedPrefUserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)

        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()

        return mapToDomain(user)
    }

    //напишем мапперы для связывания моделей
    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
}
//class UserRepositoryImpl(
//    private val userStorage: SharedPrefUserStorage,
//    private val networkApi: NetworkApi,
//) : UserRepository {
//
//    override fun saveName(saveParam: SaveUserNameParam): Boolean {
//        networkApi.saveDataOnServer
//        return userStorage.save(saveParam)
//    }
//
//    override fun getName(): UserName {
//        networkApi.getDataFromServer
//        return userStorage.get()
//    }
//}