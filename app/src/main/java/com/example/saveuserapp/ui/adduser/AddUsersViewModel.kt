package com.example.saveuserapp.ui.adduser

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.saveuserapp.data.local.entity.User
import com.example.saveuserapp.data.repository.UserRepository

class AddUsersViewModel(private val userRepository: UserRepository) : ViewModel() {

    val isNameEmpty = MutableLiveData<Boolean>()
    val isAddressEmpty = MutableLiveData<Boolean>()
    val isPhoneEmpty = MutableLiveData<Boolean>()
    val isEmailEmpty = MutableLiveData<Boolean>()

    private fun addNewUser(user: User) {
        userRepository.addUsers(user)
    }

    fun saveUser(
        addUserActivity: AddUserActivity,
        name: String,
        address: String,
        phone: String,
        email: String
    ) {
        isNameEmpty.value = name.isEmpty()
        isAddressEmpty.value = address.isEmpty()
        isPhoneEmpty.value = phone.isEmpty()
        isEmailEmpty.value = email.isEmpty()
        if (name.isNotEmpty() && address.isNotEmpty() && phone.isNotEmpty() && email.isNotEmpty()) {
            val user = User(
                name,
                address,
                phone,
                email
            )
            addNewUser(user)
            addUserActivity.finish()
        }
    }
}