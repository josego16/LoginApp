package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*setContentView(R.layout.activity_main)*/
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val btnLogin = mainBinding.idBtnLogin
        val editUser = mainBinding.idEtUser
        val editContra = mainBinding.idEtPassword

        btnLogin.setOnClickListener {
            val username = editUser.text.toString()
            val contra = editContra.text.toString()
            if (username.isNotEmpty() && contra.isNotEmpty()) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("username", username)
                intent.putExtra("password",contra)
                startActivity(intent)
            } else {
                editUser.error = "Usuario incorrecto"
                editContra.error = "Contraseña incorrecta"
            }
        }
    }
}