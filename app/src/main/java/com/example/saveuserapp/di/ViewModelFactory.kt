package com.example.saveuserapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.saveuserapp.data.repository.UserRepository
import com.example.saveuserapp.ui.adduser.AddUsersViewModel
import com.example.saveuserapp.ui.users.UsersListViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject constructor(private var userRepository: UserRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AddUsersViewModel::class.java) -> {
                AddUsersViewModel(
                    userRepository
                ) as T
            }
            modelClass.isAssignableFrom(UsersListViewModel::class.java) -> {
                UsersListViewModel(
                    userRepository
                ) as T
            }

            else -> throw IllegalArgumentException("Unknown class name")
        }
    }
}