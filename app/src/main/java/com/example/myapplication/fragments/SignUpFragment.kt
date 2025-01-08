package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.CredentialActivity
import com.example.myapplication.CredentialsManager
import com.example.myapplication.R

import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class SignUpFragment : Fragment() {

    private lateinit var fullNameInput: TextInputLayout
    private lateinit var emailInput: TextInputLayout
    private lateinit var phoneInput: TextInputLayout
    private lateinit var passwordInput: TextInputLayout
    private lateinit var signUpButton: MaterialButton
    private lateinit var loginTextButton: TextView
    private val credentialsManager = CredentialsManager.instance

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        fullNameInput = view.findViewById(R.id.input_full_name)
        emailInput = view.findViewById(R.id.input_email)
        phoneInput = view.findViewById(R.id.input_phone_number)
        passwordInput = view.findViewById(R.id.input_password)
        signUpButton = view.findViewById(R.id.button_1)
        loginTextButton = view.findViewById(R.id.BottomText)

        signUpButton.setOnClickListener { handleSignUp() }


        loginTextButton.setOnClickListener {
            (activity as? CredentialActivity)?.showLoginFragment()
        }

        return view
    }

    private fun handleSignUp() {
        val fullName = fullNameInput.editText?.text.toString()
        val email = emailInput.editText?.text.toString()
        val phoneNumber = phoneInput.editText?.text.toString()
        val password = passwordInput.editText?.text.toString()

        val result = credentialsManager.register(fullName, email, phoneNumber, password)

        if (result == "Registration successful") {
            Toast.makeText(requireContext(), result, Toast.LENGTH_SHORT).show()
            (activity as? CredentialActivity)?.showLoginFragment()
        } else {
            Toast.makeText(requireContext(), result, Toast.LENGTH_SHORT).show()
        }
    }
}

