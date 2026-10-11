package com.mahasiswa.ecotrackapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.btn_login).setOnClickListener {
            val email = findViewById<android.widget.EditText>(R.id.et_email).text.toString()
            val password = findViewById<android.widget.EditText>(R.id.et_password).text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                android.widget.Toast.makeText(this, "Email dan password harus diisi", android.widget.Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<TextView>(R.id.tv_signup).setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
    }
}
