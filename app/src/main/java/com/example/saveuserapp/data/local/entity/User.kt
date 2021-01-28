package com.example.saveuserapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey
    val name: String,
    val address: String,
    val phone: String,
    val email: String
) {
}