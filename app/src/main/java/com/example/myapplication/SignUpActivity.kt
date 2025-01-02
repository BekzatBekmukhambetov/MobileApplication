package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_screen)
    }

    fun onClickGoLogin(view : View){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}