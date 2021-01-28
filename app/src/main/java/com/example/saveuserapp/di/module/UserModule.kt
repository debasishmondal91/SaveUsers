package com.example.saveuserapp.di.module

import androidx.room.Room
import com.example.saveuserapp.App
import com.example.saveuserapp.data.local.UserDatabase
import com.example.saveuserapp.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UserModule(app: App) {
    private lateinit var userDatabase: UserDatabase
    private var application = app

    @Singleton
    @Provides
    fun providesUserRepository(userDatabase: UserDatabase): UserRepository {
        return UserRepository(userDatabase)
    }

    @Singleton
    @Provides
    fun providesRoomDatabase(): UserDatabase {
        userDatabase = Room.databaseBuilder(application, UserDatabase::class.java, "user_database")
            .fallbackToDestructiveMigration()
            .build()
        return userDatabase
    }
}