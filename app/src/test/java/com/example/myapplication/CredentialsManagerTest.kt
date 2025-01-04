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
    fun givenFilledPassword_thenReturnTrue(){
        val isPasswordValid = credentialsManager.isPasswordValid("qwerty1234")
        assertEquals(true,isPasswordValid)
    }

}