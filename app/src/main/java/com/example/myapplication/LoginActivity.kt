package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    private val emailInput: TextInputLayout
        get() = findViewById(R.id.login_email)

    private val passwordInput: TextInputLayout
        get() = findViewById(R.id.login_password)

    private val loginButton: MaterialButton
        get() = findViewById(R.id.button_1)

    val credentialsManager = CredentialsManager.instance
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)

        loginButton.setOnClickListener {
            handleLogin()
        }
    }


    private fun handleLogin() {
        val email = emailInput.editText?.text.toString()
        val password = passwordInput.editText?.text.toString()


        if (!CredentialsManager().isEmailValid(email)) {
            emailInput.error = "Invalid email "
        } else {
            emailInput.error = null
        }


        if (!CredentialsManager().isPasswordValid(password)) {
            passwordInput.error = "Password cannot be empty!!!"
        } else {
            passwordInput.error = null
        }


        val user = credentialsManager.credentialsMap[email]
        if (user != null && user.password == password) {
            emailInput.error = null
            passwordInput.error = null
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            passwordInput.error = "Incorrect email or password"
        }
    }


    fun onClickGoSignUp(view : View){
    val intent = Intent(this,SignUpActivity::class.java)
        startActivity(intent)
        finish()
    }
}