// Put your package name here. Check your activity for reference.
package com.example.myapplication

class CredentialsManager {

    private val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$".toRegex()

    fun isEmailValid(email: String): Boolean {
        return email.isNotEmpty() && emailRegex.matches(email)
    }


    fun isPasswordValid(password: String):Boolean{
        return password.isNotEmpty();
    }

}