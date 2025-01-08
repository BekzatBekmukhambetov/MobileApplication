package com.example.myapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.button.MaterialButton
import android.widget.Toast
import com.example.myapplication.CredentialsManager
import com.example.myapplication.R


class SignUpActivity : AppCompatActivity() {

    private val fullNameInput: TextInputLayout
        get() = findViewById(R.id.input_full_name)

    private val emailInput: TextInputLayout
        get() = findViewById(R.id.input_email)

    private val phoneInput: TextInputLayout
        get() = findViewById(R.id.input_phone_number)

    private val passwordInput: TextInputLayout
        get() = findViewById(R.id.input_password)

    private val signUpButton: MaterialButton
        get() = findViewById(R.id.button_1)

    val credentialsManager = CredentialsManager.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_screen)

        signUpButton.setOnClickListener { handleSignUp() }
    }

    private fun handleSignUp() {
        val fullName = fullNameInput.editText?.text.toString()
        val email = emailInput.editText?.text.toString()
        val phoneNumber = phoneInput.editText?.text.toString()
        val password = passwordInput.editText?.text.toString()

        val result = credentialsManager.register(fullName, email, phoneNumber, password)

        if (result == "Registration successful") {
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
        }
    }

    fun onClickGoLogin(view: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
