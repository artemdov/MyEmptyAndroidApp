package com.example.architecture_app_added_dagger.di

import android.content.Context
import com.example.architecture_app_added_dagger.data.repository.UserRepositoryImpl
import com.example.architecture_app_added_dagger.data.storage.UserStorage
import com.example.architecture_app_added_dagger.data.storage.sharedRefs.SharedPrefUserStorage
import com.example.architecture_app_added_dagger.domain.repository.UserRepository

import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage (context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun provideUserRepository(userStorage: SharedPrefUserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }

}