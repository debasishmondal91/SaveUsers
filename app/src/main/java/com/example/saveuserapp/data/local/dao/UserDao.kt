package com.example.saveuserapp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.saveuserapp.data.local.entity.User

@Dao
interface UserDao {
    @Insert
    fun addUser(user: User)

    @Query("SELECT * FROM user")
    fun getAllUser(): LiveData<List<User>>

}