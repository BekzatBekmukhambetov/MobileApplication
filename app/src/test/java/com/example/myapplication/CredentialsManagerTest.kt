// Put your package name here. Check your activity for reference.
package com.example.myapplication

import com.example.myapplication.CredentialsManager
import junit.framework.Assert.assertEquals
import org.junit.Test


class CredentialsManagerTest {

    private val credentialsManager = CredentialsManager()


    // Test empty email
    @Test
    fun givenEmptyEmail_thenReturnFalse(){
        val isPasswordValid = credentialsManager.isEmailValid("")
        assertEquals(false,isPasswordValid)
    }

    // Test wrong email format
    @Test
    fun givenWrongEmailFormat_thenReturnFalse(){
        val isEmailValid = credentialsManager.isEmailValid("alex")
        assertEquals(false,isEmailValid)
    }


    // Test proper email
    @Test
    fun givenProperEmail_thenReturnTrue(){
        val isEmailValid = credentialsManager.isEmailValid("bekmukhambetovbk@gmail.com")
        assertEquals(true,isEmailValid)
    }

    // Test empty password

    @Test
    fun givenEmptyPassword_thenReturnFalse(){
        val isPasswordValid = credentialsManager.isPasswordValid("")
        assertEquals(false,isPasswordValid)
    }
    // Test filled password
    @Test
    fun givenProperPassword_thenReturnTrue(){
        val isPasswordValid = credentialsManager.isPasswordValid("qwerty1234")
        assertEquals(true,isPasswordValid)
    }

    // Test Registration
    @Test
    fun givenValidDetails_thenRegisterSuccessfully() {
        val registrationResult = credentialsManager.register(
            fullName = "Bekzat",
            email = "bekzat@gmail.com",
            phoneNumber = "123456789",
            password = "password123"
        )
        assertEquals("Registration successful", registrationResult)
    }

    // Test Registration with empty name
    @Test
    fun givenEmptyFullName_thenReturnFullNameError() {
        val registrationResult = credentialsManager.register(
            fullName = "",
            email = "bekzat@gmail.com",
            phoneNumber = "123456789",
            password = "232123"
        )
        assertEquals("Full name cannot be empty", registrationResult)
    }

    // Test Registration with invalid format
    @Test
    fun givenInvalidEmailFormat_thenReturnInvalidEmail() {
        val registrationResult = credentialsManager.register(
            fullName = "Bob",
            email = "invalidemail.com",
            phoneNumber = "987654321",
            password = "342432"
        )
        assertEquals("Invalid email format", registrationResult)
    }


    // Test registration with an already taken email
    @Test
    fun givenExistingEmail_thenReturnEmailTaken() {
        // Register first time
        credentialsManager.register(
            fullName = "Beka",
            email = "dog@gmail.com",
            phoneNumber = "123456789",
            password = "password123"
        )

        // Register second time with existed email
        val registrationResult = credentialsManager.register(
            fullName = "BekaClone",
            email = "dog@gmail.com",
            phoneNumber = "1234567823239Clone",
            password = "password123Clone"
        )
        assertEquals("Email is already taken", registrationResult)
    }


}