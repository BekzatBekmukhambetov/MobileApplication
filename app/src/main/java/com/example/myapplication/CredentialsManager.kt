// Put your package name here. Check your activity for reference.
package com.example.myapplication



class CredentialsManager {

    private val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$".toRegex()
     val credentialsMap = mutableMapOf<String, User>()

    companion object {
        val instance = CredentialsManager()
    }

    fun isEmailValid(email: String): Boolean {
        return email.isNotEmpty() && emailRegex.matches(email)
    }


    fun isPasswordValid(password: String):Boolean{
        return password.isNotEmpty();
    }


    fun register(fullName: String, email: String, phoneNumber: String, password: String): String {
        val normalizedEmail = email.trim().lowercase()

        if (fullName.isEmpty()) {
            return "Full name cannot be empty"
        }

        if (!isEmailValid(normalizedEmail)) {
            return "Invalid email format"
        }

        if (!isPasswordValid(password)) {
            return "Password cannot be empty"
        }

        if (credentialsMap.containsKey(normalizedEmail)) {
            return "Email is already taken"
        }

        credentialsMap[normalizedEmail] = User(fullName, phoneNumber, password)
        return "Registration successful"
    }

}