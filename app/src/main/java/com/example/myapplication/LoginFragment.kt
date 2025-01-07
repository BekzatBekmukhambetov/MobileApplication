package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {

    private lateinit var emailInput: TextInputLayout
    private lateinit var passwordInput: TextInputLayout
    private lateinit var loginButton: MaterialButton
    private lateinit var registerText: TextView
    private val credentialsManager = CredentialsManager.instance

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)


        emailInput = view.findViewById(R.id.login_email)
        passwordInput = view.findViewById(R.id.login_password)
        loginButton = view.findViewById(R.id.button_1)
        registerText = view.findViewById(R.id.BottomText)


        loginButton.setOnClickListener {
            handleLogin()
        }


        registerText.setOnClickListener {
            onClickGoSignUp()
        }

        return view
    }

    private fun handleLogin() {
        val email = emailInput.editText?.text.toString()
        val password = passwordInput.editText?.text.toString()


        if (!credentialsManager.isEmailValid(email)) {
            emailInput.error = "Invalid email"
        } else {
            emailInput.error = null
        }


        if (!credentialsManager.isPasswordValid(password)) {
            passwordInput.error = "Password cannot be empty"
        } else {
            passwordInput.error = null
        }


        val user = credentialsManager.credentialsMap[email]
        if (user != null && user.password == password) {
            Toast.makeText(requireContext(), "Login successful", Toast.LENGTH_SHORT).show()
        } else {
            passwordInput.error = "Incorrect email or password"
        }
    }

    private fun onClickGoSignUp() {

        (activity as? CredentialActivity)?.showSignUpFragment()
    }
}
