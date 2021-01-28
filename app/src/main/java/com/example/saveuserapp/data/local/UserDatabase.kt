package com.example.saveuserapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.saveuserapp.data.local.dao.UserDao
import com.example.saveuserapp.data.local.entity.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao
}