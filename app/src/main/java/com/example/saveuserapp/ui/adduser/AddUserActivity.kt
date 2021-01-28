package com.example.saveuserapp.ui.adduser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.saveuserapp.App
import com.example.saveuserapp.R
import com.example.saveuserapp.di.ViewModelFactory
import kotlinx.android.synthetic.main.activity_add_user.*
import javax.inject.Inject

class AddUserActivity : AppCompatActivity() {

    private lateinit var addUsersViewModel: AddUsersViewModel

    @Inject
    lateinit var userFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)
        App.instance.libraryComponent.inject(this)
        setUpViewModel()
        setUpView()
        observeViewModel()
    }

    private fun setUpView() {
        save_user.setOnClickListener {
            val name = edt_name.text.toString()
            val address = edt_address.text.toString()
            val phone = edt_phone.text.toString()
            val email = edt_email.text.toString()

            addUsersViewModel.saveUser(this, name, address, phone, email)
        }
    }

    private fun observeViewModel() {
        addUsersViewModel.isNameEmpty.observe(this, Observer {
            if (it) edt_name.error = getString(R.string.name_error)
        })
        addUsersViewModel.isAddressEmpty.observe(this, Observer {
            if (it) edt_address.error = getString(R.string.address_error)
        })
        addUsersViewModel.isPhoneEmpty.observe(this, Observer {
            if (it) edt_phone.error = getString(R.string.phone_error)
        })
        addUsersViewModel.isEmailEmpty.observe(this, Observer {
            if (it) edt_email.error = getString(R.string.email_error)
        })
    }

    private fun setUpViewModel() {
        addUsersViewModel = ViewModelProviders.of(this, userFactory)[AddUsersViewModel::class.java]
    }
}