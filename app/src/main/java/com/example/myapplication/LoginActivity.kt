package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)
    }

    fun onClickGoSignUp(view : View){
    val intent = Intent(this,SignUpActivity::class.java)
        startActivity(intent)
        finish()
    }
}