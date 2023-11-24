package com.example.loginapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var secondBinding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*setContentView(R.layout.activity_second)*/
        secondBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(secondBinding.root)

        val txtUsername = secondBinding.txtUsername
        val txtPassword = secondBinding.txtPassword

        val name: String = intent.extras?.getString("username").orEmpty()
        val pass: String = intent.extras?.getString("password").orEmpty()
        txtUsername.text = "Usuario: $name"
        txtPassword.text = "Contraseña: $pass"
    }
}