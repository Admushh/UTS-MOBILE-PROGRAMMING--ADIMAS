package com.example.uts2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val nama = findViewById<EditText>(R.id.nama)
        val nim = findViewById<EditText>(R.id.nim)
        val kelas = findViewById<EditText>(R.id.kelas )
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val name = nama.text.toString()
            val nim = nim.text.toString()
            val kelas = kelas.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (name.isNotEmpty() && nim.isNotEmpty() && kelas.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("nama", name)
                editor.putString("nim", nim)
                editor.putString("kelas", kelas)
                editor.putString("email", email)
                editor.putString("password", password)
                editor.apply()

                Toast.makeText(this, "Akun berhasil dibuat!", Toast.LENGTH_SHORT).show()
                finish()  // Close this activity and return to login
            } else {
                Toast.makeText(this, "Pastikan semua kotak terisi", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
