package com.example.architecture_app_added_dagger.di

import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {


}