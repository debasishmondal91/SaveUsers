package com.example.saveuserapp.di.component

import com.example.saveuserapp.di.module.UserModule
import com.example.saveuserapp.ui.adduser.AddUserActivity
import com.example.saveuserapp.ui.main.MainActivity
import com.example.saveuserapp.ui.users.UsersListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UserModule::class])
interface UserComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(addUserActivity: AddUserActivity)
    fun inject(usersListActivity: UsersListActivity)
}