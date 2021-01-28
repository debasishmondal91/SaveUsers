package com.example.saveuserapp.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.saveuserapp.R
import com.example.saveuserapp.ui.adduser.AddUserActivity
import com.example.saveuserapp.ui.users.UsersListActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_user.setOnClickListener {
            val intent = Intent(this, AddUserActivity::class.java)
            startActivity(intent)
        }

        show_users.setOnClickListener {
            val intent = Intent(this, UsersListActivity::class.java)
            startActivity(intent)
        }

    }
}