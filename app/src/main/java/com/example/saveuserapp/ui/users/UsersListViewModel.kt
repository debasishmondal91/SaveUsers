package com.example.saveuserapp.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.saveuserapp.data.local.entity.User
import com.example.saveuserapp.data.repository.UserRepository

class UsersListViewModel(private val userRepository: UserRepository) : ViewModel() {

    fun getAllUsers(): LiveData<List<User>> {
        return userRepository.getAllUsers()
    }
}