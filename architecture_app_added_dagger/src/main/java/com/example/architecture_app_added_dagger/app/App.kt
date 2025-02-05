package com.example.architecture_app_added_dagger.app

import android.app.Application
import com.example.architecture_app_added_dagger.di.AppComponent
import com.example.architecture_app_added_dagger.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .context(this)
            .build()
    }
}
