package com.example.uts2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class LoginActivity : Activity() {
    private var etUsername: EditText? = null
    private var etPassword: EditText? = null
    private var btnlogin: Button? = null
    private val username = "admin"
    private val password = "admin"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etUsername = findViewById<View>(R.id.etUsername) as EditText
        etPassword = findViewById<View>(R.id.etPassword) as EditText
        btnlogin = findViewById<View>(R.id.btnlogin) as Button
        btnlogin!!.setOnClickListener {
            if (etUsername!!.getText().toString()
                    .equals(username, ignoreCase = true) && etPassword!!.getText().toString()
                    .equals(password, ignoreCase = true)
            ) {
                // Simpan username ke SharedPreferences
                val sharedPreferences =
                    getSharedPreferences("MyPrefs", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("username", username)
                editor.apply()
                val login = Intent(
                    this@LoginActivity,
                    MainActivity::class.java
                )
                startActivity(login)
                Toast.makeText(this@LoginActivity, "Selamat Datang", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(
                    this@LoginActivity,
                    "Username atau Password Yang Anda Masukkan Salah!!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}