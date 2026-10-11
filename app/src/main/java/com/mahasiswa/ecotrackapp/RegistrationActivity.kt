package com.mahasiswa.ecotrackapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registration)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<ImageButton>(R.id.btn_back).setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        setupRoleSelection()

        findViewById<Button>(R.id.btn_register_next).setOnClickListener {
            // Logic for registration
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    private fun setupRoleSelection() {
        val roleCitizen = findViewById<LinearLayout>(R.id.role_citizen)
        val roleOfficer = findViewById<LinearLayout>(R.id.role_officer)
        val roleBank = findViewById<LinearLayout>(R.id.role_bank)

        val roles = listOf(roleCitizen, roleOfficer, roleBank)

        roles.forEach { roleLayout ->
            roleLayout.setOnClickListener { v ->
                roles.forEach { r -> 
                    r.isSelected = false 
                    (r.getChildAt(0) as? ImageView)?.imageTintList = 
                        getColorStateList(R.color.gray3)
                    (r.getChildAt(1) as? TextView)?.setTextColor(getColor(R.color.gray3))
                }
                v.isSelected = true
                val selectedLayout = v as? LinearLayout
                val selectedIcon = selectedLayout?.getChildAt(0) as? ImageView
                val selectedText = selectedLayout?.getChildAt(1) as? TextView
                
                selectedIcon?.imageTintList = getColorStateList(R.color.g2)
                selectedText?.setTextColor(getColor(R.color.g2))
            }
        }
        
        // Initial state
        roleCitizen.isSelected = true
        (roleCitizen.getChildAt(0) as? ImageView)?.imageTintList = getColorStateList(R.color.g2)
        (roleCitizen.getChildAt(1) as? TextView)?.setTextColor(getColor(R.color.g2))
    }
}
