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
        initEvent()
    }

    private fun initEvent() {
        mainBinding.idBtnLogin.setOnClickListener {
            val username = mainBinding.idEtUser.text.toString()
            val contra = mainBinding.idEtPassword.text.toString()

            if (validarDatos(username) && validarDatos(contra)) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("username", username)
                intent.putExtra("password", contra)
                startActivity(intent)
            } else {
                mainBinding.idEtUser.error = "Usuario incorrecto"
                mainBinding.idEtPassword.error = "Contraseña incorrecta"
            }
        }
    }

    private fun validarDatos(datos: String): Boolean {
        val regex = Regex("^[a-zA-Z][0-9a-zA-z]+$")
        return datos.matches(regex)
    }
}