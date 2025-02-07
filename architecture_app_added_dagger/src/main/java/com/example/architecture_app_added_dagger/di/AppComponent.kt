package com.example.architecture_app_added_dagger.di

import com.example.architecture_app_added_dagger.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)

}