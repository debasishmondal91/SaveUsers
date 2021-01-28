package com.example.saveuserapp

import android.app.Application
import com.example.saveuserapp.di.component.DaggerUserComponent
import com.example.saveuserapp.di.component.UserComponent
import com.example.saveuserapp.di.module.UserModule

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    lateinit var libraryComponent: UserComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        libraryComponent = DaggerUserComponent
            .builder()
            .userModule(UserModule(this))
            .build()
    }
}