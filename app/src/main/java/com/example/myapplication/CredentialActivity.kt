package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment


class CredentialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credential)


        if (savedInstanceState == null) {
            showFragment(LoginFragment())
        }
    }

    fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }


    fun showLoginFragment() {
        showFragment(LoginFragment())
    }


    fun showSignUpFragment() {
        showFragment(SignUpFragment())
    }
}
