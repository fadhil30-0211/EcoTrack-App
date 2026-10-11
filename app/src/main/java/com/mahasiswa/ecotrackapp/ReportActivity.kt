package com.mahasiswa.ecotrackapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReportActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_report)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<ImageButton>(R.id.btn_back_report).setOnClickListener {
            finish()
        }

        setupCategorySelection()

        findViewById<Button>(R.id.btn_submit_report).setOnClickListener {
            Toast.makeText(this, "Laporan berhasil dikirim!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun setupCategorySelection() {
        val catOrganic = findViewById<LinearLayout>(R.id.cat_organic)
        val catAnorganic = findViewById<LinearLayout>(R.id.cat_anorganic)
        val catB3 = findViewById<LinearLayout>(R.id.cat_b3)

        val categories = listOf(catOrganic, catAnorganic, catB3)

        categories.forEach { catLayout ->
            catLayout.setOnClickListener { v ->
                categories.forEach { c -> 
                    c.isSelected = false 
                    val icon = c.getChildAt(0) as? ImageView
                    val text = c.getChildAt(1) as? TextView
                    
                    // Reset to default illustrative colors or gray if not active
                    icon?.imageTintList = getColorStateList(R.color.gray3)
                    text?.setTextColor(getColor(R.color.gray3))
                }
                v.isSelected = true
                val selectedLayout = v as? LinearLayout
                val selectedIcon = selectedLayout?.getChildAt(0) as? ImageView
                val selectedText = selectedLayout?.getChildAt(1) as? TextView

                // Apply active brand color
                selectedIcon?.imageTintList = getColorStateList(R.color.g2)
                selectedText?.setTextColor(getColor(R.color.g2))
            }
        }

        // Default selection
        catOrganic.isSelected = true
        (catOrganic.getChildAt(0) as? ImageView)?.imageTintList = getColorStateList(R.color.g2)
        (catOrganic.getChildAt(1) as? TextView)?.setTextColor(getColor(R.color.g2))
    }
}
