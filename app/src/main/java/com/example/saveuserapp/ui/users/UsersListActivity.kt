package com.example.saveuserapp.ui.users

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.saveuserapp.App
import com.example.saveuserapp.R
import com.example.saveuserapp.di.ViewModelFactory
import kotlinx.android.synthetic.main.activity_users_list.*
import javax.inject.Inject

class UsersListActivity : AppCompatActivity() {

    lateinit var usersListViewModel: UsersListViewModel
    lateinit var usersListAdapter: UsersListAdapter

    @Inject
    lateinit var userFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users_list)
        App.instance.libraryComponent.inject(this)
        setUpViewModel()
        observeViewModel()
    }

    private fun observeViewModel() {
        usersListViewModel.getAllUsers().observe(this, Observer {
            recycler_users.layoutManager = LinearLayoutManager(this)
            usersListAdapter = UsersListAdapter(it)
            recycler_users.adapter = usersListAdapter
        })
    }

    private fun setUpViewModel() {
        usersListViewModel =
            ViewModelProviders.of(this, userFactory)[UsersListViewModel::class.java]
    }
}