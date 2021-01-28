package com.example.saveuserapp.data.repository

import androidx.lifecycle.LiveData
import com.example.saveuserapp.data.local.UserDatabase
import com.example.saveuserapp.data.local.dao.UserDao
import com.example.saveuserapp.data.local.entity.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepository(userDatabase: UserDatabase) {

    private var userDao: UserDao = userDatabase.getUserDao()

    fun getAllUsers(): LiveData<List<User>> {
        return userDao.getAllUser()
    }

    fun addUsers(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            userDao.addUser(user)
        }
    }
}